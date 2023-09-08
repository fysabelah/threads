package threads.findonfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskFindName implements Runnable {

    private String filename;
    private String name;

    public TaskFindName(String filename, String name) {
        this.filename = filename;
        this.name = name;
    }

    @Override
    public void run() {

        try {
            Scanner scanner = new Scanner(new File(filename));

            int lineNumber = 1;

            while (scanner.hasNextLine()) {

                String linha = scanner.nextLine();

                if (linha.contains(name)) {
                    System.out.println(filename + " - " + lineNumber + " - " + linha);
                }

                lineNumber++;
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
