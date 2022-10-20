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
    EditText edtPad, edtLt;
    TextView txtDisplayLuas, txtDisplayKeliling;
    Button btnPersegi, btnSegitiga, btnLingkaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPersegi = findViewById(R.id.btn_persegi);
        btnSegitiga = findViewById(R.id.btn_segitiga);
        btnLingkaran = findViewById(R.id.btn_lingkaran);

        edtPad = findViewById(R.id.btn_nilai1);
        edtLt = findViewById(R.id.btn_nilai2);

        txtDisplayLuas = findViewById(R.id.txt_display_luas);
        txtDisplayKeliling = findViewById(R.id.txt_display_keliling);

        btnPersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findLuasKeliling(1);
            }
        });

        btnSegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findLuasKeliling(2);
            }
        });

        btnLingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findLuasKeliling(3);
            }
        });
    }

    public void findLuasKeliling(int type) {
        double num1, num2, r, pi = Math.PI, luas, keliling;

        if (edtPad.getText().toString().isEmpty() || edtLt.getText().toString().isEmpty()) {
            num1 = 0;
            num2 = 0;
        } else {
            num1 = Double.parseDouble(edtPad.getText().toString());
            num2 = Double.parseDouble(edtLt.getText().toString());
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
        txtDisplayLuas.setText(Double.toString(luas));
        txtDisplayKeliling.setText(Double.toString(keliling));
    }
}