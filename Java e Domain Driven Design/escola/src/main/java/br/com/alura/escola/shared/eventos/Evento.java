package br.com.alura.escola.shared.eventos;

import java.time.LocalDateTime;
import java.util.Map;

//Evento, muito comum quando se tem um processo, ex. site de compras
public interface Evento {
    LocalDateTime momento();
    TipoDeEvento tipo();
    Map<String, Object> informacoes();
}
