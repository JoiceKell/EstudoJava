package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteInvocaMetodoSemParametro {
    public static void main(String[] args) throws Exception {
        Class<?> subControleClasse = Class.forName("br.com.alura.alurator.playground.controle.SubControle");

        Constructor<?> constructorPadrao = subControleClasse.getDeclaredConstructor();
        constructorPadrao.setAccessible(true); //Contrutor privado, para criar uma intância de SubControle precisa-se modificar o acesso dele utilizando o método
        Object subControle = constructorPadrao.newInstance();

        //Listar todos os métodos públicos da classe SubControle, da super classe e das interfaces
        for(Method m : subControleClasse.getMethods()) {
            System.out.println(m);
        }

        System.out.println();

        //Listar os métodos apenas da classe de inferência públicos ou privados
        for(Method m : subControleClasse.getDeclaredMethods()) {
            System.out.println(m);
        }

        System.out.println();

        Method m = subControleClasse.getDeclaredMethod("metodoSubControle2"); //Se quiser executar o método SubControle1 da classe basta trocar o nome do método
        m.setAccessible(true);
        Object retorno = m.invoke(subControle); //Método invoke() executa o método, que recebe 2 parâmetros o objeto que representa a instância que ocntém o método apresentado e o argumento(parâmetros)
        System.out.println(retorno);
    }
}
