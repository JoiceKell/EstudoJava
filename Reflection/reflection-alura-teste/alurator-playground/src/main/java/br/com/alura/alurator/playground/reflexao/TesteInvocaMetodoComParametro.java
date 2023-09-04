package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteInvocaMetodoComParametro {

	public static void main(String[] args) throws Exception {

		//Objto da classe Class inferindo objeto da classe Controle
		Class<?> controleClasse =
				Class.forName("br.com.alura.alurator.playground.controle.Controle");

		//Obtive o Construtor padrão da classe
		Constructor<?> construtorPadrao = controleClasse.getDeclaredConstructor();

		//Criação da instância da classe Controle
		Object controle = construtorPadrao.newInstance();

		//Obtenção do método "metodoControle2"
		Method m = controleClasse.getDeclaredMethod("metodoControle2", String.class, Integer.class);

		//Invocação do método, passando a instãncia da classe Controle
		Object retorno = m.invoke(controle, "Pintassilgo do Agreste", 1);
		
		System.out.println(retorno);
	}

}
