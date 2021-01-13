package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nome, senha;
    TextView cadastrar;
    Button confirmar;
    SharedPreferences shared;
    String nomeStr, senhaStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.textoNome);
        senha = findViewById(R.id.textoSenha);
        confirmar = findViewById(R.id.button);
        cadastrar = findViewById(R.id.textCadastro);

        confirmar.setOnClickListener(v -> {
            nomeStr = nome.getText().toString();
            senhaStr = senha.getText().toString();
            shared = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
            String chkNome = shared.getString("nome", "");
            String chkSenha = shared.getString("senha", "");
            if(nomeStr.equals(chkNome) && chkSenha.equals(senhaStr) && !senhaStr.isEmpty() && !nomeStr.isEmpty()){
                Intent intent = new Intent(MainActivity.this, MainPage.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(), "Senha Incorreta!", Toast.LENGTH_LONG).show();
            }
        });

        cadastrar.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
        });
    }
}