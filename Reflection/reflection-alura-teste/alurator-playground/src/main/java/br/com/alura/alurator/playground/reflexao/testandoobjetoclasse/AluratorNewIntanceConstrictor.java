package br.com.alura.alurator.playground.reflexao.testandoobjetoclasse;

import java.lang.reflect.InvocationTargetException;

public class AluratorNewIntanceConstrictor {

    private String pacoteBase;

    public AluratorNewIntanceConstrictor(String pacoteBase) {
        this.pacoteBase = pacoteBase;
    }

    public Object executa(String url) {
        // TODO - processa a requisicao executando o metodo da classe em questao
        // /controlador/metodo
        // /produto/lista

        String[] partesUrl = url.replaceFirst("/", "") //Tira a barra inicial
                .split("/"); //Cria um vetor de 2 posições quebrando a string através do separador /

        // produto
        // Produto
        String nomeControle = Character.toUpperCase(partesUrl[0].charAt(0)) +
                // produto -> roduto
                partesUrl[0].substring(1) + "Controller"; //Concatena a string contida na primeira posição do vetor com Controller

        try {
            /*
                Alurator no nosso projeto é uma depêndencia da estoque-api que é a que contém a classe ProdutoController
                Ela não deve saber previamente de qual pacote ele tem que procurar as classes, tendo assim que prover essa informação
                bastante comum quando se utiliza o Spring, tendo que informar qual é o pacote onde será colocado todas as classes que o
                framework precisa monitorar, informando essa informação através de seu Construtor, obrigando a todos que construir seu objeto
                tem obrigatóriamente passar seu pacote base
             */
            Class<?> classeControle = Class.forName(pacoteBase + nomeControle);//Recebe o Full Qualified Name da Classe
            Object instanciaControle = classeControle.getDeclaredConstructor().newInstance();
            System.out.println(instanciaControle);
            return null;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro no construtor! " + e.getTargetException());
        }
    }
}
