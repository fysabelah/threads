package threads.ufpe.linkedlist;

public class Node {

    private Integer value;

    private Integer position;

    private Node nextNode;

    public Node(Integer value, Integer position) {
        this.value = value;
        this.position = position;
        this.nextNode = null;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Integer getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return "Position: " + position + " - Value: " + value;
    }
}
