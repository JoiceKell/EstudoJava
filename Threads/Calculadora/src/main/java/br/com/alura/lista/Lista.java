package br.com.alura.lista;

public class Lista {
    private String[] elementos = new String[1000];
    private int indice = 0;

    public synchronized void adicionaElementos(String elemento) {
        this.elementos[indice] = elemento;
        this.indice++;

        //Se comentar aqui, o Wait vai executar ante do notify
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(this.indice == this.elementos.length ){
            System.out.println("lista tá cheia, notificando");
            this.notify();
        }
    }

    public int tamanho() {
        return this.elementos.length;
    }

    public String pegaElemento(int posicao) {
        return this.elementos[posicao];
    }

    public boolean estaCheia() {
        return this.indice == this.tamanho();
    }
}