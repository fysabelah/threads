package threads.bathroom;

public class TaskDoNumber1 implements Runnable {

    private Bathroom bathroom;

    public TaskDoNumber1(Bathroom bathroom) {
        this.bathroom = bathroom;
    }

    @Override
    public void run() {
        this.bathroom.doNumber1();
    }
}