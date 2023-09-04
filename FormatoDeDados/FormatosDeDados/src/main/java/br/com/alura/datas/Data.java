package br.com.alura.datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Data {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(hoje.format(formatador));

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatadorComHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        System.out.println(agora);
        System.out.println(agora.format(formatadorComHora));

        //Formata sem precisar passar um partner, para utilizar o FULL e o LONG tem que utilizar o ofLocalizedDateTime para trabalhar só com data.
        //Para trabalhar com Localização utiliza o withLocale, todavia não possuí o Brasil em sua Lista precisando criar um novo
//        DateTimeFormatter formatadorCurto = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.CHINA);
        DateTimeFormatter formatadorCurto = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("pt", "br"));
        System.out.println(agora.format(formatadorCurto));

        //SUBTRAIR UMA DATA
        System.out.println(agora.minusHours(5));

        //ADICIONAR
        System.out.println(agora.plusHours(1));

    }
}
