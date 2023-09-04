package br.com.alura.alurator.protocolo;

import java.util.HashMap;
import java.util.Map;

public class Request {

	private String nomeControle;
	private String nomeMetodo;
	private Map<String, Object> queryParams;

	public Request(String url) {
		/*
		* Casos possíveis:
		* /controlador/metodo
		* /controlador/metodo?param1=valor1&param2=valor2
		* /controlador/metodo param1=valor1&param2=valor2 linha 17 faz isso
		*/

		String[] partesUrl = url.replaceFirst("/", "") //Substitui a primeira barra pora nada, retornando uma nova string "produto/lista"
				.split("[?]]");//Quebra a String através do separador barra obtendo-se um vetor de 2 posições [produto, lista], caso 1, caso 2 foi substituido pela expressão regular do ?

		String[] controleMetodo = partesUrl[0].split("/");

		nomeControle = Character.toUpperCase(controleMetodo[0].charAt(0)) //Transforma a primeira parte da url da primeira palavra em maiúscula
				+ controleMetodo[0].substring(1) //Pega todos os caracteres de partesUrl[0] a partir da posição 1
				+ "Controller";

		nomeMetodo = controleMetodo[1];

		queryParams = partesUrl.length > 1 ? new QueryParamsBuilder().withParams(partesUrl[1]).build() : new HashMap<String, Object>();
	}

	public String getNomeControle() {
		return nomeControle;
	}

	public String getNomeMetodo() {
		return nomeMetodo;
	}

	public Map<String, Object> getQueryParams() {
		return queryParams;
	}
}
