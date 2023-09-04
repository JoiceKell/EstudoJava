package br.com.alura.cep;

import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;
import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;

import java.io.IOException;

//https://mvnrepository.com/artifact/com.github.gilberto-torrezan/viacep
public class Cep {
    public static void main(String[] args) {
        ViaCEPClient cliente = new ViaCEPClient();
        try {
            ViaCEPEndereco endereco = cliente.getEndereco("82010340"); //Faz a chamada na API para obter o endereço
            System.out.println(endereco.getLogradouro());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
