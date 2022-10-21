package com.example.kalkulatorbidangdatar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int type;
    EditText btnNilai1, btnNilai2;
    TextView txtTampilLuas, txtTampilKeliling;
    Button btnPersegi, btnSegitiga, btnLingkaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPersegi = findViewById(R.id.btn_persegi);
        btnSegitiga = findViewById(R.id.btn_segitiga);
        btnLingkaran = findViewById(R.id.btn_lingkaran);

        btnNilai1 = findViewById(R.id.btn_nilai1);
        btnNilai2
                = findViewById(R.id.btn_nilai2);

        txtTampilLuas = findViewById(R.id.txt_tampil_luas);
        txtTampilKeliling = findViewById(R.id.txt_tampil_keliling);

        btnPersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cariLuasdanKeliling(1);
            }
        });

        btnSegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cariLuasdanKeliling(2);
            }
        });

        btnLingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cariLuasdanKeliling(3);
            }
        });
    }

    public void cariLuasdanKeliling(int type) {
        double num1, num2, r, pi = Math.PI, luas, keliling;

        if (btnNilai1.getText().toString().isEmpty() || btnNilai2.getText().toString().isEmpty()) {
            num1 = 0;
            num2 = 0;
        } else {
            num1 = Double.parseDouble(btnNilai1.getText().toString());
            num2 = Double.parseDouble(btnNilai2.getText().toString());
        }

        r = num1 / 2;
        switch (type) {
            case 1:
                if (num1 == 0 || num2 == 0) {
                    validateInput();
                } else {
                    luas = num1 * num2;
                    keliling = (2 * num1) + (2 * num2);
                    tampilLuasKeliling(luas, keliling);
                }
                break;
            case 2:
                if (num1 == 0 || num2 == 0) {
                    validateInput();
                } else {
                    luas = (num1 * num2) / 2;
                    keliling = 3 * num1;
                    tampilLuasKeliling(luas, keliling);
                }
                break;
            case 3:
                if (num1 == 0 || num2 == 0) {
                    validateInput();
                } else {
                    luas = pi * r * r;
                    keliling = pi * num1;
                    tampilLuasKeliling(luas, keliling);
                }
        }
    }

    public void validateInput() {
        AlertDialog.Builder myalert = new AlertDialog.Builder(this);
        myalert.setTitle("Perhatian");
        myalert.setMessage("Data Tidak Boleh Kosong");
        myalert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        myalert.show();
    }

    public void tampilLuasKeliling(double luas, double keliling) {
        txtTampilLuas.setText(Double.toString(luas));
        txtTampilKeliling.setText(Double.toString(keliling));
    }
}