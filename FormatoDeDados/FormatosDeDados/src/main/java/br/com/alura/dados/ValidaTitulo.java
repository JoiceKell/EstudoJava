package br.com.alura.dados;

import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.TituloEleitoralValidator;

public class ValidaTitulo {
    public static void main(String[] args) {

        ValidaDocumentos validaDocumentos = new ValidaDocumentos();

        String titulo="678562250132";

        try {
            validaDocumentos.validarDocumentos(new TituloEleitoralValidator(), titulo);
            System.out.println("Título VÁLIDO");
        } catch (InvalidStateException ex) {
            System.out.println("Título INVÁLIDO: " + ex);
        }
    }
}
