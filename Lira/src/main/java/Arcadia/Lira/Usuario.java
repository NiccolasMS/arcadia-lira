package Arcadia.Lira;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Usuario {
    private Integer idUsuario;
    private String email;
    private String senha;
    private String nome;
    private String telefone;

    private Boolean autenticado = false;
    public List<Encomenda> encomendas;


    //Quando o objeto usuário for criado, iremos dar um insert no banco , assim o id será auto_increment
    //Sendo assim não precisamos dar set idUsuario
    public Usuario(String email, String senha, String nome, String telefone)
    {
        //Gerador de id provisório, necessita de validação para não cadastrar 2 id's iguais
        Random gerador = new Random();
        this.idUsuario = gerador.nextInt(25);

        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
        this.autenticado = false;

        this.encomendas = new ArrayList<>();
    }

    public abstract void cadastrarEncomenda(Encomenda encomenda);
    public abstract List<Encomenda> exibirEncomendas();


    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    public boolean isValido() {
        return email!=null && email.length() >= 3
                && senha!=null && senha.length() >= 3;
    }

    public boolean validarSenha(String senha){
        return this.senha.equals(senha);
    }
    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
