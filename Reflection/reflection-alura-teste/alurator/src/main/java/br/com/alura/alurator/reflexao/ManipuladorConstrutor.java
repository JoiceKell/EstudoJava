package br.com.alura.alurator.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//Pode manipular qualquer tipo de construtor
public class ManipuladorConstrutor {

	private Constructor<?> construtor;

	public ManipuladorConstrutor(Constructor<?> construtor) {
		this.construtor = construtor;
	}

	public Object invoca() {
		try {
			return construtor.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException e) {
			e.printStackTrace();
			return new RuntimeException(e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			return new RuntimeException("Erro no construtor!", e.getTargetException()); //e.getTargetException()Pega o erro gerado no contrutor
		}
	}

}
