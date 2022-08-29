import java.time.LocalDateTime;

public class Morador extends Usuario{
    private Boolean status;
    private LocalDateTime dataRetorno;
    private String numeroCelular;
    private String bloco;
    private Integer numeroCasa;
    private String nomeResponsavel;

    public Morador(Integer idUsuario, String email, String senha, String nome, String telefone, Boolean status, String numeroCelular, String bloco, Integer numeroCasa) {
        super(idUsuario, email, senha, nome, telefone);
        this.status = status;
        this.numeroCelular = numeroCelular;
        this.bloco = bloco;
        this.numeroCasa = numeroCasa;
    }

    public void assinarQueRecebeu(Encomenda encomenda)
    {
        encomenda.setAssinaturaMorador(true);
    }

    @Override
    public String toString() {
        return "Morador{" +
                "status=" + status +
                ", dataRetorno=" + dataRetorno +
                ", numeroCelular='" + numeroCelular + '\'' +
                ", bloco='" + bloco + '\'' +
                ", numeroCasa=" + numeroCasa +
                ", nomeResponsavel='" + nomeResponsavel + '\'' +
                '}';
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(LocalDateTime dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public Integer getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(Integer numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
}
