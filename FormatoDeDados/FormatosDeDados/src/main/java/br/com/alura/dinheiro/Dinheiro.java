package br.com.alura.dinheiro;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.NumericToWordsConverter;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryOperators;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.NumberValue;

//https://mvnrepository.com/artifact/org.javamoney/moneta/1.4.2
public class Dinheiro {
    public static void main(String[] args) {
        CurrencyUnit moeda = Monetary.getCurrency("BRL");
        MonetaryAmount valorDaParcela = Money.of(75, moeda);
        System.out.println(valorDaParcela);

        MonetaryAmount valorTotal = valorDaParcela.multiply(12);
        System.out.println(valorTotal);

        //Para utilizar porcentagem
        MonetaryAmount desconto = valorTotal.with(MonetaryOperators.percent(10));
        System.out.println(desconto);

        NumberValue descontoSemMoeda = desconto.getNumber(); //Pega apenas o valor, sem a moeda

        NumericToWordsConverter conversor = new NumericToWordsConverter(new FormatoDeReal());
        String valorPorExtenso = conversor.toWords(descontoSemMoeda.doubleValue());
        System.out.println(valorPorExtenso);
        System.out.println("Olá Aluno. Ganhe " + valorPorExtenso + " de desconto!");

    }
}
