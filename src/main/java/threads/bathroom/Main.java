package threads.bathroom;

public class Main {

    /***
     * Simula a entrada no banheiro. Exemplo de utilização da sincronização de acesso.
     *
     * @param args
     */
    public static void main(String[] args) {

        Bathroom bathroom = new Bathroom();

        //Passando a tarefa e o nome do Thread
        Thread convidado1 = new Thread(new TaskDoNumber1(bathroom), "João");
        Thread convidado3 = new Thread(new TaskDoNumber1(bathroom), "Zezim");
        Thread convidado2 = new Thread(new TaskDoNumber2(bathroom), "Pedro");

        convidado1.start();
        convidado2.start();
        convidado3.start();
    }
}
