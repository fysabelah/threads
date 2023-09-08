package threads.ufpe.corridalebres;

public class Race implements Runnable {

    private Run run;

    private volatile boolean hasFinished;

    public Race(Run run) {
        this.run = run;
        this.hasFinished = false;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                do {
                    synchronized (this) {
                        if (hasFinished) {
                            this.notify();
                            break;
                        }

                        run.run(finalI, hasFinished);

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } while (!hasFinished);
            }, "Thread - " + finalI);

            thread.start();
        }
    }

    public Hare[] getRunners() {
        return this.run.getRunners();
    }
}
