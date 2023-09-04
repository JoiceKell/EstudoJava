import java.util.Set;

public class ListaThreads {
    public static void main(String[] args) {
        Set<Thread> todasAsThreads = Thread.getAllStackTraces().keySet();

        for (Thread thread : todasAsThreads) {
            System.out.println(thread.getName());
        }

        System.out.println("\nProcessadores: ");
        Runtime runtime = Runtime.getRuntime();
        int qtdProcessadores = runtime.availableProcessors();
        System.out.println("Qtd de processadores: " + qtdProcessadores);
    }
}
