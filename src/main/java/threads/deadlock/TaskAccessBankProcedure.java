package threads.deadlock;

public class TaskAccessBankProcedure implements Runnable {

    private ConnectionPool pool;
    private ManagerTransaction tx;

    public TaskAccessBankProcedure(ConnectionPool pool,
                                   ManagerTransaction tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {

        // Esse e a TaskAccessesBank devem ter a mesma ordem dos objetos sincronizados no syncronized. 
        // Caso a ordem seja diferente vai causar deadlock
        // Exemplo: neste sincronizar o tx e depois o pool
        synchronized (pool) {
            System.out.println("Got the POOL key");
            pool.getConnection();

            synchronized (tx) {
                System.out.println("Got the TX key");
                tx.begin();
            }
        }
    }

}