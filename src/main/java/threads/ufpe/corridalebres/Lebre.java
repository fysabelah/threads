package threads.ufpe.corridalebres;

import java.util.Random;

public class Lebre {

    private Integer salto;

    public Integer distancia;

    public String nome;

    public Integer quantidadeSaltos;

    private final static Integer max = 3;

    private final static Integer min = 1;


    public Lebre(String nome) {
        this.distancia = 0;
        this.salto = 0;
        this.nome = nome;
        this.quantidadeSaltos = 0;
    }

    private Integer getRandomDistane() {
        return new Random().nextInt(max - min + 1) + min;
    }

    public void saltar() {
        this.salto = getRandomDistane();
        this.distancia += this.salto;
        this.quantidadeSaltos += 1;
        System.out.println(nome + " pulei " + this.salto + " metros. Total " + this.distancia);
    }

    @Override
    public String toString() {
        return nome + " com " + quantidadeSaltos + " saltos. Distância total - " + distancia + " metros!";
    }
}
