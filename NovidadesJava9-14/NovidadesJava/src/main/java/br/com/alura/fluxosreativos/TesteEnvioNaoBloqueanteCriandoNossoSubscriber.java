package br.com.alura.fluxosreativos;

import br.com.alura.fluxosreativos.model.NotaFiscal;
import br.com.alura.fluxosreativos.subscriber.NotaFiscalSubscriber;
import br.com.alura.fluxosreativos.wsclient.NotaFiscalWSClient;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.SubmissionPublisher;

public class TesteEnvioNaoBloqueanteCriandoNossoSubscriber {

	public static void main(String[] args) {

		NotaFiscal primeiraNotaFiscal = new NotaFiscal("João", 39.99, LocalDate.now());
		NotaFiscal segundaNotaFiscal = new NotaFiscal("Renata", 39.99, LocalDate.now());
		NotaFiscal terceiraNotaFiscal = new NotaFiscal("Paulo", 39.99, LocalDate.now());

		SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<>();

		NotaFiscalSubscriber subscriber = new NotaFiscalSubscriber();
		publisher.subscribe(subscriber);

		publisher.submit(primeiraNotaFiscal);
		publisher.submit(segundaNotaFiscal);
		publisher.submit(terceiraNotaFiscal);

		System.out.println("Voc� ir� receber a nota fiscal no seu e-mail");

		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();
		publisher.close();
	}
}
