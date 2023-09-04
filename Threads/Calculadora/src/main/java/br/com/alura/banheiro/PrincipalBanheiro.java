package br.com.alura.banheiro;

public class PrincipalBanheiro {
    public static void main(String[] args) {
        Banheiro banheiro = new Banheiro();
        Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "João");
        Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");
        Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Limpeza");

        //limpeza.setPriority(10);
        limpeza.setPriority(Thread.MAX_PRIORITY);

        //Roda apenas quando existe convidados threads
        /*
            Uma thread daemon é uma prestadora de serviços para outras threads. Ela só é usada enquanto as outras
            threads estão rodando.
            Elas são usadas para dar apoio à tarefas e só são necessárias rodar quando as threads "normais"
            ainda estão sendo executadas.
         */
        limpeza.setDaemon(true);

//        Thread convidado3 = new Thread(new TarefaNumero1(banheiro), "Maria");
//        Thread convidado4 = new Thread(new TarefaNumero2(banheiro), "Ana");

        convidado1.start();
        convidado2.start();
        limpeza.start();
//        convidado3.start();
//        convidado4.start();
    }
}
