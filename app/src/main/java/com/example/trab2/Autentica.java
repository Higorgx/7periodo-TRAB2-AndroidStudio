package com.example.trab2;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

public class Autentica {
    static Usuario userLogado;
    private static Autentica mInstancia = null;
    private Context mContext;

    private Autentica(Context context) {
        this.mContext = context;
    }

    public static Autentica getInstance(Context context) {
        if (mInstancia == null) {
            mInstancia = new Autentica(context);
        }
        return mInstancia;
    }

    public static Usuario getUserLogado() {
        return userLogado;
    }

    /* faz login e retorna true em caso de sucesso */
    public boolean fazerLogin(String usuario, String senha) {
        BancoDeDados banco = BancoDeDados.getInstance(mContext);
        Usuario user = banco.getUsuarioLogin(usuario);

        if (user == null) {
            Toast.makeText(mContext, "Usuário ou senha incorretos",
                    Toast.LENGTH_LONG).show();
            return false;
        }

        if (user.getSenha() != senha) {
            Toast.makeText(mContext, "Usuário ou senha incorretos",
                    Toast.LENGTH_LONG).show();
            return false;
        }

        userLogado = user;
        System.out.println(user.toString());

        // abrir activity
        return true;
    }

    public static void logout() {
        userLogado = null;
    }

}
