package com.example.trab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void additionalClient(View view){
        Intent it = new Intent ( this, Activity_cadastro.class);

        startActivity(it);

    }
    public void clientLogin(View view){
        Intent it = new Intent ( this, Activity_login.class);

        startActivity(it);

    }

}