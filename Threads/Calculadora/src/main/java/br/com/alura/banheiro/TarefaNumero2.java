package br.com.alura.banheiro;

public class TarefaNumero2 implements Runnable {
    private Banheiro banheiro;
    private Banheiro2 banheiro2;

    //boolean locked = lock.tryLock(5, TimeUnit.SECONDS); //5s

    public TarefaNumero2(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    public TarefaNumero2(Banheiro2 banheiro2) {
        this.banheiro2 = banheiro2;
    }

    @Override
    public void run() {
        if(banheiro != null)
            banheiro.fazNumero2();
        else
            banheiro2.fazNumero2();
    }
}
