package br.com.alura.alurator.conversor;

import br.com.alura.alurator.conversor.anotacao.NomeTagXml2;

import java.lang.reflect.Field;
import java.util.Collection;

public class ConversorXML {
    public String converte(Object objeto) {

        try {
            Class<?> classeObjeto = objeto.getClass(); //Pegar a classe do objeto
            StringBuilder xmlBuilder = new StringBuilder(); //Fazer concatenação de string

            //Pq estamos verificando se o objeto é uma instância de Collection?
            //Porque podemos receber como parâmetro do método tanto um objeto simples quanto uma lista
            /*
                ----------------------- XML OBJETO SIMPLES ----------------------

             */

            /*
                ----------------------- XML OBJETO LISTA ----------------------

             */
            if(objeto instanceof Collection) { //Objeto é uma lista
                Collection<?> colecao = (Collection<?>)objeto;

                xmlBuilder.append("<lista>"); //Abertura da tag lista

                    for (Object o : colecao) {
                        String xml = converte(o);
                        xmlBuilder.append(xml);
                    }

                xmlBuilder.append("</lista>"); //Fechamento da tag lista

            } else { //Objeto é simples

                NomeTagXml2 anotacaoClasse = classeObjeto.getDeclaredAnnotation(NomeTagXml2.class); //Recuperar a anotação, ele retorna o tipo NomeTagXml2 se utilizada a anotação na classe, se não utilizou retorna null

                //Se anotacaoClasse for == null irá utilizar o full qualified name da classe, caso contrário será retornado o valor passado na anotação
                String nomeClasse =
                                anotacaoClasse == null ? classeObjeto.getName() : anotacaoClasse.value(); //classeObjeto.getName() pega o nome da classe inferida pelo objeto da classe Class


                xmlBuilder.append("<" + nomeClasse + ">"); //Abre a tag inicial com o nome da classe

                    for (Field atributo : classeObjeto.getDeclaredFields()) { //Percorrer os atributos, getDeclaredFields() pega todos os atributos privados ou públicos

                        atributo.setAccessible(true);

                        NomeTagXml2 anotacaoAtributo = atributo.getDeclaredAnnotation(NomeTagXml2.class); //Retorna as anotações declaradas nele mesmo

                        //Se anotacaoClasse for == null irá utilizar o nome do atributo, caso contrário será retornado o valor passado na anotação
                        String nomeAtributo =
                                            anotacaoAtributo == null ? atributo.getName() : anotacaoAtributo.value();

                        Object valorAtributo = atributo.get(objeto); //Objeto que será pego a informação

                        xmlBuilder.append("<" + nomeAtributo + ">");
                            xmlBuilder.append(valorAtributo);
                        xmlBuilder.append("</" + nomeAtributo + ">");

                    }

                xmlBuilder.append("</" + nomeClasse + ">");
            }

            return xmlBuilder.toString();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro na geração do XML!");
        }
    }
}
