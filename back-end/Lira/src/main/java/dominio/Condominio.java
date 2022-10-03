package dominio;

import nonapi.io.github.classgraph.json.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Condominio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String nome;
    @NotBlank
    private String cidade;
    @NotBlank
    private String bairro;
    @NotBlank
    private String rua;
    @NotNull
    @Min(0)
    private Integer numero;

    //public Condominio(String nome, String cidade, String bairro, String rua, Integer numero) {
    //    this.nome = nome;
    //    this.cidade = cidade;
    //    this.bairro = bairro;
    //    this.rua = rua;
    //    this.numero = numero;
    //}

     // public void cadastrarMorador(Morador morador)
     //{
     //   usuarios.add(morador);
     //}

     //public void cadastrarPorteiro(Porteiro porteiro)
     //{
     //    usuarios.add(porteiro);
     //}

    @Override
    public String toString() {
        return "Condominio{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", rua='" + rua + '\'' +
                ", numero=" + numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    //public List<Usuario> getUsuarios() {
    //    return usuarios;
    //}

    //public void setUsuarios(List<Usuario> usuarios) {
    //    this.usuarios = usuarios;
    //}
}
