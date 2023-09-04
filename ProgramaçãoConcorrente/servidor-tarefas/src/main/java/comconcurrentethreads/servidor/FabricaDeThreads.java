package comconcurrentethreads.servidor;

import java.util.concurrent.ThreadFactory;

public class FabricaDeThreads implements ThreadFactory {

    static int numero = 1;
    private ThreadFactory defaultFactory;

    public FabricaDeThreads(ThreadFactory defaultFactory) {
        this.defaultFactory = defaultFactory;
    }


    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, "Thread Servidor Tarefas " + numero);
        numero++;
        thread.setUncaughtExceptionHandler(new TratadorDeExcecao()); //Cada thread que será criada dentro do pool vai utilizar o tratador de exceção
        thread.setDaemon(true);
        return thread;
    }
}
