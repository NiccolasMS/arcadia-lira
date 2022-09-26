package Arcadia.Lira;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Encomenda implements Taxa{

    private String codigo;
    private String codigoDeRastreio;
    private String nomeMorador;
    private String nomeCondominio;
    private String status;
    private String descricao;
    private LocalDateTime dataChegada = LocalDateTime.now();
    private Long diasEmEspera;
    private LocalDateTime dataEntrega;
    private Double taxa = 0.0;
    private Boolean recebidoPorteiro = false;
    private Boolean entreguePorteiro = false;
    private Boolean assinaturaMorador = false;

    public Encomenda(String codigo, String codigoDeRastreio, String nomeMorador, String nomeCondominio, String descricao) {
        this.codigo = codigo;
        this.codigoDeRastreio = codigoDeRastreio;
        this.nomeMorador = nomeMorador;
        this.nomeCondominio = nomeCondominio;
        this.descricao = descricao;

        this.diasEmEspera = dataChegada.until(LocalDateTime.now(), ChronoUnit.DAYS);
    }

    @Override
    public Double implementarTaxa() {
        if(diasEmEspera > 15)
        {
            this.taxa = 100.50;
        }
        return taxa;
    }

    @Override
    public String toString() {
        return "Encomenda{" +
                "codigo='" + codigo + '\'' +
                ", codigoDeRastreio='" + codigoDeRastreio + '\'' +
                ", nomeMorador='" + nomeMorador + '\'' +
                ", nomeCondominio='" + nomeCondominio + '\'' +
                ", status='" + status + '\'' +
                ", descricao='" + descricao + '\'' +
                ", recebidoPorteiro=" + recebidoPorteiro +
                ", entreguePorteiro=" + entreguePorteiro +
                ", assinaturaMorador=" + assinaturaMorador +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public void setDataChegada(LocalDateTime dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Long getDiasEmEspera() {
        return diasEmEspera;
    }

    public void setDiasEmEspera(Long diasEmEspera) {
        this.diasEmEspera = diasEmEspera;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
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
        if(assinaturaMorador == true)
        {
            this.status = "Morador recebeu a entrega";
        }
    }
}
