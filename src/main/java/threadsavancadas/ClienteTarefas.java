package threadsavancadas;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Conexão Estabelecida");

        Thread enviarMensagem = new Thread(() -> {
            try {
                enviarMensagemServidor(socket);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Thread receberMensagem = new Thread(() -> {
            try {
                receberMensagemServidor(socket);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        enviarMensagem.start();
        receberMensagem.start();

        receberMensagem.join();

        socket.close();
    }

    private static void receberMensagemServidor(Socket socket) throws IOException {
        Scanner resposta = new Scanner(socket.getInputStream());

        while (resposta.hasNextLine()) {
            String linha = resposta.nextLine();
            System.out.println("Ciclano:" + linha);
        }

        resposta.close();
    }

    private static void enviarMensagemServidor(Socket socket) throws IOException {
        PrintStream saida = new PrintStream(socket.getOutputStream());
        saida.println("Fulano entrou no chat");

        //aguardando enter
        Scanner teclado = new Scanner(System.in);

        while (teclado.hasNextLine()) {
            String mensagem = teclado.nextLine();

            if (mensagem.trim().equals("#sair")) {
                saida.println("Fulano saiu do chat");
                break;
            }

            saida.println("Fulano: " + mensagem);
        }

        saida.close();
        teclado.close();
    }
}