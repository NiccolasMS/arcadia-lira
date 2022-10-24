package Lira.Arcadia.controle.utils;

import Lira.Arcadia.controle.dominio.Encomenda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TesteCsv {
    public static void main(String[] args) {
        List<Encomenda> lista = new ArrayList<>();

        Encomenda encomenda1 = new Encomenda();
        encomenda1.setId(1);
        encomenda1.setCodigoDeRastreio("123456789");
        encomenda1.setStatus("Em trânsito");
        encomenda1.setDescricao("Encomenda de teste");
        encomenda1.setDataChegada(LocalDateTime.now());
        encomenda1.setDiasEmEspera(2L);
        encomenda1.setDataEntrega(LocalDateTime.now());
        lista.add(encomenda1);

        GerarCsv.gravaArquivoCsv(lista, "teste.csv");


    }
}
