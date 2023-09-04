package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso {
    public static void main(String[] args) {
        Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

        //aulas referencia javaColecoes.getAulas(), ou seja, se mudar em um muda em outro
        /*
        List<Aula> aulas = javaColecoes.getAulas();
        aulas.add(new Aula("Trabalhando com ArrayList", 21));
        */

        //Como retorna List pode ser chama o método add direto
        /*
        javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21));
         */

        javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 24));

        List<Aula> aulasImutaveis = javaColecoes.getAulas();
        System.out.println(aulasImutaveis);

        List<Aula> aulas = new ArrayList<>(aulasImutaveis);

        Collections.sort(aulas);
        System.out.println(aulas);

        System.out.println(javaColecoes.getTempoTotal());
        System.out.println(javaColecoes);

    }
}
