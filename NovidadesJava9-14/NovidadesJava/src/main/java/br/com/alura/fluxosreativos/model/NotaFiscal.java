package br.com.alura.fluxosreativos.model;

import java.time.LocalDate;

public class NotaFiscal {

	private String nome;
	@SuppressWarnings("unused")
	private Double valor;
	private LocalDate data;

	public NotaFiscal(String nome, Double valor, LocalDate data) {
		this.nome = nome;
		this.valor = valor;
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getData() {
		return data;
	}

	public Double getValor() {
		return valor;
	}
}
