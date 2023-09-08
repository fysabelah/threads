package threads.addandshowlist;

public class TaskAddItem implements Runnable {

    private CustomList customList;
    private int threadNumber;

    public TaskAddItem(CustomList customList, int numero) {
        this.customList = customList;
        this.threadNumber =  numero;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            customList.addItems("Thread " + threadNumber + " - " + i );
        }
    }
}
