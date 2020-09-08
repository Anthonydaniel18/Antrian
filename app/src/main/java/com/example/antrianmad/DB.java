package com.example.antrianmad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.Display;

import java.util.Vector;

public class DB {

    public static Vector<Models> listantrian = new Vector<>();

    public static boolean HAS_SYNC = false;

    public static void addAntrian(String namaOrang, String notelOrang, String antrianOrang, String kantinOrang, Context ctx){
        //listantrian.add(new Models(namaOrang,notelOrang,antrianOrang,kantinOrang));

        DBHelper helper = new DBHelper(ctx);
        SQLiteDatabase db = helper.getWritableDatabase();

        String query = String.format("INSTER INTO ANTRIAN (namaOrang, notelOrang, antrianOrang, kantinOrang) VALUES ('%s','%s','%s','%s'))", namaOrang, notelOrang, antrianOrang, kantinOrang);
        db.execSQL(query);
    }
}
