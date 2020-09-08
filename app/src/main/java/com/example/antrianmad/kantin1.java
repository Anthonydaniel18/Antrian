package com.example.antrianmad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class kantin1 extends AppCompatActivity {
    Button next;
    TextView nama, notel;
    String name, notelpon;

    void init (){
        next = findViewById(R.id.enter);nama = findViewById(R.id.nama);notel = findViewById(R.id.notel);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kantin1);

        init();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                name = nama.getText().toString();
                notelpon = notel.getText().toString();

                if(name.length()<3){
                    nama.setError("Nama harus lebih dari 3 char");
                } else if(!notelpon.startsWith("+62")) {
                    notel.setError("Diawali dengan +62");
                }else {
                    Intent mulai = new Intent(kantin1.this, masuk_Antrian.class);
                    mulai.putExtra("nama",name);
                    mulai.putExtra("notel",notelpon);
                    startActivity(mulai);
                }
            }
        });

    }
}
