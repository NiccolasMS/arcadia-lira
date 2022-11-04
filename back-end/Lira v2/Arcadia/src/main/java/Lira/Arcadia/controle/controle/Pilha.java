package Lira.Arcadia.controle.controle;

public class Pilha {

    // 01) Atributos
    private String[] pilha;
    private int topo;

    // 02) Construtor
    public Pilha(int capacidade) {
        this.topo = -1;
        this.pilha = new String[capacidade];
    }

    public Pilha()
    {}

    // 03) Método isEmpty
    public Boolean isEmpty() {

        if(topo == -1)
        {
            return true;
        }
        return false;
    }

    // 04) Método isFull
    public Boolean isFull() {
        if(topo == (pilha.length - 1))
        {
            return true;
        }
        return false;
    }

    // 05) Método push
    public void push(String info) {


        if(isFull())

        {
            throw new IllegalStateException("Pilha cheia");
        }

        pilha[++topo] = info;

    }

    // 06) Método pop
    public String pop() {

        if(isEmpty() == false && topo != 0)
        {
            return pilha[topo--];
        }
        return null;
    }

    // 07) Método peek
    public String peek() {
        if(isEmpty() == false)
        {
            return pilha[topo];
        }
        return null;
    }

    // 08) Método exibe
    public void exibe() {
        if(isEmpty())
        {
            System.out.println("Pilha vazia");
        }
        for(int i = 0; i <= topo; i ++)
        {
            System.out.println(pilha[i]);
        }
    }

    public String[] getPilha() {
        return pilha;
    }

    public void setPilha(String[] pilha) {
        this.pilha = pilha;
    }

    //Getters & Setters (manter)
    public int getTopo() {
        return topo;
    }
}