package Arcadia.Lira;

import java.time.LocalDateTime;
import java.util.List;

public class Porteiro extends Usuario{

    public Porteiro(String email, String senha, String nome, String telefone) {
        super(email, senha, nome, telefone);
    }

    @Override
    public void cadastrarEncomenda(Encomenda encomenda) {
        encomendas.add(encomenda);
    }

    @Override
    public List<Encomenda> exibirEncomendas() {
        return encomendas;
    }

    public void setDataDeChegada(Encomenda encomenda)
    {
        encomenda.setDataChegada(LocalDateTime.now());
        encomenda.setRecebidoPorteiro(true);
    }

    public void setDataEntrega(Encomenda encomenda)
    {
        encomenda.setDataEntrega(LocalDateTime.now());
        encomenda.setEntreguePorteiro(true);
    }
}
