package threads.ufpe.somarmatriz;

/**
 * Escreva um programa que realize o cálculo das somas dos valores das linhas de uma matriz qualquer
 * de números inteiros e imprima o resultado na tela. Faça com que o cálculo do somatório de cada linha
 * seja realizado em paralelo por uma thread.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Integer[][] matriz = {
                {1, 2, 5, 8},
                {6, 9, 8, 6},
                {1, 2, 6, 9},
                {1, 2, 5, 8},
                {6, 9, 8, 6},
                {1, 2, 6, 9}};

        TarefaSomarMatriz tarefaSomarMatriz = new TarefaSomarMatriz(matriz);
        Thread thread = new Thread(tarefaSomarMatriz);
        thread.start();
        
        // Esse join é para esperar essa thread morrer e depois apresentar o resultado.
        thread.join();
        System.out.println("Soma total dos elementos da matriz é: " + tarefaSomarMatriz.total);
    }
}
