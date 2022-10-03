package dominio;

import controle.UsuarioController;

import java.time.LocalDateTime;

public class Porteiro extends Usuario {

    private static UsuarioController usuarioController;
    public Porteiro(String email, String senha, String nome, String telefone) {
        super(email, senha, nome, telefone);
    }


    public void cadastrarEncomenda(Encomenda encomenda) {
        usuarioController.postEncomenda(encomenda);
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
