package threads.basic;

public class Main {

    /***
     * Exemplo de como criar uma thread, sendo de forma direta ou implementanto a interface
     * @param args
     */
    public static void main(String[] args) {
        TaskTExecuteThread taskTExecuteThread = new TaskTExecuteThread();

        Thread thread = new Thread(() -> System.out.println("I'm running here"), "Direct");
        Thread thread2 = new Thread(taskTExecuteThread, "I'm using a class");

        thread.start();
        thread2.start();

        System.out.println("Interesting");
    }
}
