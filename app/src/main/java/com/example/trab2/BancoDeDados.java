package com.example.trab2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados extends SQLiteOpenHelper {
    private static BancoDeDados mInstancia = null;
    private Context mContext;

    /* info do banco */
    private static final String NOME_BANCO = "trabalho";
    private static final int VERSAO_BANCO = 1;

    /* nome das tabelas no banco */
    /* usuarios */
    private static final String TABLE_USUARIOS = "usuarios";
    /* colunas */
    private static final String USUARIOS_ID = "id";
    private static final String USUARIOS_LOGIN = "login";
    private static final String USUARIOS_SENHA = "senha";

    public static BancoDeDados getInstance(Context context) {
        if (mInstancia == null) {
            mInstancia = new BancoDeDados(context.getApplicationContext());
        }
        return mInstancia;
    }

    /* construtor */
    private BancoDeDados(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
        this.mContext = context;
    }

    /* cria tabelas se nao existir */
    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("oNCreate");
        // Para teste
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS);

        String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_USUARIOS + "("
                + USUARIOS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + USUARIOS_LOGIN + " TEXT UNIQUE,"
                + USUARIOS_SENHA + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

        // Para teste
        addUsuarioDb(db, new Usuario(0, "teste", "123"));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // dropa todas as tabelas antigas
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS);

        // cria novamente
        onCreate(db);
    }

    public void addUsuarioDb(SQLiteDatabase db, Usuario usu) {

        ContentValues values = new ContentValues();
        values.put(USUARIOS_LOGIN, usu.getLogin());
        values.put(USUARIOS_SENHA, usu.getSenha());

        db.insert(TABLE_USUARIOS, null, values);
    }

    public void addUsuario(Usuario usu) {
        addUsuarioDb(this.getWritableDatabase(), usu);
    }

    public Usuario getUsuario(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USUARIOS, new String[] { USUARIOS_ID,
                        USUARIOS_LOGIN, USUARIOS_SENHA }, USUARIOS_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor.moveToFirst()) {
            Usuario usuario = new Usuario(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2));
            return usuario;
        }

        return null;
    }

    public Usuario getUsuarioLogin(String login) {
        SQLiteDatabase db = this.getReadableDatabase();
        System.out.println("Procurando " + login);

        Cursor cursor = db.query(TABLE_USUARIOS, new String[] { USUARIOS_ID,
                        USUARIOS_LOGIN, USUARIOS_SENHA }, USUARIOS_LOGIN + "=?",
                new String[] { login }, null, null, null, null);

        if (cursor.moveToFirst()) {
            Usuario usuario = new Usuario(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2));
            return usuario;
        }

        return null;
    }


}
