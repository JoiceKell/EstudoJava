package br.com.alura.alurator.reflexao;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

public class ManipuladorObjeto {
    private Object instancia;

    public ManipuladorObjeto(Object instancia) {

            this.instancia = instancia;
    }

    public ManipuladorMetodo getMetodo(String nomeMetodo, Map<String, Object> params) {

        // 1) Pegar todos os métodos da classe.
        // 2) Filtrar todos os métodos de modo que:
        // 2.1) Tenham o mesmo nome informado pelo usuário;
        // 2.2) Tenham a mesma quantidade de parâmetros passados na URL;
        // 2.3) E que cada um dos parâmetros tenham os mesmos nomes e tipos iguais
        // aos passados na URL.
        // 3) Lançar uma RuntimeException caso nenhum método seja encontrado.

        // /filtra?nome=produto => filtra(String nome)
        // /filtra?nome=produto&marca=marca 1 =>filtra(String nome, String marca)
        // /filtra?marca=marca 1&nome=produto => filtra(String nome, String marca)


        Stream<Method> metodos = Stream.of(instancia.getClass().getDeclaredMethods());//Pega todos os métodos da classe pelo getClass() e transforma em uma stream.
        Method metodoSelecionado = metodos.filter(metodo -> //Filtra para cada método
                                                    metodo.getName().equals(nomeMetodo) //Tem que ter o mesmo nome informado pelo usuário
                                                    && metodo.getParameterCount() == params.values().size() //Tenham a mesma quantidade de parâmetros passados na URL;
                                                    && Stream.of(metodo.getParameters()) //retorna todos os parâmetros do método
                                                        .allMatch(arg -> { //Para cada um dos itens da Stream que no caso são os parâmetros vai verificar se cada um dos itens da stream atente uma dada condição definida

                                                            System.out.println("Teste: " + arg.getName());

                                                            return params.keySet().contains(arg.getName())//Garante o mesmo Nome do parâmetro esteja no mapa de parâmetros passados pelo usuário, keySet() pega o conjunto de  chaves do mapa, getName() pega o nome do paramêtro
                                                                    && params.get(arg.getName()).getClass().equals(arg.getType());//Garante que o mesmo tipo passado pelo usuário é exatamente igual ao argumento do método que consegue receber .get(recebe uma key). E para verificar o tipo de valor a ser obtido no mapa adiciona-se o .Class
                                                        }) //Nome e tipo tem que ser igual dos parâmetros, só que agora o conjunto de Strems não vai ser de um método, mas sim dos parâmetros do método
                                                )
                                        .findFirst() //Após a filtragem haja apenas um único método que atendeu a todas as caracteristicas passadas, com o findFirst ele retorna um Optional que permite executar um método que irá lançar uma exception caso não tenha nada dentro desse stream resultante
                                        .orElseThrow(() -> new RuntimeException("Método não encontrado!"));

        return new ManipuladorMetodo(instancia, metodoSelecionado, params);
    }
}
