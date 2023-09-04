package br.com.alura.dados;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class ValidaCnpj {
    public static void main(String[] args) {

        ValidaDocumentos validaDocumentos = new ValidaDocumentos();

        String cnpj = "57382533000100";

        try {
            validaDocumentos.validarDocumentos(new CNPJValidator(), cnpj);
            System.out.println("CNPJ Válido");
        } catch (InvalidStateException ex) {
            System.out.println("CNPJ inVálido: " + ex);
        }
    }
}
