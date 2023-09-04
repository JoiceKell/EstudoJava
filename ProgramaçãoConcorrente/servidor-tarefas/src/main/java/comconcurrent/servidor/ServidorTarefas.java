package comconcurrent.servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorTarefas {
    public static void main(String[] args) throws Exception {
        System.out.println("--- Iniciando Servidor ---");
        ServerSocket servidor = new ServerSocket(12345);

        //Controla a quantidade de Threads
//        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        //Cresce dinamicamente
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //Executa uma thread
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();


        while (true) {
            //O método accept é bloqueante e trava a thread principal. Ou seja, ao rodar, a thread
            // main fica parada até receber uma conexão através de um cliente
            Socket socket = servidor.accept();
            System.out.println("Aceitando novo cliente na porta " + socket.getPort());

            DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket);
            threadPool.execute(distribuirTarefas);
        }
    }
}
