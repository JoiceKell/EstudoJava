package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.CPF;

import java.util.ArrayList;
import java.util.List;

//Classe Entidade, pois tem como diferenciar duas intãncias baseadas em um atributo
//AGGREATE ROOT, quando temos essa situação existe uma relação de dependência onde os Values Object depende dessa classe, então todo acesso, manipulação desse objeto é feito nessa classe
public class Aluno {
    //Não colocar um id para não atrelar um dominio com a infraestrutura
    private CPF cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones = new ArrayList<>();
    private String senha;

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(String ddd, String numero) {
        if(telefones.size() == 2)
            throw new IllegalArgumentException("Número máximo de telefones já atingido!");
        this.telefones.add(new Telefone(ddd, numero));
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public static void main(String[] args) {
        Aluno a = new Aluno(new CPF("123"), "Fulano da Silva", new Email("email"));
    }
}
