package me.alejandrofan2.dam.serviciosprocesos.ejercicio3;

public class AvionMan {

    public static void main(String[] args) {
        AvionMan man = new AvionMan();

        for (int i = 0; i < 4; i++) {
            new Cliente("Cliente1", man).start();
        }
    }

    int asientos = 5;
    boolean check;

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public synchronized void reservarAsientos(int reservar) {
        if (check) {
            asientos = asientos - reservar;
            System.out.println("Se han reservado " + reservar + " asientos.");
            System.out.println("Quedan " + asientos + " asientos libres.");
        } else {
            System.out.println("Avion lleno, omitiendo...");
        }
    }

    public synchronized boolean asientosLibres(int reservar) {
        if ((asientos -= reservar) > 0) {
            System.out.println("Quedan " + asientos + " asientos libres.");
            check = true;
        } else {
            asientos += reservar;
            System.out.println("Solo hay " + asientos + " libres.");
            check = false;
        }

        return check;
    }

}
