package br.com.alura.alurator.protocolo;

import java.util.HashMap;
import java.util.Map;

public class Request {
	
	private String nomeControle;
	private String nomeMetodo;
	private Map<String, Object> queryParams; //Representa o dado chave-valor da url dos parâmetros param1=valor param2=valor2

	public Request(String url) {
		/*
		 * Casos possiveis:
		 * /nomeControle/nomeMetodo
		 * /controlador/metodo?param1=valor1&param2=valor2
		 * 
		 * /controlador/metodo param1=valor1&param2=valor2
		 */
		String[] partesUrl = url.replaceFirst("/", "")
				.split("[?]"); //Quebra pela interrogação e não mais pela barra /controlador/metodo?param1=valor1&param2=valor2 ficando controlador/metodo param1=valor1&param2=valor2. ? é um caracterer especial em expressões regulares, então para apresentá-lo como um caracterer envelopa-o com colchetes []
		
		String[] controleEMetodo = partesUrl[0].split("/"); // controlador/metodo fica controlador metodo

		nomeControle = Character.toUpperCase(controleEMetodo[0].charAt(0)) + 
				controleEMetodo[0].substring(1) + "Controller"; // ControladorController
		
		nomeMetodo = controleEMetodo[1]; // metodo
		
		queryParams = partesUrl.length > 1 //Se tiver tamanho 1 significa que estamos tratando do caso onde o método não possui parâmetros
				? new QueryParamsBuilder().comParametros(partesUrl[1]).build()
				: new HashMap<String, Object>();
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
