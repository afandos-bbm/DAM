package me.alejandrofan2.dam.serviciosprocesos.ejercicio1;

/**
 * Hello world!
 *
 */
public class Ejercicio1_1 extends Thread {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Ejercicio1_1().run();
        }
    }

    @Override
    public void run() {
        System.out.println(Math.random() * 1000);
    }
}
