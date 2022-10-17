package Lira.Arcadia.controle.dominio;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Morador extends Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean status;

    @FutureOrPresent
    private LocalDateTime dataRetorno = null;

    @NotBlank
    private String bloco;


    //@OneToMany(targetEntity = Morador.class)
    //@JoinColumn(name = "id",foreignKey = @ForeignKey(name = "fkResponsavel"))
    //private List<Morador> responsaveis;

    public Morador(){

    }
    public Morador(String email, String senha, String nome, String telefone,
                   String bloco) {
        super(email, senha, nome, telefone);
        this.bloco = bloco;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(LocalDateTime dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);

    }
    @Override
    public String senha() {
        return super.senha();
    }

    @Override
    public void setSenha(String senha) {
        super.setSenha(senha);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public String getTelefone() {
        return super.getTelefone();
    }

    @Override
    public void setTelefone(String telefone) {
        super.setTelefone(telefone);
    }

    @Override
    public Boolean getAutenticado() {
        return super.getAutenticado();
    }

    @Override
    public void setAutenticado(Boolean autenticado) {
        super.setAutenticado(autenticado);
    }

}
