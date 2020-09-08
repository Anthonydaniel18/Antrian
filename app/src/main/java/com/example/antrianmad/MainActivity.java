package com.example.antrianmad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelper = new DBHelper(this);
        db = openHelper.getWritableDatabase();

        Button mulai = findViewById(R.id.pilih);
        Button history = findViewById(R.id.history);

        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mulai1 = new Intent(MainActivity.this, pilihantrian.class);

                startActivity(mulai1);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DB.listantrian.clear();

                db = openHelper.getReadableDatabase();

                Cursor c = db.rawQuery("SELECT * FROM " + DBHelper.DB_NAME,null);

                while(c.moveToNext()){
                    DB.listantrian.add(new Models(c.getInt(0),c.getString(1),
                                                    c.getString(2),c.getString(3),c.getString(4)));

                    int a = c.getInt(0);
                    String b = c.getString(1);
                    String e = c.getString(2);
                    String d = c.getString(3);
                    String f = c.getString(4);

                    Log.d("isi histori ",String.format("%d,%s,%s,%s,%s",a,b,e,d,f));
                }


                Intent riwayat = new Intent(MainActivity.this, history.class);
                startActivity(riwayat);
            }
        });

    }
}
