package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.CPF;

import java.util.List;

public interface RepositorioDeAlunos {
    void matricular(Aluno aluno);

    Aluno buscarPorCPF(CPF cpf);

    List<Aluno> listarTodosAlunosMatriculados();

    //Poderia ter um método para gravar um telefone. Talvez não seria interessante ter um repositório de Telefones, pois poderia permitir que alguém manipulasse um telefone diretamente
}
