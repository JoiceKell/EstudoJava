package br.com.alura.fluxosreativos.subscriber;

import br.com.alura.fluxosreativos.model.NotaFiscal;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class NotaFiscalFiltro extends SubmissionPublisher implements Flow.Processor {

    // Métodos escondidos, porém utilizando a mesma implementação do NotaFiscalSubscriber

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

    }

    @Override
    public void onNext(Object nf) {
        NotaFiscal notaFiscal = (NotaFiscal) nf;
        if(notaFiscal.getValor() >= 0.0) {
            submit(nf);
        } else {
            System.out.println("Nota fiscal com o valor menor ou igual a zero");
        }
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}