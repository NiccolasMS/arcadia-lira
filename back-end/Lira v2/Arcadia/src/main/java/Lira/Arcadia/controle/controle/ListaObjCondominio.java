package Lira.Arcadia.controle.controle;

import Lira.Arcadia.controle.dominio.Condominio;

public class ListaObjCondominio<T> {
    private Condominio[] vetor;
    private int nroElem;

    public ListaObjCondominio(int tamanho) {
        vetor = new Condominio[tamanho];
        nroElem = 0;
    }

    public void adiciona(Condominio elemento) {
        if (nroElem >= vetor.length) {
            System.out.println("Lista cheia!");;
        }
        else {
            vetor[nroElem++] = elemento;
        }
    }

    public boolean removePeloIndice (int indice) {
        if (indice < 0 || indice >= nroElem) {
            System.out.println("\nÍndice inválido!");
            return false;
        }

        // Loop para "deslocar para a esquerda" os elementos do vetor
        // sobrescrevendo o elemento removido
        for (int i = indice; i < nroElem-1; i++) {
            vetor[i] = vetor[i+1];
        }

        nroElem--;
        return true;
    }

    public Condominio getElemento(int indice) {
        if (indice < 0 || indice >= nroElem) {
            return null;
        }
        else {
            return vetor[indice];
        }
    }

    public Condominio[] getElementos()
    {
        for(int i = 0; i < nroElem; i ++)
        {
            for(int j = 0; j < nroElem; j ++)
            {
                if(vetor[i].getNumero() > vetor[j].getNumero())
                {
                    Condominio auxiliar = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = auxiliar;
                }
            }
        }
        return vetor;
    }
}
