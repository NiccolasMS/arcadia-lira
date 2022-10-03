package dominio;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Usuario<T> {
    @Id
    private Integer idUsuario;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String senha;
    @NotBlank
    private String nome;
    //Validação para telefone primeira parte DDD um espaço e um número sendo de telefone começa com 8 ou 9
    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$")
    private String telefone;

    private Boolean autenticado = false;
    private T[] encomendas;
    private int nmrElementos;


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

        this.encomendas = (T[]) new Object[20];
        this.nmrElementos = 0;
    }


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

    public int getNmrElementos() {
        return nmrElementos;
    }

    public void setNmrElementos(int nmrElementos) {
        this.nmrElementos = nmrElementos;
    }

    public T[] getEncomendas() {
        return encomendas;
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
