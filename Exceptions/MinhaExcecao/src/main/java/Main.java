public class Main {
    public static void main(String[] args) throws MinhaExcecao2 {
        metodo1("ErroRunTimeException - Unchecked");
        metodo2("Exception - Checked");
    }

    public static void metodo1(String erro) {
        throw new MinhaExcecao(erro);
    }

    public static void metodo2(String erro) throws MinhaExcecao2 {
        throw new MinhaExcecao2(erro);
    }
}
