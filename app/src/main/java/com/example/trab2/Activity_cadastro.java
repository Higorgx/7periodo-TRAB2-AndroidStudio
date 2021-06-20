package com.example.trab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

    }

    public void cadastrar(View v){

        String login = ((EditText) findViewById(R.id.LoginCadastro)).getText().toString();
        String senha = ((EditText) findViewById(R.id.SenhaCadastro)).getText().toString();

        if(login != null && senha != null && !senha.matches("") && !login.matches("")){

            BancoDeDados banco = BancoDeDados.getInstance(v.getContext());

            Usuario usuario = new Usuario(login, senha);

            banco.addUsuario(usuario);

            Autentica.userLogado = usuario;

            Intent intent = new Intent(v.getContext(), Activity_menu.class);
            startActivity(intent);

        }

        else {
            Toast.makeText(v.getContext(), "Preenche essa merda!", Toast.LENGTH_LONG).show();
        }

    }

}