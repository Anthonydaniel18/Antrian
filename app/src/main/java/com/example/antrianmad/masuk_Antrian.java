package com.example.antrianmad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class masuk_Antrian extends AppCompatActivity {

    Button lanjut, balik;
    TextView namapasti, telponpasti,toko,noantri;
    String nama, nomor, kantin, waktu, antri;

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;

    void init(){
        lanjut = findViewById(R.id.Oke);
        balik = findViewById(R.id.Balik);
        namapasti = findViewById(R.id.NamaFix);
        telponpasti = findViewById(R.id.NotelFix);
        toko = findViewById(R.id.judulConfirm);
        noantri = findViewById(R.id.posisiantri);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk__antrian);

        openHelper = new DBHelper(this);
        db = openHelper.getWritableDatabase();

        init();

        Cursor c1 = db.rawQuery("SELECT COUNT(*) FROM "+ DBHelper.DB_NAME,null);

        c1.moveToFirst();

        int idx = c1.getInt(0);

        if(idx<1){

            antri = "1";

        }else {
            Cursor c = db.rawQuery("SELECT * FROM " + DBHelper.DB_NAME, null);

            c.moveToLast();
            int nomorantrian = c.getInt(0) +1;

            antri = String.valueOf(nomorantrian);

        }

        Intent getIntent = getIntent();
        kantin = getIntent.getStringExtra("judulConfirm");
        nama = getIntent.getStringExtra("nama");
        nomor = getIntent.getStringExtra("notel");

        DateFormat df = new SimpleDateFormat("kk:mm");
        waktu = df.format(Calendar.getInstance().getTime());

        namapasti.setText(nama);
        telponpasti.setText(nomor);
        noantri.setText(antri);

        kantin = toko.getText().toString();

        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //masukin database, nama, notel, nama kantin, sama nomor antriannya
                //balikin ke mainactivity awal
                //setiap nambah antrian, +1
                insertData(nama,nomor,kantin,waktu);
                Intent next = new Intent(masuk_Antrian.this, MainActivity.class);
                startActivity(next);
            }
        });

        balik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent balek = new Intent(masuk_Antrian.this, kantin1.class);
                startActivity(balek);

            }
        });

    }

    void insertData(String nama,String notel,String kantin,String waktu){
        ContentValues cv = new ContentValues();
        cv.put("nama",nama);
        cv.put("notel",nomor);
        cv.put("tenant",kantin);
        cv.put("waktu",waktu);
        db.insert(DBHelper.DB_NAME,null,cv);
    }
}
