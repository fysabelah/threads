package threads.sumvectorvalues;

import java.util.List;

public class TaskSum implements Runnable {

    public Integer total;

    public List<Integer> values;

    public TaskSum(List<Integer> values, Integer initialValue) {
        this.total = initialValue;
        this.values = values;
    }

    @Override
    public void run() {
        List<Integer> aux1 = values.subList(0, values.size() / 2);
        List<Integer> aux2 = values.subList(values.size() / 2, values.size());

        Thread t1 = new Thread(() -> sumVector(aux1));
        Thread t2 = new Thread(() -> sumVector(aux2));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        total = aux1.get(0) + aux2.get(0);

        System.out.println("Total na Thread = " + total);
    }

    private void sumVector(List<Integer> aux1) {
        for (int i = 1; i < aux1.size(); i++) {
            aux1.set(0, aux1.get(i) + aux1.get(0));
        }
    }
}
