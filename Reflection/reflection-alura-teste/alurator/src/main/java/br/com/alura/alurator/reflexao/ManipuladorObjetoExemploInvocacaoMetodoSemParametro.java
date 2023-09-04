package br.com.alura.alurator.reflexao;

import java.lang.reflect.Method;

public class ManipuladorObjetoExemploInvocacaoMetodoSemParametro {
    private Object instancia;

    public ManipuladorObjetoExemploInvocacaoMetodoSemParametro (Object instancia) {
        this.instancia = instancia;
    }

    public ManipuladorMetodoExemploInvocacaoMetodoSemParametro getMetodo(String nomeMetodo) {
        Method metodo = null;
        try {
            metodo = instancia.getClass().getDeclaredMethod(nomeMetodo);
            return new ManipuladorMetodoExemploInvocacaoMetodoSemParametro(instancia, metodo);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
