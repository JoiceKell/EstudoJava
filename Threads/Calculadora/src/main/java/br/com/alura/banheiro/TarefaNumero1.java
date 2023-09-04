package br.com.alura.banheiro;

public class TarefaNumero1 implements Runnable {
    private Banheiro banheiro;
    private Banheiro2 banheiro2;

    public TarefaNumero1(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    public TarefaNumero1(Banheiro2 banheiro1) {
        this.banheiro2 = banheiro1;
    }

    @Override
    public void run() {
        if(banheiro != null)
            banheiro.fazNumero1();
        else
            banheiro2.fazNumero1();
    }
}
