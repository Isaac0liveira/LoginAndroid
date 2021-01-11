package com.example.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    EditText nome, cpf, senha, confirmaSenha, data;
    Button cadastrar;
    SharedPreferences shared;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        nome = findViewById(R.id.textoNome);
        cpf = findViewById(R.id.textoCpf);
        data = findViewById(R.id.textoData);
        senha = findViewById(R.id.textoSenha);
        confirmaSenha = findViewById(R.id.textoConfirmaSenha);
        cadastrar = findViewById(R.id.botaoCadastrar);
        shared = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        cadastrar.setOnClickListener(v -> {
            if(!nome.getText().toString().isEmpty() && !cpf.getText().toString().isEmpty() && !data.getText().toString().isEmpty() &&
               !senha.getText().toString().isEmpty() && !confirmaSenha.getText().toString().isEmpty()){
                if(senha.getText().toString().equals(confirmaSenha.getText().toString())){
                    SharedPreferences.Editor editor = shared.edit();
                    editor.putString("nome", nome.getText().toString());
                    editor.putString("cpf", cpf.getText().toString());
                    editor.putString("data", data.getText().toString());
                    editor.putString("senha", senha.getText().toString());
                    editor.commit();
                    Intent intent = new Intent(SignUp.this, MainActivity.class);
                    Toast.makeText(getApplicationContext(), "Cadastro Realizado com Sucesso!", Toast.LENGTH_SHORT).show();
                    SystemClock.sleep(2000);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "As senhas não coincidem!", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getApplicationContext(), "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
