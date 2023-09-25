package threads.ufpe.addarray;

import java.util.Arrays;

public class TaskAddArray implements Runnable {

    public Integer total;

    private Object[][] array;

    public TaskAddArray(Integer[][] array) {
        this.total = 0;
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            Object[] line = Arrays.stream(array[i]).toArray();

            Thread tread = new Thread(() -> {
                Integer aux = 0;

                for (Object item : line) {
                    aux += (Integer) item;
                }

                synchronized (total) {
                    total += aux;
                    System.out.println("In the Thread: " + Thread.currentThread().getName() + " - Total: " + total);
                }
            });

            tread.setDaemon(true);
            tread.start();

            try {
                tread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Com os joins no deamons a principal morre depois que seus filhos morrem
    }
}
