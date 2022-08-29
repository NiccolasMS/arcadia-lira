import java.util.ArrayList;
import java.util.List;

public class Condominio {
    private String nome;
    private String cidade;
    private String bairro;
    private String rua;
    private Integer numero;
    private List<Encomenda> encomendas;
    private List<Usuario> usuarios;

    public Condominio(String nome, String cidade, String bairro, String rua, Integer numero) {
        this.nome = nome;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;

        encomendas = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public Condominio(String nome, String cidade, String bairro, String rua, Integer numero, List<Encomenda> encomendas, List<Usuario> usuarios) {
        this.nome = nome;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.encomendas = encomendas;
        this.usuarios = usuarios;
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

    public List<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(List<Encomenda> encomendas) {
        this.encomendas = encomendas;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
