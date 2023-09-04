package br.com.alura.alurator;

import java.util.Map;

import br.com.alura.alurator.conversor.ConversorXML;
//import br.com.alura.alurator.conversor.ConversorXMLSemAnotacao;
import br.com.alura.alurator.ioc.ContainerIoC;
import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.ManipuladorObjeto;
import br.com.alura.alurator.reflexao.Reflexao;

public class Alurator {
	
	private String pacoteBase;
	private ContainerIoC container;

	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
		this.container = new ContainerIoC();
	}
	
	public Object executa(String url) {
		// TODO - processa a requisicao executando o metodo
		// da classe em questao
		
		// Produto lista
		
		// produto -> roduto
		
		Request request = new Request(url);
		
		String nomeControle = request.getNomeControle();
		String nomeMetodo = request.getNomeMetodo();
		Map<String, Object> params = request.getQueryParams();

		//A criação do objeto controle não vai ficar a cargo aqui, mas agora pelo Container IoC
		Class<?> classeControle = new Reflexao().getClasse( pacoteBase + nomeControle );
		Object instanciaControle = container.getInstancia(classeControle);
		Object retorno = new ManipuladorObjeto(instanciaControle)
				.getMetodo(nomeMetodo, params)
				.comTratamentoDeExcecao((metodo, ex) -> {
					System.out.println("Erro no método " + metodo.getName() + " da classe "
							+ metodo.getDeclaringClass().getName() + ".\n\n");
					throw new RuntimeException("Erro no método!");
				})
				.invoca();

//		Object retorno = new Reflexao() //Classe Reflexão é a mãe das classes utilitárias
//			                .refleteClasse( pacoteBase + nomeControle )
//			                .criaInstancia()
//			                .getMetodo(nomeMetodo, params)
//			                .comTratamentoDeExcecao((metodo, ex) -> {
//				                	System.out.println("Erro no método " + metodo.getName() + " da classe "
//				                            + metodo.getDeclaringClass().getName() + ".\n\n");
//				                	throw new RuntimeException("Erro no método!");
//			                })
//			                .invoca();
			
		System.out.println("Retorno: \n" + retorno);

		retorno = new ConversorXML().converte(retorno);

		return retorno;
	}

    public <T, K extends T> void registra(Class<T> tipoFonte, Class<K> tipoDestino) {
    	container.registra(tipoFonte, tipoDestino);
	}
}
