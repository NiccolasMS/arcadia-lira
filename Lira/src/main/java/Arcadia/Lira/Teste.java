package Arcadia.Lira;

public class Teste {
    public static void main(String[] args) {
        Condominio condominio = new Condominio("Sptech", "Cidade de Deus","Santos",
                                                 "Beijamin",1234);
        Morador morador = new Morador("@gmail","!@#","Bruno","4623",
                                        "2365","C");
        Porteiro porteiro = new Porteiro("@sdfg","352","José","346734");

        Encomenda encomenda1 = new Encomenda("123","1254","Bruno",
                                    "Sptech","wge3r");

        //Testando métodos condomínio

        condominio.cadastrarMorador(morador);
        condominio.cadastrarPorteiro(porteiro);

        System.out.println(condominio.toString());
        System.out.println(condominio.getUsuarios());

        ////////////////////////////////////////////

        //Testando Morador
        System.out.println("TESTANDO MORADOR\n\n");
        morador.assinarQueRecebeu(encomenda1);
        System.out.println(encomenda1.toString());

        morador.adicionarResponsavel("Marquinhos");
        morador.adicionarResponsavel("Diego");
        morador.adicionarResponsavel("Bruno");
        morador.getResponsaveis();

        System.out.println("\nExcluindo responsável");
        morador.excluirResponsavel("Diego");
        morador.getResponsaveis();

        //Testando porteiro
        System.out.println("\nTESTANDO PORTEIRO");








    }
}
