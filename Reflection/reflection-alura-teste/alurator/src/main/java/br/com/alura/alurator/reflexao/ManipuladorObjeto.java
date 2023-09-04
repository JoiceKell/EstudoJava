package br.com.alura.alurator.reflexao;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

public class ManipuladorObjeto {

	private Object instancia;

	public ManipuladorObjeto(Object instancia) {
		this.instancia = instancia;
	}

	public ManipuladorMetodo getMetodo(String nomeMetodo, Map<String, Object> params) {
		// Levando em consideração od parâmetros do método
		// 1) Pegar todos os métodos da classe. Utilizando o Method
		// 2) Filtrar todos os métodos de modo que: Utilizando a api de Stream para manipulação de conjuntos. CONJUNTO DE STREANS DOS MÉTODOS
		//  2.1) Tenham o mesmo nome informado pelo usuário; Sabemos qual é esse nome pela variável nomeMetodo
		//  2.2) Tenham a mesma quantidade de parâmetros passados na URL;
		//  2.3) E que cada um dos parâmetros tenham os mesmos nomes e tipos iguais aos passados na URL. CONJUNTO DE STREANS DOS PARÂMETROS DO MÉTODO

			// /filtra?nome=produto => filtra(String nome)
			// /produto/filtra?nome=produto&marca=marca 1 => filtra(String nome, String marca)
			// /filtra?marca=marca 1&nome=produto => filtra(String nome, String marca)
			// /filtra?batman=marca 1&nome=produto => filtra(String nome, String batman)

		// 3) Lançar uma RuntimeException caso nenhum método seja encontrado.

		//instancia.getClass().getDeclaredMethods() pega todos os métodos da classe
		//Para trabalhar com o conjunto de métodos utiliza-se o Stream
		Stream<Method> metodos = Stream.of(instancia.getClass().getDeclaredMethods());
		Method metodoSelecionado = metodos.filter(metodo -> //Filtra para cada método aplica-se uma expressão lambda de condição de filtragem
						metodo.getName().equals(nomeMetodo) //Tenham o mesmo nome informado pelo usuário
								&& metodo.getParameterCount() == params.values().size() //Tenham a mesma quantidade de parâmetros passados na URL
								&& Stream.of(metodo.getParameters()) //Cada um dos parâmetros tenham os mesmos nomes e tipos iguais aos passados na URL. getParameters() retorna todos os parâmetros do método
								.allMatch(arg -> { //Passa por cada parâmetro e verifica se cada um dos itens da lista atende determinada condição definida
									System.out.println(arg.getName());
									return params.keySet().contains(arg.getName()) //Nome do parâmetro esteja no mapa de parâmetros passados pelo usuário. params.keySet() pega o conjunto de chaves do mapa
											//Pega o valor passado pelo usuário no mapa, pega a classe desse valor, e compara com o tipo do parâmetro que ele aceita
											&& params.get(arg.getName()).getClass().equals(arg.getType()); //Gantir que o tipo passado pelo  usuário ´exatamente o mesmo tipo do argumento do método. params.get obtém o valor da chave em questão, sendo a cheve o nome do método e para verificar o tipo do valor no mapa utiliza-se o getClass
								})
				)
				.findFirst() //Dado que terminou a filtragem haja apenas 1 único método que atendeu a todas as caracteristicas passadas através da lambda
				.orElseThrow(() -> new RuntimeException("Método não encontrado!")); //Lançar uma RuntimeException caso nenhum método seja encontrado, ou seja, se não conseguir obter ninguém dentro da Stream lança-se uma exceção

		return new ManipuladorMetodo(instancia, metodoSelecionado, params);
	}

}
