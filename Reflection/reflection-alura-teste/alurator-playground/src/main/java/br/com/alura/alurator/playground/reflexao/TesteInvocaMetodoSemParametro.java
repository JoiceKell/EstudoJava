package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteInvocaMetodoSemParametro {

	public static void main(String[] args) throws Exception {
		Class<?> subControleClasse =
				Class.forName("br.com.alura.alurator.playground.controle.SubControle");

//----------------------------------------------------------------------------------------------------------------------

		//Listar todos os métodos da classe SubControle, super classe e das interafces que porventura possa implementar
		for (Method m : subControleClasse.getMethods()) {
			System.out.println(m);
		}
		
		System.out.println();

//----------------------------------------------------------------------------------------------------------------------

		//Listar todos os métodos da classe que está sendo inferida - SubControle
		for (Method m : subControleClasse.getDeclaredMethods()) {
			System.out.println(m);
		}

		System.out.println();

//----------------------------------------------------------------------------------------------------------------------

		//Instanciação de um objeto para o método invoke
		Constructor<?> construtorPadrao = subControleClasse.getDeclaredConstructor();
		construtorPadrao.setAccessible(true); //Contrutor privado
		Object subControle = construtorPadrao.newInstance();

		//Invocação do método
		Method m = subControleClasse.getDeclaredMethod("metodoSubControle2"); //Parâmetro é o nome do método
		m.setAccessible(true); //Método privado

		Object retorno = m.invoke(subControle); //invoke(obj. args) obj- é o objeto que representa a instância que contém o método representado pela intância de Method

		System.out.println(retorno);
	}

}
