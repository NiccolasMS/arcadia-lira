package com.example.arcadia;

public class Usuario {
    private int idUsuario;
    private String email;
    private String senha;
    private String nome;
    private String telefone;
    private Boolean autenticado;

    public Usuario(int idUsuario, String email, String nome) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.nome = nome;
        this.autenticado = false;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }

    public boolean validarSenha(String senha){
        return senha.equals(senha);
    }
}
