package com.example.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity {

    TextView nome, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        nome = findViewById(R.id.textNome);
        email = findViewById(R.id.textEmail);
        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String text1 = sp.getString("nome", "");
        String text2 = sp.getString("email", "");
        nome.setText(text1);
        email.setText(text2);
    }
}
