package com.example.antrianmad;

import android.app.AlertDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.Vector;

public class Adapter extends BaseAdapter {

    Context ctx;
    Vector<Models> antri = DB.listantrian;
    LayoutInflater inflater;
    Vector<String> namacs, notelcs, antrics, kantinnya;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;

    //public Adapter(Context ctx, Vector<String> namacs, Vector<String> notelcs, Vector<String> antrics, Vector<String> kantinnya){
        public Adapter(Context ctx){
        this.ctx = ctx;
        //Vector<Models> antrian = new Vector<Models>();
        //this.antri.addAll(antrian);
        //this.namacs = namacs;
        //this.notelcs = notelcs;
        //this.antrics = antrics;
        //this.kantinnya = kantinnya;
    }

    @Override
    public int getCount() {
        return DB.listantrian.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View v, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v  = inflater.inflate(R.layout.layout_history,null);

        Models m = DB.listantrian.get(position);

        TextView nama = v.findViewById(R.id.nama);
        TextView notel = v.findViewById(R.id.notel);
        TextView toko = v.findViewById(R.id.toko);
        TextView jam = v.findViewById(R.id.jam);
        //Button hapus = v.findViewById(R.id.hapus);

        TextView ids = v.findViewById(R.id.id);

        final int id = Integer.valueOf(m.idantri);

        String idx = String.valueOf(id);

        ids.setText(idx);
        nama.setText(m.namaOrang);
        notel.setText(m.notelOrang);
        toko.setText(m.kantinOrang);
        jam.setText(m.waktu);

        /*
        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder bd = new AlertDialog.Builder(ctx);
                bd.setMessage("yakin ingin membatalkan");

                DB.listantrian.remove(position);

                openHelper = new DBHelper(ctx);
                db = openHelper.getWritableDatabase();
                String sql = "DELETE FROM antrian WHERE id = " + id;
                db.execSQL(sql);

                notifyDataSetChanged();

            }
        });

         */

        return v;
    }

}
