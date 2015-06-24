package com.example.amanda.appemprestimo;

/**
 * Created by amanda on 15/06/15.
 */
public class Amigo {

    private String nome;
    private String cpf;
    private String foto;

    // Construtor padrao
    public Amigo(){}

    // Validação de amigo existe
    public boolean existe_amigo(String nome){
        return true;
    }

    // Faz cadastro do amigo
    public boolean cadastrar_amigo(String nome, String cpf, String foto){
        this.setNome(nome);
        this.setCpf(cpf);
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
