package threads.somarwaitnotify;

import java.util.Arrays;
import java.util.List;

public class Main {

    /**
     * Ilustra a soma de um vetor divindo-o pela metade e colocando na 1º e tamanho/2 posição. 
     * Após execução das duas thread, é somado é total do vetor
     * Uso de wait e notify
     * @param args
     */
    
    public static void main(String[] args) {
        List<Integer> vetor = Arrays.asList(1, 6, 5, 2, 9, 10, 11);

        TaskSumVector taskSum = new TaskSumVector(vetor);
        Thread thread = new Thread(taskSum);
        thread.start();
    }
}
