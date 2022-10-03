package dominio;

import controle.UsuarioController;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class Morador extends Usuario {
    private Boolean status = true;
    private LocalDateTime dataRetorno;
    @NotBlank
    private String bloco;
    private String[] responsaveis = new String[5];
    private Integer controleResponsaveis = 0;

    private UsuarioController usuarioController;

    public Morador(String email, String senha, String nome, String telefone, String bloco) {
        super(email, senha, nome, telefone);
        this.bloco = bloco;
    }

    public void assinarQueRecebeu(Encomenda encomenda)
    {
        encomenda.setAssinaturaMorador(true);
    }

    public void adicionarResponsavel(String nome)
    {
            responsaveis[controleResponsaveis++] = nome;
    }

    public void excluirResponsavel(String nome)
    {
        for(int i = 0; i < controleResponsaveis; i++)
        {
            if(responsaveis[i].equals(nome))
            {
                for(int index = i; index < responsaveis.length; index++)
                {
                    responsaveis[i] = responsaveis[i+1];
                }
                controleResponsaveis--;
            }
        }
    }


    public void cadastrarEncomenda(Encomenda encomenda) {
        UsuarioController.postEncomenda(encomenda);
    }

    public void getResponsaveis() {
        for(int i = 0; i < controleResponsaveis; i ++)
        {
            System.out.println(responsaveis[i]);
        }
    }


    public Boolean getStatus() {
        return status;
    }

    public LocalDateTime getDataRetorno() {
        return dataRetorno;
    }

    public String getBloco() {
        return bloco;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setDataRetorno(LocalDateTime dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }
}
