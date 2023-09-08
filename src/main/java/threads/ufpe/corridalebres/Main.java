package threads.ufpe.corridalebres;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<Lebre> corredores = new ArrayList<>();
        corredores.add(new Lebre("Lebre 1"));
        corredores.add(new Lebre("Lebre 2"));
        corredores.add(new Lebre("Lebre 3"));
        corredores.add(new Lebre("Lebre 4"));
        corredores.add(new Lebre("Lebre 5"));

        /*Corrida corrida = new Corrida(corredores);
        Thread tarefaCorrida = new Thread(corrida, "Corrida");
        Thread tarefaPodio = new Thread(new VerificaPodio(corrida), "Podio");
        
        tarefaCorrida.start();
        tarefaPodio.start();

        tarefaCorrida.join();*/
        
        
        
        Run run = new Run((Hare[]) corredores.toArray());
        
        Race race = new Race(run);
        
        new Thread(race);
        new Thread(new Podium(race));
    }
}
