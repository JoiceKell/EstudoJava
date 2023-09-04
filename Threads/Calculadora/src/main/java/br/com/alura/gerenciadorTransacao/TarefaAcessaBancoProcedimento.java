package br.com.alura.gerenciadorTransacao;

public class TarefaAcessaBancoProcedimento implements Runnable {
    private PoolDeConexao pool;
    private GerenciadorDeTransacao tx;

    public TarefaAcessaBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {
        //deadLock, Uma thread segura um recurso e aguarda por outro.
//        synchronized (tx) {
//            System.out.println("comecado a tx");
//            tx.begin();
//
//            synchronized (pool) {
//                System.out.println("peguei a conexao");
//                pool.getConnection();
//            }
//        }

        synchronized (pool) {
            System.out.println("peguei a conexao");
            pool.getConnection();

            synchronized (tx) {
                System.out.println("comecado a tx");
                tx.begin();
            }
        }
    }
}
