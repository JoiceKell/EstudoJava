import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TesteFila {
    public static void main(String[] args) throws InterruptedException {
        Queue<String> fila = new LinkedList<>();

        fila.offer("c1");
        fila.offer("c2");
        fila.offer("c3");

        System.out.println(fila.peek());
        System.out.println(fila.poll());
        System.out.println(fila.size());

        System.out.println("\n-------");

        BlockingQueue<String> fila2 =new ArrayBlockingQueue<>(3);
//        fila2.offer("c1");
//        fila2.offer("c2");
//        fila2.offer("c3");

        fila2.put("c4");
        fila2.put("c5");
        fila2.put("c6");
        fila2.put("c7");

        System.out.println(fila2.peek());
        System.out.println(fila2.poll());
        System.out.println(fila2.size());

        System.out.println(fila2.take());
    }
}
