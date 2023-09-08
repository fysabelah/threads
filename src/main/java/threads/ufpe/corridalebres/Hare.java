package threads.ufpe.corridalebres;

import java.util.Random;

public class Hare {

    private Integer numberJumps;

    private Integer jump;

    private Integer distance;

    private String name;

    private static final Integer maxInterval = 3;

    private static final Integer minInterval = 1;

    public Hare(String name) {
        this.numberJumps = 0;
        this.jump = 0;
        this.distance = 0;
        this.name = name;
    }

    private Integer getRandomDistane() {
        return new Random().nextInt(maxInterval - minInterval + 1) + minInterval;
    }

    @Override
    public String toString() {
        return name + " with " + numberJumps + " jumps. Total distance - " + distance + " meters!";
    }

    public void jump() {
        this.jump = getRandomDistane();
        this.distance += this.jump;
        this.numberJumps += 1;
        System.out.println(this.name + " jumped " + this.jump + " meters. Total " + this.distance);
    }

    public Integer runnedDistance() {
        return this.distance;
    }
}
