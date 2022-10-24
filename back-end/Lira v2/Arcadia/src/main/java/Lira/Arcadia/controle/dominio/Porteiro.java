package Lira.Arcadia.controle.dominio;

import javax.persistence.*;

@Entity
public class Porteiro extends Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Condominio condominio;

    public Porteiro(){}

    public Porteiro(String email, String senha, String nome, String telefone, Integer id) {
        super(email, senha, nome, telefone);
        this.id = id;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
