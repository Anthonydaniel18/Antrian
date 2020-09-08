package com.example.antrianmad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class listmakananActivity extends AppCompatActivity {
    TextView judul, makanan1, makanan2, makanan3, makanan4;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listmakanan);
        judul = findViewById(R.id.judulPage);
        makanan1 = findViewById(R.id.makan1);
        makanan2 = findViewById(R.id.makan2);
        makanan3 = findViewById(R.id.makan3);
        makanan4 = findViewById(R.id.makan4);
        next = findViewById(R.id.btn_next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent input = new Intent(listmakananActivity.this, kantin1.class);
                startActivity(input);
            }
        });
    }
}