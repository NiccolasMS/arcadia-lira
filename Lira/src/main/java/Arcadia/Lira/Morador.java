package Arcadia.Lira;

import Arcadia.Lira.Encomenda;
import Arcadia.Lira.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public class Morador extends Usuario {
    private Boolean status = true;
    private LocalDateTime dataRetorno;
    private String numeroCelular;
    private String bloco;
    private String[] responsaveis = new String[5];
    private Integer controleResponsaveis = 0;

    public Morador(String email, String senha, String nome, String telefone, String numeroCelular, String bloco) {
        super(email, senha, nome, telefone);
        this.numeroCelular = numeroCelular;
        this.bloco = bloco;
    }

    public void assinarQueRecebeu(Encomenda encomenda)
    {
        encomenda.setAssinaturaMorador(true);
    }

    public void adicionarResponsavel(String nome)
    {
            responsaveis[controleResponsaveis++] = nome;
    }

    public void excluirResponsavel(String nome)
    {
        for(int i = 0; i < controleResponsaveis; i++)
        {
            if(responsaveis[i].equals(nome))
            {
                for(int index = i; index < responsaveis.length; index++)
                {
                    responsaveis[i] = responsaveis[i+1];
                }
                controleResponsaveis--;
            }
        }
    }

    @Override
    public void cadastrarEncomenda(Encomenda encomenda) {
        encomendas.add(encomenda);
    }

    @Override
    public List<Encomenda> exibirEncomendas() {
        return encomendas;
    }

    public void getResponsaveis() {
        for(int i = 0; i < controleResponsaveis; i ++)
        {
            System.out.println(responsaveis[i]);
        }
    }


    public Boolean getStatus() {
        return status;
    }

    public LocalDateTime getDataRetorno() {
        return dataRetorno;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public String getBloco() {
        return bloco;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setDataRetorno(LocalDateTime dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }
}
