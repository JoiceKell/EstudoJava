package br.com.alura.switchexpression;

public class Teste {

	public static void main(String[] args) {
//		String nome = "Jo�o";
//		switch (nome) {
//			case "Renata": {
//				System.out.println("Acertou: " + nome);
//				break;
//			}
//			case "João": {
//				System.out.println("Acertou: " + nome);
//				break;
//			}
//			default: {
//				System.out.println("Nenhum nome encontrado!!");
//			}
//		}

		String nome = "João";
		switch (nome) {
			case "Renata" -> System.out.println("Acertou: " + nome);
			case "João" -> System.out.println("Acertou: " + nome);
			default -> System.out.println("Nenhum nome encontrado!!");
		}
	}
}