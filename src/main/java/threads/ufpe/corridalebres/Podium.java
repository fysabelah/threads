package threads.ufpe.corridalebres;

import java.util.Arrays;

public class Podium implements Runnable {

    private Race race;

    public Podium(Race race) {
        this.race = race;
    }

    @Override
    public void run() {
        synchronized (race) {
            System.out.println("wait for the race to finished");

            try {
                race.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Arrays.toString(race.getRunners()));
        }
    }
}
