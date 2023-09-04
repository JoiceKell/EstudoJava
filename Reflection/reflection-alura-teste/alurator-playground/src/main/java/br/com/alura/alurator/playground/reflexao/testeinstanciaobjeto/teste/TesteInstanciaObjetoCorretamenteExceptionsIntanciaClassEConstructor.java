package br.com.alura.alurator.playground.reflexao.testeinstanciaobjeto.teste;

import br.com.alura.alurator.playground.reflexao.testeinstanciaobjeto.SubControle;

import java.lang.reflect.InvocationTargetException;

//Teste obter os Construtores da classe SubControle e Controle
public class TesteInstanciaObjetoCorretamenteExceptionsIntanciaClassEConstructor {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException {

		Class<SubControle> subControleClasse1 = SubControle.class; //Inferência classe SubControle

		Class<?> subControleClasse2 =
				Class.forName("br.com.alura.alurator.playground.reflexao.testeinstanciaobjeto.SubControle");

		Class<?> controleClasse1 =
				Class.forName("br.com.alura.alurator.playground.reflexao.testeinstanciaobjeto.SubControle");

//----------------------------------------------------------------------------------------------------------------------

//		controleClasse1.newInstance();//newInstance() do objeto Class não realiza o tratamento de exceções

		//Quando invoca o método newInstance da classe Constructor<T> ele obriga o tratamento da exceção checked InvocationTargetException que é lançada sempre que o construtor lança uma exceção
		try {
			controleClasse1.getDeclaredConstructor().newInstance();
		} catch (InvocationTargetException e) {
			System.out.println(e.getTargetException());
			throw new RuntimeException(e);
		}
	}

}
