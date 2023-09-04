public class Comando implements Comparable<Comando> {
    private String tipo;
    private int prioridade;
    private String params;

    public Comando(String tipo, int prioridade, String params) {
        this.tipo = tipo;
        this.prioridade = prioridade;
        this.params = params;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getParams() {
        return params;
    }

    // construtor e getters

    @Override
    public int compareTo(Comando outroComando) {
        return outroComando.prioridade - prioridade;
    }
}