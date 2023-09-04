package UncaughtExceptionHandler;

import java.util.Properties;

public class Principal implements Thread.UncaughtExceptionHandler {

    public static void main(String[] args) {
        Properties properties = new Properties();
        Thread thread = new Thread(new LeitorPropriedades(properties, "arquivo1.txt"));
        thread.setUncaughtExceptionHandler(new Principal());
        thread.start();
    }

    @Override
    public void uncaughtException(Thread thread, Throwable exception) {
        System.out.println("Exceção "+ exception +" capturada na Thread "+thread.getName());
    }
}

