package threads.running;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Thread> threads = Thread.getAllStackTraces().keySet();

        // Running Threads
        for (Thread thread : threads) {
            System.out.println(thread.getName());
        }

        Runtime runtime = Runtime.getRuntime();
        int qtyCores = runtime.availableProcessors();
        System.out.println("Quantity of Cores " + qtyCores);
    }
}
