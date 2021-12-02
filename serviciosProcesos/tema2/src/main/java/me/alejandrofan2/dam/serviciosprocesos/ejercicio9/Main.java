package me.alejandrofan2.dam.serviciosprocesos.ejercicio9;

public class Main {
    public static void main(String[] args) {
        ContadorManager contador = new ContadorManager();

        for (int i = 0; i <= 10; i++) {
            new IncrementadorT("Hilo" + i, contador).start();
        }
    }
}