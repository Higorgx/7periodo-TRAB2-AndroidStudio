package com.example.trab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnEntrar;
    EditText loginTxt;
    EditText senhaTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        loginTxt =findViewById(R.id.editLogin);
        senhaTxt =findViewById(R.id.editSenha);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Autentica aut = Autentica.getInstance(getApplicationContext());
                String login = loginTxt.getText().toString();
                String senha = loginTxt.getText().toString();
                if (aut.fazerLogin(login, senha)) {
                    // fez login, vai pra outra view
                } else {
                    // problema no login
                }
            }
        });
    }


}