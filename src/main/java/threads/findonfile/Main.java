package threads.findonfile;

public class Main {

    /**
     * Buscar String em arquivo de forma concorrente
     * @param args
     */
    
    public static void main(String[] args) {

        String path = "src/main/java/threads/findonfile/files/";

        String nameToFind = "Jon";

        Thread authorTask = new Thread(new TaskFindName(path + "autores.txt", nameToFind));
        Thread taskFetchSignature = new Thread(new TaskFindName(path + "assinaturas1.txt", nameToFind));
        Thread taskFetchSignature2 = new Thread(new TaskFindName(path + "assinaturas2.txt", nameToFind));

        authorTask.start();
        taskFetchSignature.start();
        taskFetchSignature2.start();

    }
}
