package br.com.alura.alurator.playground.reflexao.testeinstanciaobjeto;

import java.io.IOException;

public class SubControle extends Controle {

	public SubControle() throws IOException {}
	
	public SubControle(String s) throws IOException {}
	
	public void metodoSubControle1() {
		System.out.println("Executando método SubControle.metodoSubControle1()");
	}
	
	private String metodoSubControle2() {
		System.out.println("Executando método SubControle.metodoSubControle2()");
		
		return "retorno do método SubControle.metodoSubControle2()";
	}
}

