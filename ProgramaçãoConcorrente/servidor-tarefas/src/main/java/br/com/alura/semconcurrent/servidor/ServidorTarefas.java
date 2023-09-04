package br.com.alura.semconcurrent.servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTarefas {
    public static void main(String[] args) throws Exception {
        System.out.println("--- Iniciando Servidor ---");
        ServerSocket servidor = new ServerSocket(12345);

        while (true) {
            //O método accept é bloqueante e trava a thread principal. Ou seja, ao rodar, a thread
            // main fica parada até receber uma conexão através de um cliente
            Socket socket = servidor.accept();
            System.out.println("Aceitando novo cliente na porta " + socket.getPort());

            DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket);
            new Thread(distribuirTarefas).start();
        }
    }
}
