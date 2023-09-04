package br.com.alura.alurator.playground.reflexao.testandoobjetoclasse.teste;

import br.com.alura.alurator.playground.controle.Controle;

public class TesteInstanciaObjeto {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// url -> /controle/lista

		//FORMAS DE CRIAR UM OBJETO DO TIPO CLASS
		//FORMA 1
		Class<Controle> controleClasse1 = Controle.class; //Retorna uma class parametrizada para classe Controle, conseguindo inferir todas as informações relativas a classe Controle, atributos, métodos, construtores

		//FORMA 2 - OBJETO JÁ CRIADO DA CLASSE EM QUESTÃO
		Controle controle = new Controle();
		Class<? extends Controle> controleClasse2 = controle.getClass(); //? extends Controle Esse objeto controleClasse2 do tipo Class estará parametrizado para qualquer classe que extenda Controle

		//FORMA 3
		Class<?> controleClasse3 =
				Class.forName("br.com.alura.alurator.playground.controle.Controle"); //Class<?> representa que a classe pode inferir qualquer classe

//----------------------------------------------------------------------------------------------------------------------

		//CRIAR UM OBJETO DA CLASSE REPRESENTADA DO OBJETO CLASS<T>
		Controle objetoControle = controleClasse1.newInstance(); // newInstance() foi depreciado
		System.out.println(objetoControle instanceof Controle);

		Object outroObjetoControle = controleClasse3.newInstance(); //Retorna um object porque pode ser de qualquer tipo
		System.out.println(outroObjetoControle instanceof Controle);
	}
}
