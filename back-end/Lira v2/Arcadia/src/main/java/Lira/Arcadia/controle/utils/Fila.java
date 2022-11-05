package Lira.Arcadia.controle.utils;

import Lira.Arcadia.controle.dominio.Encomenda;

import java.util.ArrayList;
import java.util.List;

public class Fila{
    // Atributos
    private int tamanho;
    private Encomenda[] fila;

    // Construtor
    public Fila(int capaciade) {
        fila = new Encomenda[capaciade];
        tamanho = 0;
    }

    // Métodos

    /* Método isEmpty() - retorna true se a fila está vazia e false caso contrário */
    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    /* Método isFull() - retorna true se a fila está cheia e false caso contrário */
    public boolean isFull() {
        if(tamanho == fila.length)
        {
            return true;
        }
        return false;
    }

    /* Método insert - recebe um elemento e insere esse elemento na fila
                       no índice tamanho, e incrementa tamanho
                       Retornar IllegalStateException caso a fila esteja cheia
     */
    public void insert(Encomenda info) {
        if(isFull())
        {
            throw new IllegalStateException();
        }

        if (info.getDataEntrega() == null)
        {
            fila[tamanho++] = info;
        }
    }

    /* Método peek - retorna o primeiro elemento da fila, sem removê-lo */
    public Encomenda peek() {
        return fila[0];
    }

    /* Método poll - remove e retorna o primeiro elemento da fila, se a fila não estiver
       vazia. Quando um elemento é removido, a fila "anda", e tamanho é decrementado
     */
    public Encomenda poll() {
        if(!isEmpty()){
            Encomenda elemento = fila[0];

            for(int i = 0; i < tamanho; i++)
            {
                if(i == tamanho - 1)
                {
                    break;
                }
                fila[i] = fila[i + 1];

            }
            tamanho --;

            return elemento;
        }

        return null;
    }

    /* Método exibe() - exibe o conteúdo da fila */
    public List<Encomenda> exibe() {
        List<Encomenda> encomendas = new ArrayList<>();

        for(int i = 0; i < tamanho; i++){
            encomendas.add(fila[i]);
        }

        return encomendas;
    }

    /* Usado nos testes  - complete para que fique certo */
    public int getTamanho(){
        return tamanho;
    }
}
