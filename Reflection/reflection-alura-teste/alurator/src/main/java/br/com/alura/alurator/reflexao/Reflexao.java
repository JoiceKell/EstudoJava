package br.com.alura.alurator.reflexao;

public class Reflexao {

	public ManipuladorClasse refleteClasse(String fullQualifiedName) {
		try {
			Class<?> classe = Class.forName(fullQualifiedName);
			
			return new ManipuladorClasse(classe);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
