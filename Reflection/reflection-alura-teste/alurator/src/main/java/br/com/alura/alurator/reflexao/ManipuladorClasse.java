package br.com.alura.alurator.reflexao;

import java.lang.reflect.Constructor;

public class ManipuladorClasse {

	private Class<?> classe;

	public ManipuladorClasse(Class<?> classe) {
		this.classe = classe;
	}

	public ManipuladorConstrutor getConstrutorPadrao() {
		try {
			Constructor<?> construtorPadrao = classe.getDeclaredConstructor(); //Não passa parâmetro, pois queremos o construtor padrão
			return new ManipuladorConstrutor(construtorPadrao);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public ManipuladorObjeto criaInstancia() {
		Object instancia = getConstrutorPadrao().invoca(); //Método criado em ManipulaConstrutor para devolver um objeto instanciado
		return new ManipuladorObjeto(instancia);
	}

}
