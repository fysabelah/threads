package threads.writenumbers;

public class Main {

    /**
     * Ilustrar o funcionamento de threads escrevendo números de 0 a 999
     * @param args
     */
    
    public static void main(String[] args) {
        new Thread(new TaskWriteNumbers()).start();
        new Thread(new TaskWriteNumbers()).start();
    }
}
