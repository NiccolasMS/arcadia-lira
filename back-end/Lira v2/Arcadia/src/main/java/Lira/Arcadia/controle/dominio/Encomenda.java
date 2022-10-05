package Lira.Arcadia.controle.dominio;

import nonapi.io.github.classgraph.json.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
public class Encomenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Size(max = 13, min = 13)
    private String codigoDeRastreio;

    @NotBlank
    private String nomeMorador;
    @NotBlank
    private String nomeCondominio;
    private String status = "A caminho";
    private String descricao;
    @FutureOrPresent
    private LocalDateTime dataChegada;

    private Long diasEmEspera;
    @FutureOrPresent
    private LocalDateTime dataEntrega;
    private Double taxa = 0.0;
    private Boolean recebidoPorteiro = false;
    private Boolean entreguePorteiro = false;
    private Boolean assinaturaMorador = false;

    public Encomenda(String codigoDeRastreio, String nomeMorador, String nomeCondominio, String descricao) {
        this.codigoDeRastreio = codigoDeRastreio;
        this.nomeMorador = nomeMorador;
        this.nomeCondominio = nomeCondominio;
        this.descricao = descricao;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoDeRastreio() {
        return codigoDeRastreio;
    }

    public void setCodigoDeRastreio(String codigoDeRastreio) {
        this.codigoDeRastreio = codigoDeRastreio;
    }

    public String getNomeMorador() {
        return nomeMorador;
    }

    public void setNomeMorador(String nomeMorador) {
        this.nomeMorador = nomeMorador;
    }

    public String getNomeCondominio() {
        return nomeCondominio;
    }

    public void setNomeCondominio(String nomeCondominio) {
        this.nomeCondominio = nomeCondominio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada() {
        this.dataChegada = LocalDateTime.now();
    }

    public Long getDiasEmEspera() {
        return diasEmEspera;
    }

    public void setDiasEmEspera(Long diasEmEspera) {
        this.diasEmEspera = dataChegada.until(LocalDateTime.now(), ChronoUnit.DAYS);
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega() {
        this.dataEntrega = LocalDateTime.now();
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public Boolean getRecebidoPorteiro() {
        return recebidoPorteiro;
    }

    public void setRecebidoPorteiro(Boolean recebidoPorteiro) {
        this.recebidoPorteiro = recebidoPorteiro;
    }

    public Boolean getEntreguePorteiro() {
        return entreguePorteiro;
    }

    public void setEntreguePorteiro(Boolean entreguePorteiro) {
        this.entreguePorteiro = entreguePorteiro;
    }

    public Boolean getAssinaturaMorador() {
        return assinaturaMorador;
    }

}
