package me.alejandrofan2.dam.serviciosprocesos.ejercicio5;

public class Consumidor implements Runnable {
    private Monitor safata;

    public Consumidor(Monitor s) {
        safata = s;
    }

    public void run() {
        int num;
        for (int i = 0; i < 50; i++) {
            num = safata.coger();
            System.out.println("Consumidor -> Número agafat: " + num);
            try {
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                System.err.println("Error consumiendo.");
            }
        }
    }
}