package comconcurrentethreads.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class DistribuirTarefas implements Runnable {
    private ExecutorService threadPool;
    private Socket socket;
    private ServidorTarefas servidor;

    public DistribuirTarefas(ExecutorService threadPool, Socket socket, ServidorTarefas servidor) {
        this.threadPool = threadPool;
        this.socket = socket;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        try {
            System.out.println("Distribuindo tarefas para " + socket);

            Scanner entradaCliente = new Scanner(socket.getInputStream());

            PrintStream saidaCliente = new PrintStream(socket.getOutputStream());

            while (entradaCliente.hasNextLine()) {
                String comando = entradaCliente.nextLine();

                switch (comando) {
                    case "c1" : {
                        saidaCliente.println("Confirmação comando c1");
                        ComandoC1 c1 = new ComandoC1(saidaCliente);
                        this.threadPool.execute(c1);
                        break;
                    }
                    case "c2" : {
                        saidaCliente.println("Confirmação comando c2");
                        ComandoC2 c2 = new ComandoC2(saidaCliente);
                        this.threadPool.execute(c2);
                        break;
                    }
                    case "fim" : {
                        saidaCliente.println("Desligando o servidor");
                        break;
                    }
                    default : {
                        saidaCliente.println("Comando não encontrado");
                    }
                }
                System.out.println(comando);
            }

            saidaCliente.close();
            entradaCliente.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
