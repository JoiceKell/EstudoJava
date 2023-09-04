package comconcurrentethreads.cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 12345);
        System.out.println("Conexão estabelecida");

        Thread threadEnviaComando = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Enviando Dados
                    //OutputStream outputStreamCliente = socket.getOutputStream();

                    System.out.println("Pode enviar comandos!");
                    PrintStream saida = new PrintStream(socket.getOutputStream());

                    Scanner teclado = new Scanner(System.in);
                    while (teclado.hasNextLine()) {
                        String linha = teclado.nextLine();
                        if (linha.trim().equals("")) {
                            break;
                        }
                        saida.println(linha);
                    }
                    saida.close();
                    teclado.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadRecebeResposta = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Recebendo dados

                    System.out.println("Recebendo dados do servidor");

                    Scanner respostaServidor = new Scanner(socket.getInputStream());

                    while (respostaServidor.hasNextLine()) {
                        String linha = respostaServidor.nextLine();
                        System.out.println(linha);
                    }

                    respostaServidor.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        /*
            Utilizando o Thread com lambda
            new Thread( () -> { System.out.println("rodando");} ).start();
         */

        threadRecebeResposta.start();
        threadEnviaComando.start();

        /*
            join(); //sem nenhum param
            join(millis); //recebendo milli segundos
            join(millis, nano); //recebendo milli e nano segundos
         */
        threadEnviaComando.join();

        System.out.println("Fechando socket do cliente");
        socket.close();

    }
}
