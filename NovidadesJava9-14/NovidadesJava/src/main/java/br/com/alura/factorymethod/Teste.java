package br.com.alura.factorymethod;

import java.util.*;

public class Teste {

	public static void main(String[] args) {
        /*
		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("primeiroNome");
		nomes.add("segundoNome");
		nomes.add("terceiroNome");
		List<String> nomesImutavel = Collections.unmodifiableList(nomes);
		System.out.println(nomesImutavel);
		 */

		//Factory Method para Collection
		List<String> nomes = List.of("primeiro nome", "segundo nome");
		System.out.println(nomes);

		Set<String> nomeSet = Set.of("terceiro nome");

		Map<String, String> nomeMap = Map.of("nome", "João");
	}
}
