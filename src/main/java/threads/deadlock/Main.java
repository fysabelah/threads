package threads.deadlock;

public class Main {

    /**
     * Mostra que caso erro a sincronização pode causar deadlock
     * @param args
     */
    
    public static void main(String[] args) {
        ManagerTransaction tx = new ManagerTransaction();
        ConnectionPool pool = new ConnectionPool();

        new Thread(new TaskAccessesBank(pool, tx)).start();
        new Thread(new TaskAccessBankProcedure(pool, tx)).start();
    }
}
