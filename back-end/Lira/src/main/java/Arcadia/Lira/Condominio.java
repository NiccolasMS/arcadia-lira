package Arcadia.Lira;

import java.util.ArrayList;
import java.util.List;

public class Condominio {
    private String nome;
    private String cidade;
    private String bairro;
    private String rua;
    private Integer numero;
    private List<Usuario> usuarios;

    public Condominio(String nome, String cidade, String bairro, String rua, Integer numero) {
        this.nome = nome;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;

        usuarios = new ArrayList<>();
    }

    public void cadastrarMorador(Morador morador)
    {
        usuarios.add(morador);
    }

    public void cadastrarPorteiro(Porteiro porteiro)
    {
        usuarios.add(porteiro);
    }

    @Override
    public String toString() {
        return "Condominio{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", rua='" + rua + '\'' +
                ", numero=" + numero;
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
