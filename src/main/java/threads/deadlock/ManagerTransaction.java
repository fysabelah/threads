package threads.deadlock;

public class ManagerTransaction {

    public void begin() {

        System.out.println("Starting the transaction");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
