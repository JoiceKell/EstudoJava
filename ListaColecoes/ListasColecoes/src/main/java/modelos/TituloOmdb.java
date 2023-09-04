package modelos;

// Tradução de campos, estrutura record, declaração de cabeçalho imutável
//Os parâmetros devem ser igual aos dados recebidos, mas por padrão variáveis devem ser escrita minusculas para isso é feito o GSONBuilder adicionando um padrão de nome
public record TituloOmdb(String title, String year, String runtime) {
}
