package br.com.alura.alurator.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Stream;

//Container de inverção de controle e injeção de dependência
public class ContainerIoC {

    private Map<Class<?>, Class<?>> mapaDeTipos = new HashMap<>(); //Guarda como chave um tipo fonte, ex. ProdutoDao e como valor um tipo destino que queremos que o container de injeção de independência crie sempre que ele encontrar aquele tipo fonte, nesse exemplo, sempre que o container de injeção de dependência encontrar um ProdutoDao intancie um ProdutoDaoMock
    public Object getInstancia(Class<?> tipoFonte) { //Responsável criar a instância

        Class<?> tipoDestino = mapaDeTipos.get(tipoFonte);
        if (tipoDestino != null) { //Se tiver no mapa vinculado algum tipo de destino ao tipo fonte cria-se uma instância do tipoDestino
            return getInstancia(tipoDestino);
        } else {

        }

        //Stream manipula coleções
        Stream<Constructor<?>> constructores = Stream.of(tipoFonte.getDeclaredConstructors()); //Pega todos os construtores declarados na classe e manipulá-los, como é um conjunto de construtores utiliza o stream

        //Filtra os Contrutores procurando um que não tem parâmetro, costrutorPadrão
        Optional<Constructor<?>> construtorPadrao =
                constructores.filter(construtor -> construtor.getParameterCount() == 0) //Pega apenas os construtores padrão
                        .findFirst(); //Pega o primeiro do filtro atribuindo a variável construtorPadrao

        try {
            //Verifica se encontrou um construtor padrão
            if(construtorPadrao.isPresent()) {

                Object instancia = construtorPadrao.get().newInstance(); //Retorna o construtor armazenado com o método get, e de posse do construtor cria-se uma nova instância
                return instancia; //Retorna a instância da classe

            } else { //Se não conseguir localizar um contrutor padrão

                //Pega a lista dos contrutores do tipo fonte que representa a classe, pegando o primeiro da lista de construtores retornado pelo método getDeclaredConstructors()
                //Se não contém um construtor padrão, tanto faz qual construtor pegar
                Constructor<?> construtor = tipoFonte.getDeclaredConstructors()[0]; //Se não tem o construtor padrão pega o primeiro retonado

                List<Object> params = new ArrayList<>(); //Armazena os parametros do construtor
                //No final do for terá uma lista de parâmetros toda construida com os objetos que são argumentos do construtor
                for(Parameter param : construtor.getParameters()) { //Itera cada um dos parÂmetros do construtor
                    Class<?> tipoDoParametro = param.getType(); //A cada parâmetro que obtém do for, pegará o tipo do parâmetro
                    params.add(getInstancia(tipoDoParametro)); //Passa o tipo do parâmetro para o método que estamos construindo, pq? Preciso de um objeto daquele tipo do parâmetro, uma vez que temos a posse do objeto coloca na lista de parâmetros
                }

                //Retorna a instância da classe
                return construtor.newInstance(params.toArray()); //Pega o construtor chama o método newInstance() para criar uma instância do objeto passando os parâmetros
            }
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    //O tipo T pode ser um tipo qualquer, mas o tipo K necessariamente tem que ser um subTipo de T, é a mesma coisa que fazíamos no método verificaCompatibilidade(Class<?> tipoFonte, Class<?> tipoDestino) não precisando mais dele
    public <T, K extends T> void registra(Class<T> tipoFonte, Class<K> tipoDestino) {
        //Com Generics não precisa mas desse trecho de código
//        boolean compativel = verificaCompatibilidade(tipoFonte, tipoDestino);
//
//        //Só será disparado a exceção em tempo de execução
//        if(!compativel) throw new ClassCastException("Não foi possível resolver " + tipoFonte.getName() + " para " + tipoDestino.getName());

        mapaDeTipos.put(tipoFonte, tipoDestino);
    }

//    private boolean verificaCompatibilidade(Class<?> tipoFonte, Class<?> tipoDestino) {
//        //Verificar compatibilidade
////        boolean compativel;
////
////        if(tipoFonte.isInterface()) { //Verifca se o tipoFonte é uma interface
////            //Pega todas as interfaces que o tipoDestino implementa e verificar se o tipoFonte é uma delas
////            compativel = Stream.of(tipoDestino.getInterfaces())
////                    .anyMatch(interfaceImplementada -> interfaceImplementada.equals(tipoFonte)); //Retorna true or false
////        } else { //Se não é uma interface é uma classe, sendo uma classe ou ele é igual ao tipoDestino ou então o tipoDestino tem que estender do tipoFonte
////            compativel = tipoDestino.getSuperclass().equals(tipoFonte) //Saber qual é a classe que extende, com isso só verifica se o tipo fonte é a super classe de tipoDestino
////                                        || tipoDestino.equals(tipoFonte); //Verificar se eles são a mesma classe
////        }
////        return compativel;
//
//        //Verificar compartibilidade com API de Reflection
//        return tipoFonte.isAssignableFrom(tipoDestino); //Ele pega o tipo Destino e vai tentar convertê-lo no tipo fonte
//    }
}
