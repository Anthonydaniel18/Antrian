package com.example.antrianmad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "antrian";
    public static int DB_VERSION = 1;

    public static String SQL_CREATE_ANTRIAN_TABLE=
            "CREATE TABLE IF NOT EXISTS antrian(" +
                    "id integer primary key autoincrement, " +
                    "nama text, "+
                    "notel text, "+
                    "tenant text," +
                    "waktu text" +
                    ")";

    public static String SQL_DROP_ANTRIAN_TABLE = "DROP TABLE IF EXISTS antrian";

    void refreshTable(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ANTRIAN_TABLE);
    }

    public DBHelper(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        refreshTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        refreshTable(db);
    }
}


