package com.example.arcadialogin.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Morador extends Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMorador;
    private Boolean status = true;
    private LocalDateTime dataRetorno;
    private String numeroCelular;
    private String bloco;
    private String[] responsaveis = new String[5];
    private Integer controleResponsaveis = 0;

    public Morador() {
    }

    public Morador(Long idUsuario, String nome, String email, String senha, String telefone, Long idMorador, Boolean status, LocalDateTime dataRetorno, String numeroCelular, String bloco, String[] responsaveis, Integer controleResponsaveis) {
        super(idUsuario, nome, email, senha, telefone);
        this.idMorador = idMorador;
        this.status = status;
        this.dataRetorno = dataRetorno;
        this.numeroCelular = numeroCelular;
        this.bloco = bloco;
        this.responsaveis = responsaveis;
        this.controleResponsaveis = controleResponsaveis;
    }

    //    public void assinarQueRecebeu(Encomenda encomenda)
//    {
//        encomenda.setAssinaturaMorador(true);
//    }

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

//    @Override
//    public void cadastrarEncomenda(Encomenda encomenda) {
//        encomendas.add(encomenda);
//    }
//
//    @Override
//    public List<Encomenda> exibirEncomendas() {
//        return encomendas;
//    }
    public Long getId() {
        return idMorador;
    }

    public void setId(Long id) {
        this.idMorador = id;
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
