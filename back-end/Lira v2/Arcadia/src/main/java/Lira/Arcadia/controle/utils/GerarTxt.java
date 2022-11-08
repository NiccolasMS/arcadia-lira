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
            corpo += String.format("%-40.40s", encomenda.getMorador().getNome());
            corpo += String.format("%-13.13s", encomenda.getCodigoDeRastreio());
//            corpo += String.format("%-50.50s", aluno.getNome());
//            corpo += String.format("%-40.40s", aluno.getDisciplina());
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

//    public static void leArquivoTxt(String nomeArq) {
//        BufferedReader entrada = null;
//        String registro, tipoRegistro;
//        String ra, nome, curso, disciplina;
//        Double media;
//        Integer qtdFalta;
//        int contaRegDadosLido = 0;
//        int qtdRegDadoGravado;
//
//        List<Aluno> listaLida = new ArrayList<>();
//
//        //try-catch para abrir o arquivo
//        try{
//            entrada = new BufferedReader(new FileReader(nomeArq));
//        }
//        catch (IOException erro){
//            System.out.println("Erro ao abrir o arquivo");
//            erro.printStackTrace();
//        }
//
//        //try-catch para ler e fechar o arquivo
//        try{
//            //leitura do 1o registro do arquivo
//            registro = entrada.readLine();
//
//            while (registro != null){
//                //Obtém os 2 primeiros caracteres do registro
//
//                //01234567890
//                //00NOTA20222
//                //substring - 1o argumento: indice do inicio do que eu quero obter
//                //substring - 2o argumento: indice do final do que eu quero obter
//                tipoRegistro = registro.substring(0, 2);
//                if (tipoRegistro.equals("00")){
//                    System.out.println("Registro de header");
//                    System.out.println("Tipo de arquivo: " + registro.substring(2, 6));
//                    System.out.println("Ano e semestre:" + registro.substring(6, 11));
//                    System.out.println("Data e hora de gravação: " + registro.substring(11, 30));
//                    System.out.println("Versão do documento: " + registro.substring(30, 32));
//                }
//                else if (tipoRegistro.equals("01")){
//                    System.out.println("Registro de trailer");
//                    qtdRegDadoGravado = Integer.parseInt(registro.substring(2, 12));
//                    System.out.println("Quantidade de registros de dados lidos: " + contaRegDadosLido);
//                    System.out.println("Quantidade de registros de dados gravados: " + qtdRegDadoGravado);
//                    if (contaRegDadosLido == qtdRegDadoGravado){
//                        System.out.println("Quantidade de registros de dados lidos compatível com quantidade" +
//                                "de registros de dados gravados");
//                    }
//                    else {
//                        System.out.println("Quantidade de registros de dados lidos incompatível com quantidade" +
//                                "de registros de dados gravados");
//                    }
//                }
//                else if(tipoRegistro.equals("02")){
//                    System.out.println("Registro de corpo");
//                    curso = registro.substring(2, 7).trim();
//                    ra = registro.substring(7, 15).trim();
//                    nome = registro.substring(15, 65).trim();
//                    disciplina = registro.substring(65, 105).trim();
//                    media = Double.valueOf(registro.substring(105, 110).replace(',', '.'));
//                    qtdFalta = Integer.valueOf(registro.substring(110, 113));
//                    contaRegDadosLido++;
//
//                    //Instancia um objeto Aluno com as informações lidas
//                    Aluno aluno = new Aluno(ra, nome, curso, disciplina, media, qtdFalta);
//
//                    //No Projeto de PI, pode fazer
//                    //repository.save(aluno);
//
//                    //No nosso caso, como não estamos conectados ao banco
//                    //Vamos adicionar o aluno na lista
//                    listaLida.add(aluno);
//                }
//                else {
//                    System.out.println("Tipo de registro inválido!");
//                }
//
//                //leitura do próximo registro do arquivo
//                registro = entrada.readLine();
//            }
//            entrada.close();
//        }
//        catch (IOException erro){
//            System.out.println("Erro ao ler o arquivo");
//            erro.printStackTrace();
//        }
//
//        //Exibe a lista lida
//        System.out.println("\nContéudo da lista lida do arquivo");
//        for (Aluno aluno : listaLida) {
//            System.out.println(aluno);
//        }
//
//    }
//    public static void main(String[] args) {
//        List<Aluno> lista = new ArrayList<>();
//        lista.add(new Aluno("01212132", "Nicolas", "ADS", "ED", 10.0, 30));
//        lista.add(new Aluno("01212133", "Joao", "ADS", "ED", 10.0, 30));
//        lista.add(new Aluno("01212134", "Maria", "ADS", "ED", 10.0, 30));
//        lista.add(new Aluno("01212135", "Pedro", "ADS", "ED", 10.0, 30));
//
//        System.out.println("Lista original: ");
//        for (Aluno aluno : lista) {
//            System.out.println(aluno);
//        }
//
//        File arquivo = new File("./arquivo.txt");
//        if (!arquivo.isFile()) gravaArquivoTxt(lista, "alunos.txt");
//        leArquivoTxt("alunos.txt");
//    }
}
