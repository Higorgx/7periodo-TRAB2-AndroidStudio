package com.example.trab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void listarUsuarios(View view){
        Intent it = new Intent ( this, Activity_listarUsr.class);

        startActivity(it);

    }
    public void listarUsuariosLog(View view){
        Intent it = new Intent ( this, Activity_listarUsrLog.class);

        startActivity(it);

    }
}