package br.com.alura.buscaTextual;

public class Principal {
    public static void main(String[] args) {
        //String nome = "da";
        /*
            \\s - significa whitespace, um espaço ou tab
            \\w - significa word, um caractere ou número
         */
        String nome = "(Dan|Chad)(\\s|\\w)*";

        Thread threadAssiaturas1 = new Thread(new TarefaBuscaTextual("assinaturas1.txt", nome));
        Thread threadAssiaturas2 = new Thread(new TarefaBuscaTextual("assinaturas2.txt", nome));
        Thread threadAutores = new Thread(new TarefaBuscaTextual("autores.txt", nome));

        threadAssiaturas1.start();
        threadAssiaturas2.start();
        threadAutores.start();
    }
}
