package com.example.amanda.appemprestimo;

/**
 * Created by amanda on 15/06/15.
 */
public class Entidade {

    private int id;
    private int id_principal;
    private String nome;
    private String senha;
    private String foto;
    private String tipo;

    // Construtor padrao
    public Entidade(){}

    // Validação de entidade existe
    public boolean existe_amigo(String nome){
        return true;
    }

    // Faz cadastro do entidade
    public boolean cadastrar_amigo(String nome, String cpf, String foto){
        this.setNome(nome);
        this.setSenha(cpf);
        this.setFoto(foto);
        // Retorno registro inserido
        return false;
    }

    /**  GETTER E SETTER**/
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_principal() {
        return id_principal;
    }

    public void setId_principal(int id_principal) {
        this.id_principal = id_principal;
    }
}
