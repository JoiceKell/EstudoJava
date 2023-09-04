import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("editora casa do código");
        palavras.add("caelum");

        //Interface Funcional é aquela que possui apenas um método abstrato

        //1º
        //Comparator<String> comparator = new ComparadorPorTamanho();

        //Collections.sort(palavras, comparator);

        //2º
//        palavras.sort(new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                if(s1.length() < s2.length())
//                    return -1;
//                if(s1.length() > s2.length())
//                    return 1;
//                return 0;
//            }
//        });

        //3º
//        palavras.sort((String s1, String s2) -> {
//                if(s1.length() < s2.length())
//                    return -1;
//                if(s1.length() > s2.length())
//                    return 1;
//                return 0;
//            });
        //4º
//        palavras.sort((s1, s2) -> {
//            if(s1.length() < s2.length())
//                return -1;
//            if(s1.length() > s2.length())
//                return 1;
//            return 0;
//        });

        //5º
//        palavras.sort((String s1, String s2) -> {
//            return Integer.compare(s1.length(), s2.length());
//        });

        //6º
//        palavras.sort((String s1, String s2) -> Integer.compare(s1.length(), s2.length()));

        //7º
//        palavras.sort((s1, s2) -> s1.length() - s2.length());

        //8º
//        Comparator<String> comparator = Comparator.comparing(s -> s.length());
//        palavras.sort(comparator);

        //9º
//        Function<String, Integer> funcao = s -> s.length();
//        Comparator<String> comparator = Comparator.comparing(funcao);
//        palavras.sort(comparator);

        //10º
//        Function<String, Integer> funcao = new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return s.length();
//            }
//        };
//
//        Comparator<String> comparator = Comparator.comparing(funcao);
//        palavras.sort(comparator);

        //11º
//        palavras.sort(Comparator.comparing(s->s.length()));
//        System.out.println(palavras);

        //12º
//        Function<String, Integer> funcao = String::length;
//
//        Comparator<String> comparator = Comparator.comparing(funcao);
//        palavras.sort(comparator);

        //13º
        palavras.sort(Comparator.comparing(String::length));
        System.out.println(palavras);

        System.out.println("//Case_Insesitive_Order");

        palavras.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(palavras);

        //Ao invés de fazer isso poderia utilizar a classe anônima
        //1º Pode fazer isso
        //Consumer<String> consumidor = new ImprimeNaLinha();
        //2º Ou isso
//        Consumer<String> consumidor = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

        //3º Ou isso
//        palavras.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

        //4º Ou assim com lambda
//        palavras.forEach((String s) -> {
//                System.out.println(s);
//            }
//        );

        //5º Ou assim com lambda, se dentro das chaves possue apenas 1 comando
//        palavras.forEach(s -> {
//                    System.out.println(s);
//                }
//        );

        //6
//        Consumer<String> impressor = s -> System.out.println(s);
//        palavras.forEach(impressor);

        //7º Ou assim com lambda, se dentro das chaves possue apenas 1 comando
//        System.out.println("ForEach");
//        palavras.forEach(s -> System.out.println(s));

        //8º
//        Consumer<String> impressor = System.out::println;
//        palavras.forEach(impressor);

        //9º
        palavras.forEach(System.out::println);



    }
}

class ImprimeNaLinha implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}

class ComparadorPorTamanho implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length())
            return -1;
        if(s1.length() > s2.length())
            return 1;
        return 0;
    }
}
