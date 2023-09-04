package comconcurrentethreadscallable.servidor;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

//O método devolverá uma String como foi definido no Callable<String>
public class ComandoC2ChamaWS implements Callable<String> {
    private PrintStream saida;

    public ComandoC2ChamaWS(PrintStream saida) {
        this.saida = saida;
    }

    //Na método run não é permitido realizar o throws, mas aqui é possível
    @Override
    public String call() throws Exception {
        System.out.println("Servidor recebeu comando C2 - WS");

        saida.println("Processando comando C2 - WS");

        Thread.sleep(25000);
        int numero = new Random().nextInt(100) + 1;

        System.out.println("Servidor finalizou comando C2 - WS");
        return Integer.toString(numero);
    }
}
