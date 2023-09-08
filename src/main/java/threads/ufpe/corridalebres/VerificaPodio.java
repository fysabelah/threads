package threads.ufpe.corridalebres;

import java.util.List;
import java.util.Objects;

public class VerificaPodio implements Runnable {

    private Corrida corrida;

    public VerificaPodio(Corrida corrida) {
        this.corrida = corrida;
    }

    @Override
    public void run() {
        synchronized (corrida) {
            while (!corrida.terminou) {
                try {
                    corrida.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            ordernaAndPrintPodio(corrida.corredores);
        }
    }

    private void ordernaAndPrintPodio(List<Lebre> corredores) {
        System.out.println("\n----- Verificando Pódio -----");

        corredores.sort((o1, o2) -> {
            if (Objects.equals(o1.distancia, o2.distancia)) {
                return o1.quantidadeSaltos.compareTo(o2.quantidadeSaltos);
            }

            if (o1.distancia < o2.distancia)
                return 1;

            return -1;
        });
        
        for (int i = 0; i < corredores.size(); i++) {
            System.out.println(i + 1 + "º lugar: " + corredores.get(i));
        }
    }
}
