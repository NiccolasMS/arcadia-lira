package Lira.Arcadia.controle.dominio;

import javax.persistence.*;
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

    private String status;

    private String descricao;

    private LocalDateTime dataChegada;

    private Long diasEmEspera;

    private LocalDateTime dataEntrega;

    private Double taxa;

    private Boolean recebidoPorteiro;

    private Boolean entreguePorteiro;

    private Boolean assinaturaMorador;
    @ManyToOne
    private Condominio condominio;

    @ManyToOne
    private Morador morador;

    public Encomenda() {

    }

    public Encomenda(String codigoDeRastreio, Morador morador, Condominio condominio) {
        this.codigoDeRastreio = codigoDeRastreio;
        this.morador = morador;
        this.condominio = condominio;
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

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
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

    public void setDiasEmEspera() {
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

    public void setAssinaturaMorador(Boolean assinaturaMorador) {
        this.assinaturaMorador = assinaturaMorador;
    }
}
