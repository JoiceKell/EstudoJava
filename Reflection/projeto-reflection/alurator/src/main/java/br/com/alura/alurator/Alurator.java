package br.com.alura.alurator;

import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.Reflexao;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Alurator {

	private String pacoteBase;

	public Alurator(String pacoteBase) {

		this.pacoteBase = pacoteBase;
	}

	public Object executa(String url) {
		Request request = new Request(url);

		String nomeControle = request.getNomeControle();
		String nomeMetodo = request.getNomeMetodo();
		Map<String, Object> params = request.getQueryParams();

		/*
		Object instanciaControle = new Reflexao().refleteClasse(pacoteBase + nomeControle).getConstrutorPadrao().invoca();
		// - Object retorno = new Reflexao().refleteClasse(pacoteBase + nomeControle).getMetodo(nomeMetodo).invoca(instanciaControle); //Isso é errado, repetição de instância com a linha superior
		*/

		Object retorno = new Reflexao().refleteClasse(pacoteBase + nomeControle).criaInstancia().getMetodo(nomeMetodo, params).invoca();


		System.out.println(retorno);

		return retorno;

	}
}
