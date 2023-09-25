package threads.ufpe.addarray;

public class Main {

    /**
     * Exercício 1 da lista de threads
     * @param args
     * @throws InterruptedException
     */

    public static void main(String[] args) throws InterruptedException {
        Integer[][] array = {
                {1, 2, 5, 8},
                {6, 9, 8, 6},
                {1, 2, 6, 9},
                {1, 2, 5, 8},
                {6, 9, 8, 6},
                {1, 2, 6, 9}};

        TaskAddArray taskAddArray = new TaskAddArray(array);
        Thread thread = new Thread(taskAddArray);
        thread.start();
        
        // Esse join é para esperar essa thread morrer e depois apresentar o resultado.
        thread.join();
        System.out.println("Total sum the elements of the matrix is: " + taskAddArray.total);
    }
}
