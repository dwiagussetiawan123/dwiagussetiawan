package com.example.dwiagussetiawan;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnKucing, btnAnjing, btnBuaya;
    Button button;
    Intent pindah;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnKucing = findViewById(R.id.btn_buka_ras_kucing);
        btnAnjing = findViewById(R.id.btn_buka_ras_anjing);
        btnBuaya = findViewById(R.id.btn_buka_ras_ular);
        button = (Button) findViewById(R.id.dialog_button);
        btnKucing.setOnClickListener(view -> bukaGaleri("kucing"));
        btnAnjing.setOnClickListener(view -> bukaGaleri("anjing"));
        btnBuaya.setOnClickListener(view -> bukaGaleri("ular"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(pindah);

            }
        });
    }

    private void bukaGaleri(String jenisHewan) {
        Log.d("MAIN", "Buka activity galeri");
        Intent intent = new Intent(this, DaftarHewanActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisHewan);
        startActivity(intent);
    }

    private void mainactivity(String jenisHewan) {
        Log.d("MAIN", "Buka Main Activity");
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}