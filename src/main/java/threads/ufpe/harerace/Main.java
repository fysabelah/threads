package threads.ufpe.harerace;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<Hare> runners = new ArrayList<>();
        runners.add(new Hare("Lebre 1"));
        runners.add(new Hare("Lebre 2"));
        runners.add(new Hare("Lebre 3"));
        runners.add(new Hare("Lebre 4"));
        runners.add(new Hare("Lebre 5"));

        Race race = new Race(runners);
        Thread taskRace = new Thread(race, "Race");
        Thread taskPodium = new Thread(new CheckPodium(race), "Podium");

        taskRace.start();
        taskPodium.start();

        taskRace.join();
    }
}
