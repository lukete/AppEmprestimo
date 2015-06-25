package com.example.amanda.appemprestimo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by amanda on 15/06/15.
 */
public class DBHelper extends SQLiteOpenHelper{

    // NOME DO BANCO
    private static final String NOME_BANCO_DADOS    = "app_emprestimo";

    // Versão do banco de dados
    private static final int VERSAO_BANCO_DADOS     = 3;

    public DBHelper(Context context){
        super(context, NOME_BANCO_DADOS, null, VERSAO_BANCO_DADOS);
    }

    // METODO CHAMADO QUANDO NAO EXISTE BANCO DE DADOS, LOGO ELE CRIA
    @Override
    public void onCreate(SQLiteDatabase db) {
        /** Tabela de entidade(seve tambem para AMIGO, mudando o TIPO para definir
         * @param tipo A as amigo e U as usuário
         */
        String sql_create_tabela_entidade = "CREATE TABLE entidade("
                                            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                            + "nome TEXT,"
                                            + "foto TEXT,"
                                            + "tipo TEXT,"
                                            + "senha TEXT,"
                                            + "id_principal INTEGER"
                                            + ")";
        /* EXECUTANDO QUERY */
        db.execSQL(sql_create_tabela_entidade);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        /* QUERY DELETAR TABELA */
        String sql_drop_tabela_entidade = "DROP TABLE entidade";

        /* EXECUTANDO QUERY */
        db.execSQL(sql_drop_tabela_entidade);

        /* CHAMANDO CRIAÇÃO BANCO NOVAMENTE */
        onCreate(db);

    }

    // INSERT DA ENTIDADE
    public void insertEntidade(Entidade entidade){

        // RECUPERANDO BASE DADOS
        // Recuperando com direito a ESCRITA
        SQLiteDatabase db = getWritableDatabase();

        // OBJETO
        ContentValues cv  = new ContentValues();

        // INSERINDO DADOS
        cv.put("nome", entidade.getNome());
        cv.put("foto", entidade.getFoto());
        cv.put("tipo", entidade.getFoto());
        cv.put("senha", entidade.getSenha());
        cv.put("id_principal", entidade.getId_principal());

        // INSERE
        db.insert("entidade", null, cv);

        // FECHA CONEXAO
        db.close();
    }

    // BUSCAR ENTIDADE LOGIN
    public boolean verificaExisteUsuario(String nome, String senha){

        // RECUPERANDO BASE DADOS
        // Recuperando com direito a LEITURA
        SQLiteDatabase db   = getReadableDatabase();

        // CONSULTA
        String sql_consulta = "";

        // CONSULTA
        sql_consulta = "SELECT * from entidade where tipo = 'U' and nome = '"+nome+"' and senha = '"+nome+"'";

        // RESULTADO DA QUERY, E POSSIBILITA INTERAR SOBRE ELES
        Cursor c = db.rawQuery(sql_consulta, null);

        // Fechando BANCO
        db.close();

        // VERIFICANDO SE OBTEVE RESULTADO
        return c.moveToFirst();
    }
    // BUSCAR ENTIDADE
    public Entidade getEntidade(String nome, String tipo){
        Entidade entidade = null;
        // RECUPERANDO BASE DADOS
        // Recuperando com direito a LEITURA
        SQLiteDatabase db   = getReadableDatabase();

        // CONSULTA
        String sql_consulta = "";

        if(tipo.equalsIgnoreCase("A")){
            // CONSULTA
           sql_consulta = "SELECT * from entidade where tipo = 'A' and nome = "+nome+"'";
        }
        else{
            // CONSULTA
           sql_consulta = "SELECT * from entidade where tipo = 'U' and nome = '"+nome+"'";
        }

        // RESULTADO DA QUERY, E POSSIBILITA INTERAR SOBRE ELES
        Cursor c = db.rawQuery(sql_consulta, null);

        // VERIFICANDO SE OBTEVE RESULTADO
        if(c.moveToFirst()){
            // CRIANDO OBJETO
            entidade =  new Entidade();

            // PREENCHENDO OBJETO
            entidade.setId(c.getInt(0));
            entidade.setNome(c.getString(1));
            entidade.setFoto(c.getString(2));
            entidade.setTipo(c.getString(3));
            entidade.setSenha(c.getString(4));
            entidade.setId_principal(c.getInt(5));
        }

        // Fechando BANCO
        db.close();

        return entidade;
    }

    // BUSCAR ENTIDADES
    public ArrayList<Entidade> getAllEntidade(String tipo){
        ArrayList<Entidade> entidades = new ArrayList<Entidade>();
        // RECUPERANDO BASE DADOS
        // Recuperando com direito a LEITURA
        SQLiteDatabase db   = getReadableDatabase();

        //CONSULTA
        String sql_consulta = "";

        if(tipo.equalsIgnoreCase("A")){
            // CONSULTA
            sql_consulta = "SELECT * from entidade where tipo = 'A'";
        }
        else{
            // CONSULTA
            sql_consulta = "SELECT * from entidade where tipo = 'U'";
        }

        // RESULTADO DA QUERY, E POSSIBILITA INTERAR SOBRE ELES
        Cursor c = db.rawQuery(sql_consulta, null);

        // VERIFICANDO SE OBTEVE RESULTADO
        if(c.moveToFirst()){
            // LOOP
            do {
                // CRIANDO OBJETO
                Entidade entidade = new Entidade();

                // PREENCHENDO OBJETO
                entidade.setId(c.getInt(0));
                entidade.setNome(c.getString(1));
                entidade.setFoto(c.getString(2));
                entidade.setTipo(c.getString(3));
                entidade.setSenha(c.getString(4));
                entidade.setId_principal(c.getInt(5));

                // Adicionando na lista
                entidades.add(entidade);

            }while (c.moveToNext());
        }

        // Fechando BANCO
        db.close();

        return entidades;
    }
}
