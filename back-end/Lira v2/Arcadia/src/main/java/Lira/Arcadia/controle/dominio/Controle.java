package Lira.Arcadia.controle.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Controle {
    @Id
    private Integer id;
    private LocalDateTime diaHora;
    @NotNull
    private Integer quantidadeEntregasParaChegar;
    @NotNull
    private Integer quantidadeEntregasGuardadas;
    @NotNull
    private Integer quantidadeEntregasVencidas;
    @NotNull
    private Integer quantidadeEntregasProximasAVencer;
    @NotNull
    private Integer espacoNoEstoque;

    public Controle() {
    }

    public Controle(Integer id, LocalDateTime diaHora, Integer quantidadeEntregasParaChegar, Integer quantidadeEntregasGuardadas, Integer quantidadeEntregasVencidas, Integer quantidadeEntregasProximasAVencer, Integer espacoNoEstoque) {
        this.id = id;
        this.diaHora = diaHora;
        this.quantidadeEntregasParaChegar = quantidadeEntregasParaChegar;
        this.quantidadeEntregasGuardadas = quantidadeEntregasGuardadas;
        this.quantidadeEntregasVencidas = quantidadeEntregasVencidas;
        this.quantidadeEntregasProximasAVencer = quantidadeEntregasProximasAVencer;
        this.espacoNoEstoque = espacoNoEstoque;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(LocalDateTime diaHora) {
        this.diaHora = diaHora;
    }

    public Integer getQuantidadeEntregasParaChegar() {
        return quantidadeEntregasParaChegar;
    }

    public void setQuantidadeEntregasParaChegar(Integer quantidadeEntregasParaChegar) {
        this.quantidadeEntregasParaChegar = quantidadeEntregasParaChegar;
    }

    public Integer getQuantidadeEntregasGuardadas() {
        return quantidadeEntregasGuardadas;
    }

    public void setQuantidadeEntregasGuardadas(Integer quantidadeEntregasGuardadas) {
        this.quantidadeEntregasGuardadas = quantidadeEntregasGuardadas;
    }

    public Integer getQuantidadeEntregasVencidas() {
        return quantidadeEntregasVencidas;
    }

    public void setQuantidadeEntregasVencidas(Integer quantidadeEntregasVencidas) {
        this.quantidadeEntregasVencidas = quantidadeEntregasVencidas;
    }

    public Integer getQuantidadeEntregasProximasAVencer() {
        return quantidadeEntregasProximasAVencer;
    }

    public void setQuantidadeEntregasProximasAVencer(Integer quantidadeEntregasProximasAVencer) {
        this.quantidadeEntregasProximasAVencer = quantidadeEntregasProximasAVencer;
    }

    public Integer getEspacoNoEstoque() {
        return espacoNoEstoque;
    }

    public void setEspacoNoEstoque(Integer espacoNoEstoque) {
        this.espacoNoEstoque = espacoNoEstoque;
    }
}
