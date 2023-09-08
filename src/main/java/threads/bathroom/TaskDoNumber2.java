package threads.bathroom;

public class TaskDoNumber2 implements Runnable {

    private Bathroom bathroom;

    public TaskDoNumber2(Bathroom bathroom) {
        this.bathroom = bathroom;
    }

    @Override
    public void run() {
        this.bathroom.doNumber2();
    }
}
