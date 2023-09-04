package br.com.alura.estoque;

import java.util.List;
import java.util.Scanner;

import br.com.alura.alurator.Alurator;
import br.com.alura.estoque.dao.ProdutoDao;
import br.com.alura.estoque.dao.ProdutoDaoMock;

public class Main {

	/**
	 * Simula o navegador.
	 * 
	 */
	public static void main(String[] args) throws Exception {
		
		/*
		 * Casos possiveis:
		 * /controlador/metodo
		 * /controlador/metodo?param1=valor1&param2=valor2
		 * 
		 * /produto/filtra?nome=produto
		 * 
		 * /produto/filtra?nome=produto&marca=marca 1
		 * /produto/filtra?marca=marca 1&nome=produto
		 */
		
		try (Scanner s = new Scanner(System.in)) {
			String url = s.nextLine();
			
			Alurator alurator = new Alurator("br.com.alura.estoque.controle.");
			alurator.registra(ProdutoDao.class, ProdutoDaoMock.class); //Sempre que encontrar ProdutoDao sempre cria uma instância ProdutoDaoMock

			//Generics em tempo de desenvolvimento um feedback da IDE
			//Fazendo isso não temos nenhuma informação em tempo de compilação que isso vai dar ruim
//			alurator.registra(List.class, String.class); //Adicionando Generics o compilador já reclama, pois não são tipos compatíveis

			while (!url.equals("exit")) {
				Object response = alurator.executa(url);
				
				System.out.println("Response: " + response);
				
				url = s.nextLine();
			}
		}
	}

}
