package threads.ufpe.somarmatriz;

import java.util.Arrays;

public class TarefaSomarMatriz implements Runnable {

    public Integer total;

    private Object[][] matriz;

    public TarefaSomarMatriz(Integer[][] matriz) {
        this.total = 0;
        this.matriz = matriz;
    }

    @Override
    public void run() {
        for (int i = 0; i < matriz.length; i++) {
            Object[] linha = Arrays.stream(matriz[i]).toArray();

            Thread tread = new Thread(() -> {
                Integer aux = 0;

                for (Object item : linha) {
                    aux += (Integer) item;
                }

                synchronized (total) {
                    total += aux;
                    System.out.println("Na Thread: " + Thread.currentThread().getName() + " - Total: " + total);
                }
            });

            tread.setDaemon(true);
            tread.start();
            
            try {
                tread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Com os joins no deamons a principal morre depois que seus filhos morrem
    }
}
