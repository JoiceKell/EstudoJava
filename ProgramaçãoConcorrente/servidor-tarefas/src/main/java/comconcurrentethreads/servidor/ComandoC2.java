package comconcurrentethreads.servidor;

import java.io.PrintStream;

public class ComandoC2 implements Runnable {
    private PrintStream saida;

    public ComandoC2(PrintStream saida) {
        this.saida = saida;
    }

    @Override
    public void run() {
        System.out.println("Executando comando C2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        throw new RuntimeException("Exception no comando C2");
//        saida.println("Comando c2 executado com sucesso");
    }
}
