package threadsavancadas;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorTarefas {

    private static final Integer PORT = 12345;
    
    public static void main(String[] args) throws Exception {

        System.out.println("---- Iniciando Servidor ----");
        
        ServerSocket servidor = new ServerSocket(PORT);

        // Vai criar apenas 5 threads e ainda reaproveitá-las
        ExecutorService poolDeThreads = Executors.newFixedThreadPool(5);

        /*
            Nesse caso o valor cresce dinamicamente
            A quantidade também diminui a partir do momento que fica osciosa por 60s
            ExecutorService poolDeThreads = Executors.newCachedThreadPool();
            poolDeThreads.execute(distribuirTarefas);
            
            Os tipos de pool's de thread são newFixedThreadPool, newCachedThreadPool e newSingleThreadExecutor
        */

        while (true) {
            Socket socket = servidor.accept();
            System.out.println("Aceitando novo cliente na porta " + socket.getPort());
            DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket);
            poolDeThreads.execute(distribuirTarefas); // distribuirTarefas é o nosso Runnable
        }
    }
}
