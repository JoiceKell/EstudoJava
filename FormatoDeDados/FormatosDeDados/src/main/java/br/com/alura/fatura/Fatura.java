package br.com.alura.fatura;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.NumericToWordsConverter;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.NumberValue;

public class Fatura {
    public static void main(String[] args) {
        String cpf = "51720155232";

        CPFValidator validadorCPF = new CPFValidator();
        try{
            validadorCPF.assertValid(cpf);
            CurrencyUnit real = Monetary.getCurrency("BRL");
            MonetaryAmount valorFaturaCartao = Money.of(900, real);

            NumberValue valorFaturaCartaoSemMoeda = valorFaturaCartao.getNumber();

            NumericToWordsConverter conversor = new NumericToWordsConverter(new FormatoDeReal());
            String valorFaturaCartaoPorExtenso = conversor.toWords(valorFaturaCartaoSemMoeda.doubleValue());

            System.out.println("Caro cliente. Sua fatura esse mês chegou no valor de " + valorFaturaCartaoPorExtenso);

        }catch (InvalidStateException e) {
            System.out.println("Olá cliente, favor entrar no nosso sistema e atualizar seus dados pois seu CPF é inválido." );
        }
    }
}
