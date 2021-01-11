package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nome, email;
    Button confirmar;
    SharedPreferences shared;
    String nomeStr, emailStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.textoNome);
        email = findViewById(R.id.textoEmail);
        confirmar = findViewById(R.id.button);

        confirmar.setOnClickListener(v -> {
            nomeStr = nome.getText().toString();
            emailStr = email.getText().toString();
            shared = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
            Log.d("click", "clicou");
            SharedPreferences.Editor edit = shared.edit();
            edit.putString("nome", nomeStr);
            edit.putString("email", emailStr);
            edit.commit();
            String test = nomeStr;
            Toast.makeText(MainActivity.this, "Informações Cadastradas com Sucesso", Toast.LENGTH_SHORT);
            Intent intent = new Intent(MainActivity.this, MainPage.class);
            startActivity(intent);
        });
    }
}