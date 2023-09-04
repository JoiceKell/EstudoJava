package br.com.alura.dados;

import br.com.caelum.stella.validation.Validator;

public class ValidaDocumentos {
    public void validarDocumentos(Validator<String> validador, String documento) {
        validador.assertValid(documento);
    }
}
