package threads.ufpe.linkedlist;

public class LinkedListCustom {

    private Node node;
    private Integer size;

    /**
     * Quando se tem um método sincronizado, todo o objeto é sincronizando. Ou seja, apenas um método pode ser acessado por vez
     */
    public LinkedListCustom() {
        this.size = 0;
        this.node = null;
    }

    public synchronized void add(Node node) {
        if (size == 0) {
            this.node = node;
        } else {
            if (this.node.getPosition() > node.getPosition()) {
                node.setNextNode(this.node);
                this.node = node;
            } else {
                Node actual = this.node;

                while (actual.getNextNode() != null && actual.getPosition() < node.getPosition() && actual.getNextNode().getPosition() < node.getPosition()) {
                    actual = actual.getNextNode();
                }

                node.setNextNode(actual.getNextNode());
                actual.setNextNode(node);
            }
        }

        size++;

        showList();
    }

    private void showList() {
        Node copy = this.node;


        do {
            if (size == 0) {
                System.out.println("Empty list");
                break;
            }

            System.out.println(copy);

            copy = copy.getNextNode();
        } while (copy != null);

        System.out.println("------");
    }
}
