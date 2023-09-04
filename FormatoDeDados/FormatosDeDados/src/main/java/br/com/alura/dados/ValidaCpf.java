package br.com.alura.dados;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

//https://stella.caelum.com.br/
public class ValidaCpf {
    public static void main(String[] args) {

        ValidaDocumentos validaDocumentos = new ValidaDocumentos();

        String cpf="86288366757";

        try {
            validaDocumentos.validarDocumentos(new CPFValidator(), cpf);
            System.out.println("CPF VÁLIDO");
        } catch (InvalidStateException ex) {
            System.out.println("CPF INVÁLIDO: " + ex);
        }

    }
}
