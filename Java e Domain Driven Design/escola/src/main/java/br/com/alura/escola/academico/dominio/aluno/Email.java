package br.com.alura.escola.academico.dominio.aluno;

public class Email {

    //VALUE OBJECT, não existe diferenciação se os objetos estiverem o mesmo atributo com o mesmo valor é o mesmo objeto, a mesma intãncia
    //Entidades possuem uma identidade única, enquanto VOs são considerados iguais, se todos os seus atributos tiverem valores iguais
    //Se dois e-mails possuem o mesmo endereço, podemos considerá-los como o mesmo e-mail. Já duas pessoas com o nome, altura e idade não necessariamente são a mesma pessoa.
    private String endereco;

    public Email(String endereco) { //Não podemos aceitar um e-mail inválido, na horá que instânciar um objeto e-mail obriga-se que seja passado uma String com o e-mail e aqui verificamos se é válido
        if (endereco == null || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
            throw new IllegalArgumentException("E-mail inválido");

        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
}
