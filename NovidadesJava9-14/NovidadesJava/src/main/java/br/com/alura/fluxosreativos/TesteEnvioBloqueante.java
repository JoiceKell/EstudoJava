package br.com.alura.fluxosreativos;

import br.com.alura.fluxosreativos.model.NotaFiscal;
import br.com.alura.fluxosreativos.wsclient.NotaFiscalWSClient;

import java.time.LocalDate;
import java.util.List;

public class TesteEnvioBloqueante {

	public static void main(String[] args) {

		List<NotaFiscal> notasFiscais = List.of(new NotaFiscal("Jo�o", 39.99, LocalDate.now()),
				new NotaFiscal("Renata", 41.20, LocalDate.now()), new NotaFiscal("Paulo", 32.10, LocalDate.now()),
				new NotaFiscal("Feranda", 15.00, LocalDate.now()));

		NotaFiscalWSClient nfwsc = new NotaFiscalWSClient();
		notasFiscais.forEach(nf -> {
			nfwsc.enviar(nf);
			System.out.println("Parab�ns pela compra!!");
		});
	}
}
