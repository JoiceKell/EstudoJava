package br.com.alura.banheiro;

public class PrincipalBanheiro2 {
    public static void main(String[] args) {
        Banheiro2 banheiro = new Banheiro2();
        Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "João");
        Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");
        Thread convidado3 = new Thread(new TarefaNumero1(banheiro), "Maria");
        Thread convidado4 = new Thread(new TarefaNumero2(banheiro), "Ana");

        convidado1.start();
        convidado2.start();
        convidado3.start();
        convidado4.start();
    }
}
