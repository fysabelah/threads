package threads.bathroom;

public class Bathroom {

    public synchronized void doNumber1() {
        // Assim sem o synchronized as threads estão compartilhando o mesmo recurso. Nisto a ordem fica errada
        // Com o synchronized, quando alguém começar, vai esperar até finalizar para começar outra thread.
        //Também poderia ser utilizado private Lock lock = new ReentrantLock(); não é a mesma coisa, mas nesse caso funcionaria
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " entering in the bathroom");
        System.out.println(nome + " doing something fast");

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(nome + " flushing");
        System.out.println(nome + " washing my hands");
        System.out.println(nome + " leaving the bathroom");
    }

    public void doNumber2() {
        synchronized (this) {
            String nome = Thread.currentThread().getName();

            System.out.println(nome + " entering the bathroom");
            System.out.println(nome + " doing long things");

            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(nome + " flushing");
            System.out.println(nome + " washing your hand");
            System.out.println(nome + " leaving the bathroom");
        }
    }
}