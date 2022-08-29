import java.time.LocalDateTime;

public class Porteiro extends Usuario{

    public Porteiro(Integer idUsuario, String email, String senha, String nome, String telefone) {
        super(idUsuario, email, senha, nome, telefone);
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
