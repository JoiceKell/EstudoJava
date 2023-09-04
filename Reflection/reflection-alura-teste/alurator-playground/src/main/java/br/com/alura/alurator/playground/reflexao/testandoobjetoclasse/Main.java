package br.com.alura.alurator.playground.reflexao.testandoobjetoclasse;

import java.util.Scanner;

public class Main {

    /**
     * Simula o navegador. Lê o console, a URL, e passa para a classe Alurator responsável por encapsular toda a lógica de reflection
     * executando o método executa
     */
    public static void main(String[] args) throws Exception {

        /*
         * Casos possiveis:
         * /controlador/metodo
         * /controlador/metodo?param1=valor1&param2=valor2
         *
         * /produto/filtra?nome=produto
         *
         * /produto/filtra?nome=produto&marca=marca 1
         * /produto/filtra?marca=marca 1&nome=produto
         */

        try (Scanner s = new Scanner(System.in)) {
            String url = s.nextLine();

            Alurator alurator = new Alurator("br.com.alura.estoque.controle."); //Pacote Base
            while (!url.equals("exit")) {
                Object response = alurator.executa(url);

                System.out.println("Response: " + response);

                url = s.nextLine();
            }
        }
    }

}
