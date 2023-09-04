package comconcurrentethreads.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefas {

    private ServerSocket servidor;
    private ExecutorService threadPool;

//    private volatile boolean estaRodando; //Muda em memória principal e não em cache, podendo ser rescrito como private AtomicBoolean estaRodando;
    private AtomicBoolean estaRodando;

    public ServidorTarefas() throws IOException {
        System.out.println("--- Iniciando Servidor ---");
        this.servidor = new ServerSocket(12345);

        ThreadFactory defaultFactory = Executors.defaultThreadFactory();
        this.threadPool = Executors.newFixedThreadPool(5,new FabricaDeThreads(defaultFactory));
        //threadPool = Executors.newFixedThreadPool(4, new FabricaDeThreads()); //Controla a quantidade de Threads

//        this.threadPool = Executors.newCachedThreadPool(); //Cresce dinamicamente

//        ExecutorService threadPool = Executors.newSingleThreadExecutor(); //Executa uma thread

//        this.estaRodando = true;
        this.estaRodando = new AtomicBoolean(true);
    }

    public void rodar() throws IOException {

            while (this.estaRodando.get()) {
                try {
                //O método accept é bloqueante e trava a thread principal. Ou seja, ao rodar, a thread
                // main fica parada até receber uma conexão através de um cliente
                    Socket socket = servidor.accept();
                    System.out.println("Aceitando novo cliente na porta " + socket.getPort());

                    DistribuirTarefas distribuirTarefas = new DistribuirTarefas(threadPool ,socket, this); //O case já está pronto, no entanto é preciso ter o servidor em mãos para poder desligá-lo. Por isso passaremos no construtor da classe mais uma argumento, o nosso servidor:
                    threadPool.execute(distribuirTarefas);
            } catch (SocketException e) {
                System.out.println("SocketException, Está rodando? " + this.estaRodando);
            }
        }
    }

    public void parar() throws IOException {
        estaRodando.set(false);
        servidor.close();
        threadPool.shutdown();
//        System.exit(0);
    }

    public static void main(String[] args) throws Exception {

        ServidorTarefas servidor = new ServidorTarefas();
        servidor.rodar();
        servidor.parar();
    }
}
