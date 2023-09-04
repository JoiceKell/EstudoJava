package br.com.alura.fluxosreativos.subscriber;

import br.com.alura.fluxosreativos.model.NotaFiscal;
import br.com.alura.fluxosreativos.wsclient.NotaFiscalWSClient;
import jdk.jshell.JShell;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;

public class NotaFiscalSubscriber implements Subscriber<NotaFiscal> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Chamando o onSubscribe!!");
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(NotaFiscal notaFiscal) {
        NotaFiscalWSClient nfwsc = new NotaFiscalWSClient();
        nfwsc.enviar(notaFiscal);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
    System.out.println("Todas as notas foram emitidas!!");
    }
}
