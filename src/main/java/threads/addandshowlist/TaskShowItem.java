package threads.addandshowlist;

public class TaskShowItem implements Runnable {

    private CustomList customList;

    public TaskShowItem(CustomList customList) {
        this.customList = customList;
    }

    @Override
    public void run() {
        synchronized (customList) {
            try { 
                System.out.println("wait for notification");
                customList.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < customList.size(); i++) {
                System.out.println(i + " - " + customList.getItem(i));
            }
        }
    }
}