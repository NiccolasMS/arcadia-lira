package Lira.Arcadia.controle.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
public class Encomenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String codigoDeRastreio;

    @NotBlank
    private String nomeMorador;
    @NotBlank
    private String nomeCondominio;

    private String status;

    private String descricao;

    private LocalDateTime dataChegada;

    private Long diasEmEspera;

    private LocalDateTime dataEntrega;

    private Double taxa;

    private Boolean recebidoPorteiro;

    private Boolean entreguePorteiro;

    private Boolean assinaturaMorador;

    public Encomenda() {

    }

    public Encomenda(String codigoDeRastreio, String nomeMorador, String nomeCondominio) {
        this.codigoDeRastreio = codigoDeRastreio;
        this.nomeMorador = nomeMorador;
        this.nomeCondominio = nomeCondominio;
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

    public void setDataEntrega(LocalDateTime dataEntrega) {
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

    public void setAssinaturaMorador(Boolean assinaturaMorador) {
        this.assinaturaMorador = assinaturaMorador;
    }
}
