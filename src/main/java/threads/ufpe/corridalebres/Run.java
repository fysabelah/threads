package threads.ufpe.corridalebres;

public class Run {

    private Hare[] hares;

    public Run(Hare[] hares) {
        this.hares = hares;
    }

    public synchronized void run(Integer index, boolean hasFinished) {
        hares[index].jump();

        if (hares[index].runnedDistance() >= 20) {
            hasFinished = true;
            this.notify();
        }
    }

    public Hare[] getRunners() {
        return this.hares;
    }
}
