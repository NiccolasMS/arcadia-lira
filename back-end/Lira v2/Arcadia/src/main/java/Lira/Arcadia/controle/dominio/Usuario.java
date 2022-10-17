package Lira.Arcadia.controle.dominio;

import nonapi.io.github.classgraph.json.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.*;

@MappedSuperclass
public abstract class Usuario {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min=3)
    private String senha;

    @NotBlank
    private String nome;

    //Validação para telefone primeira parte DDD um espaço e um número sendo de telefone começa com 8 ou 9
    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$")
    @NotBlank
    private String telefone;


    private Boolean autenticado = false;

    public Usuario(){

    }
    public Usuario(String email, String senha, String nome, String telefone) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String senha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
}
