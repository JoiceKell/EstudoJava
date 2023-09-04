package br.com.alura.alurator.playground.reflexao.testeinstanciaobjeto.teste;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.playground.controle.SubControle;

//Teste obter os Construtores da classe SubControle e Controle
public class TesteInstanciaObjetoCorretamente {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Class<SubControle> subControleClasse1 = SubControle.class; //Inferência classe SubControle

		Class<?> subControleClasse2 =
				Class.forName("br.com.alura.alurator.playground.controle.SubControle");

		Class<?> controleClasse1 =
				Class.forName("br.com.alura.alurator.playground.controle.Controle");

//----------------------------------------------------------------------------------------------------------------------

		//Construtor público
		//Tem uma instância de Constructor parametrizado para a classe SubControle, que representa um construtor padrão da classe
		Constructor<SubControle> construtorSubControle =
				subControleClasse1.getConstructor(); //Terá como retorno o Construtor que não recebe nenhum parâmetro público da classe Subcontrole

		System.out.println("Construtor público sem argumento: " +construtorSubControle);

//----------------------------------------------------------------------------------------------------------------------

		//Construtor privado
//		Constructor<SubControle> construtorSubControleComArgs =
//				subControleClasse1.getDeclaredConstructor(String.class); //Terá como retorno o Construtor que recebe uma String como , sendo ele privado da classe Subcontrole
//
//		System.out.println(construtorSubControleComArgs);

//----------------------------------------------------------------------------------------------------------------------

		//Construir um objeto privado com argumento a partir desse construtor construido
//		construtorSubControleComArgs.setAccessible(true);
//		Object subControleComArgs = construtorSubControleComArgs.newInstance("TESTE ARGUMENTO");//Não é o mesmo método depreciado da classe Class, mas aqui é da classe Constructor
//		System.out.println("Construtor privado com argumento: " + subControleComArgs); //Se não adicionar o setAccessible(true) a exceção IllegalAccessException é lançada, por se tratar de um construtor privado

//----------------------------------------------------------------------------------------------------------------------

		//Construir um objeto privado sem argumento a partir desse construtor construido
//		Constructor<SubControle> construtorSubControleSemArgsPrivado =
//				subControleClasse1.getDeclaredConstructor();
//
//		construtorSubControleSemArgsPrivado.setAccessible(true);
//		Object subControleSemArgs = construtorSubControleSemArgsPrivado.newInstance();
//		System.out.println("Construtor privado sem argumento: " + subControleSemArgs);

//----------------------------------------------------------------------------------------------------------------------

		//Construir um objeto público com argumento a partir desse construtor construido
		Constructor<SubControle> construtorSubControleComArgsPublico =
				subControleClasse1.getConstructor(String.class);
		construtorSubControleComArgsPublico.newInstance("TESTE ARGS PÚBLICO");
		System.out.println("Construtor público com argumento: " + construtorSubControleComArgsPublico);

//----------------------------------------------------------------------------------------------------------------------

//		try {
//			controleClasse1.getDeclaredConstructor().newInstance();
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//			System.out.println(e.getTargetException());
//		}
	}

}
