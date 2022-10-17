package Lira.Arcadia.controle.controle;

import Lira.Arcadia.controle.dominio.Condominio;

public class ListaObjCondominio<T> {
    private Condominio[] vetor;
    private int nroElem;

    public int getNroElem() {
        return nroElem;
    }

    public void setNroElem(int nroElem) {
        this.nroElem = nroElem;
    }

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

    public void atualizaPeloId(int id, Condominio elemento) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].getId() == id) {
                vetor[i] = elemento;
                break;
            }
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

    public boolean removePeloElemento (Condominio elemento) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].getId() == elemento.getId()) {
                // Loop para "deslocar para a esquerda" os elementos do vetor
                // sobrescrevendo o elemento removido
                for (int j = i; j < nroElem-1; j++) {
                    vetor[j] = vetor[j+1];
                }
                nroElem--;
                return true;
            }
        }
        return false;
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
        Condominio[] condominios = new Condominio[nroElem];

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

        for(int i =0 ; i < nroElem; i ++)
        {
            condominios[i] = vetor[i];
        }

        return condominios;
    }
}
