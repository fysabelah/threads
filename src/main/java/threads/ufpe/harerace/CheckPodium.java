package threads.ufpe.harerace;

import java.util.List;
import java.util.Objects;

public class CheckPodium implements Runnable {

    private Race race;

    public CheckPodium(Race race) {
        this.race = race;
    }

    @Override
    public void run() {
        synchronized (race) {
            while (!race.isFinished) {
                try {
                    race.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            orderAndShowPodium(race.runners);
        }
    }

    private void orderAndShowPodium(List<Hare> runners) {
        System.out.println("\n----- Checking Podium -----");

        runners.sort((runner1, runner2) -> {
            if (Objects.equals(runner1.getRunnedDistance(), runner2.getRunnedDistance())) {
                return runner1.getNumberJumps().compareTo(runner2.getNumberJumps());
            }

            if (runner1.getRunnedDistance() < runner2.getRunnedDistance())
                return 1;

            return -1;
        });

        for (int i = 0; i < runners.size(); i++) {
            System.out.println(i + 1 + ": " + runners.get(i));
        }
    }
}
