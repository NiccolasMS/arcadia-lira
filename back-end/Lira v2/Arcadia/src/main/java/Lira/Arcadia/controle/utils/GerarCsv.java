package Lira.Arcadia.controle.utils;

import Lira.Arcadia.controle.dominio.Encomenda;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GerarCsv {
    public static void gerarCsvEncomenda(List<Encomenda> lista, String nomeArq){
        FileWriter arq = null; // objeto que representa o arquivo de escrita
        Formatter saida = null; // objeto usado para escrever no arquivo
        boolean deuRuim = false;

        // Bloco try-catch para abrir o arquivo

        try{
            arq = new FileWriter(nomeArq, true);
            saida = new Formatter(arq);
        }catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        // Bloco try-catch para escrever no arquivo

        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dataChegada = "";
            String dataEntrega = "";
            for (Encomenda encomenda : lista) {
                if (encomenda.getDataChegada() != null) dataChegada = encomenda.getDataChegada().format(formatter);
                if (encomenda.getDataEntrega() != null) dataEntrega = encomenda.getDataEntrega().format(formatter);

                saida.format("%d;%s;%s;%s;%s;%d;%s\n", encomenda.getId(), encomenda.getCodigoDeRastreio(),
                        encomenda.getStatus(), encomenda.getDescricao(), dataChegada,
                        encomenda.getDiasEmEspera(), dataEntrega);
            }
        }catch (FormatterClosedException erro){
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
            deuRuim = true;
        }finally {
            saida.close();
            try{
                arq.close();
            }catch (IOException erro){
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim){
                System.exit(1);
            }
        }
    }
}
