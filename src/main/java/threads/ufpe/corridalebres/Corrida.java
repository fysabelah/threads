package threads.ufpe.corridalebres;

import java.util.List;

public class Corrida implements Runnable {

    public List<Lebre> corredores;

    private static final Integer MAX = 20;

    public volatile boolean terminou;

    public Corrida(List<Lebre> corredores) {
        this.corredores = corredores;
        this.terminou = false;
    }

    @Override
    public void run() {
        corredores.forEach(corredor -> {
            Thread thread = new Thread(() -> {
                do {
                    synchronized (this) {
                        if (!terminou) {
                            corredor.saltar();

                            if (corredor.distancia >= 20) {
                                terminou = true;
                                this.notifyAll();
                                break;
                            }

                            System.out.println(corredor.nome + " parei para descansar do pulo!");

                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                } while (corredor.distancia < MAX && !terminou);
            }, corredor.nome);

            thread.start();
        });
    }
}
