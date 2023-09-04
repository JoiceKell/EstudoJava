package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteInvocaMetodoComParametro {
    public static void main(String[] args) throws Exception {
        Class<?> controleClasse = Class.forName("br.com.alura.alurator.playground.controle.Controle");

        Constructor<?> constructorPadrao = controleClasse.getDeclaredConstructor();

        Object controle = constructorPadrao.newInstance();

        Method m = controleClasse.getDeclaredMethod("metodoControle2", String.class, Integer.class);

        Object retorno = m.invoke(controle, "Pintassilgo do Agreste", 1); //Método invoke() executa o método, que recebe 2 parâmetros o objeto que representa a instância que ocntém o método apresentado e o argumento(parâmetros)

        System.out.println(retorno);
    }
}
