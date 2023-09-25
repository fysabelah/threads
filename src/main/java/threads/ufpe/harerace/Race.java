package threads.ufpe.harerace;

import java.util.List;

public class Race implements Runnable {

    public List<Hare> runners;

    private static final Integer MAX = 20;

    public volatile boolean isFinished;

    public Race(List<Hare> runners) {
        this.runners = runners;
        this.isFinished = false;
    }

    @Override
    public void run() {
        runners.forEach(runner -> {
            Thread thread = new Thread(() -> {
                do {
                    synchronized (this) {
                        if (!isFinished) {
                            runner.jump();

                            if (runner.getRunnedDistance() >= 20) {
                                isFinished = true;
                                this.notifyAll();
                                break;
                            }

                            System.out.println(runner.getName() + " stopped to rest!");

                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                } while (runner.getRunnedDistance() < MAX && !isFinished);
            }, runner.getName());

            thread.start();
        });
    }
}
