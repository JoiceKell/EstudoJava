package br.com.alura.escola.gameficacao.dominio.selo;

import br.com.alura.escola.shared.dominio.CPF;

public class Selo {
    private CPF cpfDoAluno;
    private String nomeDoSelo;

    public Selo(CPF cpfDoAluno, String nomeDoSelo) {
        this.cpfDoAluno = cpfDoAluno;
        this.nomeDoSelo = nomeDoSelo;
    }

    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }

    public String getNomeDoSelo() {
        return nomeDoSelo;
    }
}
