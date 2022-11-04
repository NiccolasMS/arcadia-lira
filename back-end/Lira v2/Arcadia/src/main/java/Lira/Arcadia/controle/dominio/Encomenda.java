package Lira.Arcadia.controle.dominio;

import Lira.Arcadia.controle.controle.Pilha;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Transient
    private String[] pilha =  new String[4];;
    @Transient
    private int topo;

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

    public String[] pilha() {
        return pilha;
    }

    // 03) Método isEmpty
    public Boolean isEmpty() {

        if(topo == -1)
        {
            return true;
        }
        return false;
    }

    // 04) Método isFull
    public Boolean isFull() {

        if(topo == (pilha.length - 1))
        {
            return true;
        }
        return false;
    }

    // 05) Método push
    public void push(String info) {

        if(isFull())

        {
            throw new IllegalStateException("Pilha cheia");
        }

        pilha[++topo] = info;

    }

    // 06) Método pop
    public String pop() {

        if(isEmpty() == false && topo != 0)
        {
            return pilha[topo--];
        }
        return null;
    }

    // 07) Método peek
    public String peek() {
        if(isEmpty() == false)
        {
            return pilha[topo];
        }
        return null;
    }

    public String getStatus() {
        return this.status;
    }

    public String setStatus(){
       this.status = peek();
       return this.status;
    }

    public int getTopo() {
        return topo;
    }

    public void setTopo() {
        this.topo = -1;
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
