package br.com.alura.escola.gameficacao.aplicacao;

import br.com.alura.escola.gameficacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gameficacao.dominio.selo.Selo;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.eventos.Evento;
import br.com.alura.escola.shared.eventos.Ouvinte;
import br.com.alura.escola.shared.eventos.TipoDeEvento;

public class GeraSeloAlunoNovato extends Ouvinte {
    private final RepositorioDeSelos repositorioDeSelos;

    //Pode vir qualquer implementação em memória, JDBC, JPA, Hibernate...
    public GeraSeloAlunoNovato(RepositorioDeSelos repositorioDeSelos) {
        this.repositorioDeSelos = repositorioDeSelos;
    }

    @Override
    protected void reageAo(Evento evento) {
        CPF cpfDoAluno = (CPF) evento.informacoes().get("cpf");
        Selo novato = new Selo(cpfDoAluno, "Novato"); //Podendo ser um enum aqui
        repositorioDeSelos.adicionar(novato);
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        //return evento instanceof AlunoMatriculado;
        return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
    }
}
