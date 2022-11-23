package Lira.Arcadia.controle.utils;

import Lira.Arcadia.controle.dominio.Encomenda;
import Lira.Arcadia.controle.dominio.Morador;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GerarTxt {

    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        //try-catch para abrir o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            erro.printStackTrace();
        }

        //try-catch para gravar e fechar o arquivo
        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro ao escrever no arquivo");
            erro.printStackTrace();
        }
    }

    public static void gravaArquivoTxt(List<Encomenda> lista, String nomeArq){
        int contaRegDados = 0;

        //Monta o registro de header
        String header = "ENCOMENDA";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";

        //Grava o registro de header
        gravaRegistro(header, nomeArq);

        //Monta e grava os registros de corpo (ou de dados)
        String corpo;
        for (Encomenda encomenda : lista) {
            corpo = "02";
            corpo += String.format("%-50.50s", encomenda.getDescricao());
            corpo += String.format("%-13.13s", encomenda.getCodigoDeRastreio());
            corpo += String.format("%-15.15s", encomenda.getStatus());
//            corpo += String.format("%05.2f", aluno.getMedia());
//            corpo += String.format("%03d", aluno.getQtdFalta());
            gravaRegistro(corpo, nomeArq);
            contaRegDados++;
        }

        //Monta o registro de trailer
        String trailer = "01";
        trailer += String.format("%010d", contaRegDados);
        gravaRegistro(trailer, nomeArq);
    }

    public static void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String codigoDeRastreio, descricao, status;
        int contaRegDadosLido = 0;
        int qtdRegDadoGravado;

        List<Encomenda> listaLida = new ArrayList<>();

        //try-catch para abrir o arquivo
        try{
            entrada = new BufferedReader(new FileReader(nomeArq));
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo");
            erro.printStackTrace();
        }

        //try-catch para ler e fechar o arquivo
        try{
            //leitura do 1o registro do arquivo
            registro = entrada.readLine();

            while (registro != null){
                //Obtém os 2 primeiros caracteres do registro

                //01234567890
                //00NOTA20222
                //substring - 1o argumento: indice do inicio do que eu quero obter
                //substring - 2o argumento: indice do final do que eu quero obter
                tipoRegistro = registro.substring(0, 2);
                if (tipoRegistro.equals("00")){
                    System.out.println("Registro de header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2, 6));
                    System.out.println("Ano e semestre:" + registro.substring(6, 11));
                    System.out.println("Data e hora de gravação: " + registro.substring(11, 30));
                    System.out.println("Versão do documento: " + registro.substring(30, 32));
                }
                else if (tipoRegistro.equals("01")){
                    System.out.println("Registro de trailer");
                    qtdRegDadoGravado = Integer.parseInt(registro.substring(2, 12));
                    System.out.println("Quantidade de registros de dados lidos: " + contaRegDadosLido);
                    System.out.println("Quantidade de registros de dados gravados: " + qtdRegDadoGravado);
                    if (contaRegDadosLido == qtdRegDadoGravado){
                        System.out.println("Quantidade de registros de dados lidos compatível com quantidade" +
                                "de registros de dados gravados");
                    }
                    else {
                        System.out.println("Quantidade de registros de dados lidos incompatível com quantidade" +
                                "de registros de dados gravados");
                    }
                }
                else if(tipoRegistro.equals("02")){
                    System.out.println("Registro de corpo");
                    descricao = registro.substring(2, 52);
                    codigoDeRastreio = registro.substring(52, 65);
                    status = registro.substring(65, 80);
                    contaRegDadosLido++;

                    //Instancia um objeto Aluno com as informações lidas
                    //Encomenda encomenda = new Encomenda(codigoDeRastreio, descricao, status);
                    Encomenda encomenda = new Encomenda(codigoDeRastreio, descricao);

                    //No Projeto de PI, pode fazer
                    //repository.save(aluno);

                    //No nosso caso, como não estamos conectados ao banco
                    //Vamos adicionar o aluno na lista
                    listaLida.add(encomenda);
                }
                else {
                    System.out.println("Tipo de registro inválido!");
                }

                //leitura do próximo registro do arquivo
                registro = entrada.readLine();
            }
            entrada.close();
        }
        catch (IOException erro){
            System.out.println("Erro ao ler o arquivo");
            erro.printStackTrace();
        }

        //Exibe a lista lida
        System.out.println("\nContéudo da lista lida do arquivo");
        for (Encomenda encomenda : listaLida) {
            System.out.println(encomenda);
        }

    }
//    public static void main(String[] args) {
//        List<Encomenda> lista = new ArrayList<>();
//        lista.add(new Encomenda("1234567890123", "Encomenda 1"));
//        lista.add(new Encomenda("1234567890124", "Encomenda 2"));
//        lista.add(new Encomenda("1234567890125", "Encomenda 3"));
//        lista.add(new Encomenda("1234567890126", "Encomenda 4"));
//        lista.add(new Encomenda("1234567890127", "Encomenda 5"));
//        lista.add(new Encomenda("1234567890128", "Encomenda 6"));
//        lista.add(new Encomenda("1234567890129", "Encomenda 7"));
//        lista.add(new Encomenda("1234567890130", "Encomenda 8"));
//        lista.add(new Encomenda("1234567890131", "Encomenda 9"));
//        lista.add(new Encomenda("1234567890132", "Encomenda 10"));
//        lista.add(new Encomenda("1234567890133", "Encomenda 11"));
//        lista.add(new Encomenda("1234567890134", "Encomenda 12"));
//        lista.add(new Encomenda("1234567890135", "Encomenda 13"));
//        lista.add(new Encomenda("1234567890136", "Encomenda 14"));
//        lista.add(new Encomenda("1234567890137", "Encomenda 15"));
//        lista.add(new Encomenda("1234567890138", "Encomenda 16"));
//        lista.add(new Encomenda("1234567890139", "Encomenda 17"));
//        lista.add(new Encomenda("1234567890140", "Encomenda 18"));
//        lista.add(new Encomenda("1234567890141", "Encomenda 19"));
//        lista.add(new Encomenda("1234567890142", "Encomenda 20"));
//        lista.add(new Encomenda("1234567890143", "Encomenda 21"));
//        lista.add(new Encomenda("1234567890144", "Encomenda 22"));
//        lista.add(new Encomenda("1234567890145", "Encomenda 23"));
//
//        System.out.println("Lista original: ");
//        for (Encomenda encomenda : lista) {
//            System.out.println(encomenda);
//        }
//
//        File arquivo = new File("./arquivo.txt");
//        if (!arquivo.isFile()) gravaArquivoTxt(lista, "encomendas.txt");
//        leArquivoTxt("encomendas.txt");
//    }
}
