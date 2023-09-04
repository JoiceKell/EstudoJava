package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.eventos.Evento;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.eventos.TipoDeEvento;

import java.time.LocalDateTime;
import java.util.Map;

//Evento do aluno quando é matriculado
public class AlunoMatriculado implements Evento {

    private final CPF cpfDoAluno;
    private final LocalDateTime momento;

    //Não passar o objeto Aluno para não passar informações desnecessárias.
    public AlunoMatriculado(CPF cpfDoAluno) {
        this.cpfDoAluno = cpfDoAluno;
        this.momento = LocalDateTime.now();
    }

    @Override
    public LocalDateTime momento() {
        return this.momento;
    }

    @Override
    public TipoDeEvento tipo() {
        return TipoDeEvento.ALUNO_MATRICULADO;
    }

    @Override
    public Map<String, Object> informacoes() {
        return Map.of("cpf", cpfDoAluno);
    }

    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }
}
