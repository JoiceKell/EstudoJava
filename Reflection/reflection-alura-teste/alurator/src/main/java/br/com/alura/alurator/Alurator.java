package br.com.alura.alurator;

import java.util.Map;

import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.Reflexao;

public class Alurator {

	private String pacoteBase;

	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
	}

	public Object executa(String url) {
		// TODO - processa a requisicao executando o metodo da classe em questao

		Request request = new Request(url);

		String nomeControle = request.getNomeControle();
		String nomeMetodo = request.getNomeMetodo();
		Map<String, Object> params = request.getQueryParams();

		Object retorno = new Reflexao()
				.refleteClasse( pacoteBase + nomeControle ) //Classe que quer refletir, obter todas as informações
				.criaInstancia()
				.getMetodo(nomeMetodo, params)
//				NÃO ENTENDI BiFunction
//				.comTratamentoDeExcecao((metodo, ex) -> {
//					System.out.println("Erro no método " + metodo.getName() + " da classe " + metodo.getDeclaringClass().getName() + ".\n\n");
//					throw new RuntimeException("Erro método!");
//				})
		.invoca();

		System.out.println(retorno);

		return retorno;
	}
}
