package me.alejandrofan2.dam.serviciosprocesos.ejercicio5;

public class Productor implements Runnable {
    private Monitor safata;
    private int numero = 0;

    public Productor(Monitor s) {
        safata = s;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            numero = (int) (10 * Math.random());
            safata.dejar(numero);
            System.out.println("Productor -> Produït el número " + numero);
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                System.err.println("Error produciendo.");

            }
        }
    }
}