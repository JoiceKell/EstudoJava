package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.CPF;

//Classe responsável por construir objetos do tipo Aluno
public class FabricaDeAluno {
    private Aluno aluno;

    //Retorna a própria classe para fazer o encadeamento de métodos
    public FabricaDeAluno comNomeCPFEmail(String nome, String cpf, String email) {
        this.aluno = new Aluno(new CPF(cpf), nome, new Email(email));
        return this;
    }

    public FabricaDeAluno comTelefone(String ddd, String numero) {
        this.aluno.adicionarTelefone(ddd, numero);
        return this;
    }

    public Aluno criar() {
        return this.aluno;
    }

    //Encadeamento de Métodos por isso Retorna o nome da classe com o return do this
    public static void main(String[] args) {
        FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
        Aluno aluno = fabricaDeAluno.comNomeCPFEmail("", "", "")
                .comTelefone("", "")
                .comTelefone("", "")
                .criar();
    }
}
