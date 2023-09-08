package threads.somarwaitnotify;

import java.util.List;

public class SumOperations {

    public List<Integer> valores;

    public SumOperations(List<Integer> valores) {
        this.valores = valores;
    }

    public void somarVetor() throws InterruptedException {
        int metadeLista = valores.size() / 2;

        Thread t1 = new Thread(() -> somar(0, metadeLista, 0));

        Thread t2 = new Thread(() -> somar(metadeLista, valores.size(), metadeLista));

        t1.start();
        t2.start();
    }

    public void total() {
        Integer total = valores.get(0) + valores.get(valores.size() / 2);
        System.out.println(String.format("Total: %d", total));
    }

    private void somar(Integer indice, Integer size, Integer position) {
        for (int i = indice + 1; i < size; i++) {
            valores.set(position, valores.get(i) + valores.get(position));
        }
    }
}
