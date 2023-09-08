package threads.sumvectorvalues;

import java.util.Arrays;
import java.util.List;

public class Main {

    /**
     * Ilustra a soma de um vetor divindo-o pela metade e colocando na 1º e tamanho/2 posição. 
     * Após execução das duas thread, é somado é total do vetor
     * Joint é utilizado para esperar que uma thread termine e o valor fique correto
     * @param args
     */
    
    public static void main(String[] args) {

        List<Integer> vector = Arrays.asList(1, 6, 5, 2, 9, 10, 11);

        TaskSum tarefa = new TaskSum(vector, 0);

        new Thread(tarefa).start();
    }
}
