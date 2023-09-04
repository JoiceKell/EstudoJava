package br.com.alura.fluxosreativos;

import br.com.alura.fluxosreativos.model.NotaFiscal;
import br.com.alura.fluxosreativos.wsclient.NotaFiscalWSClient;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;

public class TesteEnvioNaoBloqueante {

	public static void main(String[] args) {
		System.out.println("A thread do TesteEnvioNaoBloqueante é: " + Thread.currentThread().getName());

		NotaFiscal primeiraNotaFiscal = new NotaFiscal("Jo�o", 39.99, LocalDate.now());
		SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<>();
		NotaFiscalWSClient nfwsc = new NotaFiscalWSClient();
		publisher.consume(nfwsc::enviar); //Encapsula o subscriber - Recebe uma ação

		publisher.consume(data -> {
			System.out.println("Outra thread: " + Thread.currentThread().getName());
		});

		publisher.submit(primeiraNotaFiscal);
		System.out.println("Voc� ir� receber a nota fiscal no seu e-mail");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();
		publisher.close();
	}
}
