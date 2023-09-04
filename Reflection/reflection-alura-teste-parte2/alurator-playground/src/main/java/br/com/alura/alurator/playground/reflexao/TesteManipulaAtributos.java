package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.modelo.Produto;

import java.lang.reflect.Field;

public class TesteManipulaAtributos {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {

        Object produto = new Produto("Produto 1", 20.0, "Marca 1"); //Pq Object, pois queremos transformar em XML qualquer Objeto
        Class<?> classe = produto.getClass();

        System.out.println(classe.getField("id")); //Está na super classe, retorna apenas atributos o públicos

        //Iterar o objeto produto por cada um de seus atributos mostrando na tela o atributo e seu respectivo valor, sem considerar possíveis atributos de superclasses
        for (Field atributo : classe.getDeclaredFields()) {
            atributo.setAccessible(true);
            System.out.println(atributo.getName() + ": " + atributo.get(produto)); //atributo.getName() nome do atributo, atributo.get(produto) valor do atributo que recebe como parâmetro o objeto ao qual o atributo pertence
        }
    }
}
