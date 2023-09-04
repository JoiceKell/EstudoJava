package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.shared.eventos.PublicadorDeEventos;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.AlunoMatriculado;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;

//SERVIÇO DE MATRICULA DE ALUNOS
//Toda vez que um aluno é matriculado um evento é disparado
public class MatricularAluno {
    //Para matricular um aluno precisa-se de um Repositório
    private final RepositorioDeAlunos repositorio; //Receber direto no Construtor
    private final PublicadorDeEventos publicador;

    public MatricularAluno(RepositorioDeAlunos repositorio, PublicadorDeEventos publicador) {
        this.repositorio = repositorio;
        this.publicador = publicador;
    }

    //Aqui precisaria receber um Aluno para fazer a matricula e simular o fluxo de execução
    //Só que quem vai utilizar essa classe será os mecanismos de apresentação, Linha de Comando, WEB, API Rest, só que deles não será enviado um objeto Aluno, mas sim dados primitivos
    //Para não ficar dezenas de dados soltos, ficando ilegível, dessa fomra, representa-se os dados com uma outra classe que só tem esses campos, sem nenhuma lógica, regra de negócio ou validação, segue um padrão chamado DTO
    public void executa(MatricularAlunoDto dados){
        Aluno novo = dados.criarAluno();
        repositorio.matricular(novo);

        AlunoMatriculado evento = new AlunoMatriculado(novo.getCpf());
        publicador.publicar(evento);
    }
}
