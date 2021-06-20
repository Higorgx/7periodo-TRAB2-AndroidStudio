package com.example.trab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity_listarUsrLog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usr_log);

        ((TextView) findViewById(R.id.usuarioLogadoText)).setText(Autentica.getUserLogado().login);

    }

    public void deletaUserLogado(View v){
        String args[] = new String[1];
        args[0] = Autentica.getUserLogado().login;

        BancoDeDados banco = BancoDeDados.getInstance(v.getContext());

        banco.delUsuarioLogado(args);

        Intent intent = new Intent(v.getContext(), Menu.class);
        startActivity(intent);
    }

}