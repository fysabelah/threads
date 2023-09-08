package threads.deadlock;

public class TaskAccessesBank implements Runnable {

    private ConnectionPool pool;
    private ManagerTransaction tx;

    public TaskAccessesBank(ConnectionPool pool, ManagerTransaction tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {

        synchronized (pool) {

            System.out.println("Got the pool key");
            pool.getConnection();

            synchronized (tx) {

                System.out.println("Got the TX key");
                tx.begin();

            }
        }
    }

}
