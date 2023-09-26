package threads.ufpe.linkedlist;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        LinkedListCustom linkedListCustom = new LinkedListCustom();

        List<Integer> values = Arrays.asList(1, 2, 3, 8, 9, 15, 69, 0);

        for (int i = 0; i < values.size(); i++) {
            Thread thread = new Thread(new PutElementOnLinkedList(values.get(i), i, linkedListCustom), "Name " + i);
            thread.start();
        }
    }
}
