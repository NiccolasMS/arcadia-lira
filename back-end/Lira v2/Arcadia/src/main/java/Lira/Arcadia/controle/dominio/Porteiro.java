package Lira.Arcadia.controle.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Porteiro extends Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Porteiro(){}

    public Porteiro(String email, String senha, String nome, String telefone, Integer id) {
        super(email, senha, nome, telefone);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
