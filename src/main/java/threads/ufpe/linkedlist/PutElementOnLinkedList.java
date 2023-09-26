package threads.ufpe.linkedlist;

public class PutElementOnLinkedList implements Runnable {

    private Integer value;

    private Integer position;

    private LinkedListCustom linkedListCustom;

    public PutElementOnLinkedList(Integer value, Integer position, LinkedListCustom linkedListCustom) {
        this.value = value;
        this.position = position;
        this.linkedListCustom = linkedListCustom;
    }

    @Override
    public void run() {
        linkedListCustom.add(new Node(value, position));
    }
}
