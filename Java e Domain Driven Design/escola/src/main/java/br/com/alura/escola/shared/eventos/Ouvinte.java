package br.com.alura.escola.shared.eventos;
//Dispara o processamento do evento
public abstract class Ouvinte {
    //Classe Geérica, mas nem todo ouvinte está interessado em todos os eventos
    public void processa(Evento evento) {
        if (this.deveProcessar(evento)) {
            this.reageAo(evento);
        }
    }

    protected abstract void reageAo(Evento evento);

    protected abstract boolean deveProcessar(Evento evento); //Quem vai dizer se esse evento será processado ou não é cada classe específica
}
