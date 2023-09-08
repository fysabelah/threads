package threads.addandshowlist;

public class CustomList {

    private String[] items = new String[1000];
    private int index = 0;

    public synchronized void addItems(String item) {
        this.items[index] = item;
        this.index++;

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (this.index == this.size()) {
            System.out.println("list is full - notifying");
            this.notify();
        }
    }

    public int size() {
        return this.items.length;
    }

    public String getItem(int position) {
        return this.items[position];
    }
}
