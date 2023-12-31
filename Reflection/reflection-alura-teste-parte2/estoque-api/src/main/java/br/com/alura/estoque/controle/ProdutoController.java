package br.com.alura.estoque.controle;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.estoque.dao.ProdutoDao;
import br.com.alura.estoque.dao.ProdutoDaoMock;
import br.com.alura.estoque.modelo.Produto;

public class ProdutoController {
	
	private ProdutoDao produtoDao; //Isso é uma interface, mas interfaces não possui construtor, e no código, por enquanto, ele se baseia no construtor para criar o objeto

	//Quando construir uma instância de ProdutoController queremos receber como parâmetro um ProdutoDaoMock
	public ProdutoController(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}
	
	public List<Produto> lista() {
		return produtoDao.lista();
	}
	
	public List<Produto> filtra(String nome) {
		return produtoDao.lista().stream()
							.filter(produto -> produto.getNome().toLowerCase().startsWith(nome.toLowerCase()))
							.collect(Collectors.toList());
	}
	
	public List<Produto> filtra(String nome, String marca) {
		return produtoDao.lista().stream()
							.filter(produto -> 
								produto.getNome().toLowerCase().startsWith(nome.toLowerCase())
								&& produto.getMarca().equalsIgnoreCase(marca)
							)
							.collect(Collectors.toList());
	}
}
