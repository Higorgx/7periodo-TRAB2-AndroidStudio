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

}