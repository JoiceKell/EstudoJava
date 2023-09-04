package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.SubControle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
    getDeclaredConstructor(Class<?> ...tiposArgs) - retornar um único construtor (caso encontre) público ou não que receba os tipos de dados informados nos parâmetros. Mas para isso levará em consideração apenas os construtores da classe inferida pela classe Class<T>, sem levar em consideração uma possível super classe! A exceção NoSuchMethodException é lançada caso nenhum construtor seja encontrado.
    getConstructor(Class<?> ...tiposArgs) - retornar um único construtor (caso encontre) público que receba os tipos de dados informados nos parâmetros. Mas para isso levará em consideração os construtores da classe inferida pela classe Class<T> e também levará em consideração uma possível super classe. A exceção NoSuchMethodException é lançada caso nenhum construtor seja encontrado.
    getConstructors() - retornar um array de construtores públicos da classe inferida pela classe Class<T> e também levará em consideração uma possível super classe!
    getDeclaredConstructors() - retornar um array de construtores públicos ou não, mas apenas da classe inferida pela classe Class<T>, sem levar em consideração uma possível super classe!
 */

public class TesteInstanciaObjetoCorretamente {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InstantiationException {

        Class<SubControle> subControleClasse1 = SubControle.class;
        Class<?> subControleClasse2 = Class.forName("br.com.alura.alurator.playground.controle.SubControle");

        //getConstructor() com ou sem parâmetros só retorna métodos públicos
//        Constructor<SubControle> construtorSubControle = subControleClasse1.getConstructor(); //Instância parametrizado para SubControle que representa um construtor da classe SubControle que não recebe parâmetros
//        System.out.println(construtorSubControle);

        Constructor<SubControle> construtorSubControleComParametro = subControleClasse1.getDeclaredConstructor(String.class); //getDeclaredConstructor com ou sem parâmetro retorna métodos públicos ou não
        System.out.println(construtorSubControleComParametro);

        Constructor<SubControle> construtorSubControleSemParametro = subControleClasse1.getDeclaredConstructor();
        System.out.println(construtorSubControleSemParametro);

        construtorSubControleSemParametro.setAccessible(true);
//        Object subControle = construtorSubControleSemParametro.newInstance(); //Cria-se uma intância da classe que representa
//        System.out.println(subControle); //Como construtorSubControleSemParametro representa um contrutor privado, Se não adicionar true em .setAccessible() será laçado a exceção IlegalAccessException

    //-----------------TESTANDO - A vantagem do Constructor.newInstance()
        Class<?> controleClasse1 = Class.forName("br.com.alura.alurator.playground.controle.Controle");
        //controleClasse1.newInstance(); //Ao rodar irá apresentar uma exception

        try {
            controleClasse1.getDeclaredConstructor().newInstance(); //Obriga o tratamento da exceção checada
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            System.out.println("Teste: " + e.getTargetException());
        }
    }
}
