package com.example.trab2;

public class Usuario {
    int id = 0;
    String login = "";
    String senha = "";

    int getId() {
        return id;
    }

    public Usuario(int id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    String getLogin() {
        return login;
    }

    String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return String.format("com.example.trab2.Usuario: " + login + " (ID: " + id + ")");
    }
}
