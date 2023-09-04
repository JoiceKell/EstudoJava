package comconcurrent.cliente;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 12345);
        System.out.println("Conexão estabelecida");

        //Enviando Dados
        //OutputStream outputStreamCliente = socket.getOutputStream();
        PrintStream saida = new PrintStream(socket.getOutputStream());

        Scanner teclado = new Scanner(System.in);
        while (teclado.hasNextLine()) {
            String linha = teclado.nextLine();
            if (linha.trim().equals("")) {
                break;
            }
            saida.println(linha);
        }

        //Recebendo dados

        System.out.println("Recebendo dados do servidor");

        Scanner respostaServidor = new Scanner(socket.getInputStream());

        while (respostaServidor.hasNextLine()) {
            String linha = respostaServidor.nextLine();
            System.out.println(linha);
        }

        respostaServidor.close();
        saida.close();
        teclado.close();
        socket.close();

    }
}
