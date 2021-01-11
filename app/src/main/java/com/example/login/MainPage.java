package com.example.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity {

    TextView nome, cpf, data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        nome = findViewById(R.id.textNome);
        cpf = findViewById(R.id.textCpf);
        data = findViewById(R.id.textData);
        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String text1 = sp.getString("nome", "");
        String text2 = sp.getString("cpf", "");
        String text3 = sp.getString("data", "");
        nome.setText(text1);
        cpf.setText(text2);
        data.setText(text3);
    }
}
