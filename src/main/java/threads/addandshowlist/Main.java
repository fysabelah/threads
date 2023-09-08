package threads.addandshowlist;

public class Main {

    /**
     * Exemplo de como preencher uma lista e aguardar que esteja completa para imprimir
     * @param args
     */
    
    public static void main(String[] args) {

        CustomList customList = new CustomList();

        for (int i = 0; i < 10; i++) {
            new Thread(new TaskAddItem(customList, i)).start();
        }

        new Thread(new TaskShowItem(customList)).start();
    }
}
