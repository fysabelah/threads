package threads.somarwaitnotify;

import java.util.List;

public class TaskSumVector implements Runnable {

    private SumOperations operations;

    public TaskSumVector(List<Integer> valores) {
        operations = new SumOperations(valores);
    }

    @Override
    public void run() {

        Thread t1 = new Thread(() -> {
            synchronized (operations.valores) {
                try {
                    System.out.println("Starting partial sum");
                    operations.somarVetor();
                    System.out.println("I'm done and I'm going to get some sleep");
                    operations.valores.wait(3000);
                    System.out.println(operations.valores);
                    operations.valores.notify();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (operations.valores) {
                try {
                    System.out.println("Waiting for partial sum to finish");
                    operations.valores.wait();
                    System.out.println("It ended! I will generate the total");
                    System.out.println(operations.valores);
                    operations.total();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
