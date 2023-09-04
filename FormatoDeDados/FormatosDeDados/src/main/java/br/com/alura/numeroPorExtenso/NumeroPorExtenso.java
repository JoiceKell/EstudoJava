package br.com.alura.numeroPorExtenso;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.InteiroSemFormato;
import br.com.caelum.stella.inwords.NumericToWordsConverter;

import java.math.BigDecimal;

public class NumeroPorExtenso {
    public static void main(String[] args) {
        NumericToWordsConverter conversor = new NumericToWordsConverter(new InteiroSemFormato()); //Numero por extenso
        NumericToWordsConverter conversor2 = new NumericToWordsConverter(new FormatoDeReal()); //Transforma o valor para real

        //Ao trabalhar com valor não é interessante utilizar o double, mas sim o BigDecimal por conta de sua precisão.
        BigDecimal valor = new BigDecimal("75.00");
        String valorPorExtenso = conversor.toWords(valor.doubleValue()); //toWords recebe um double
        System.out.println(valorPorExtenso + "reais");

        BigDecimal valor2 = new BigDecimal("654.99");
        String valorPorExtenso2 = conversor2.toWords(valor2.doubleValue()); //toWords recebe um double
        System.out.println(valorPorExtenso2);
    }
}
