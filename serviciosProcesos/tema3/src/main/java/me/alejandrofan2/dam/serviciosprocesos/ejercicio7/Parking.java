package me.alejandrofan2.dam.serviciosprocesos.ejercicio7;

public class Parking {
    public static void main(String[] args) {
        Parking parking = new Parking(10);
        for (int i = 1; i <= 40; i++) {
            new Coche("Coche matrícula " + i, parking);
        }
    }

    private int places;

    public Parking(int places) {
        if (places < 0)
            places = 0;
        this.places = places;
    }

    public int getPlacesLliures() {
        return this.places;
    }

    public synchronized void aparcar(String nom) {
        while (places <= 0) {
            try {
                System.out.println(nom + ": Parking LLeno.");
                wait();
            } catch (InterruptedException e) {
                System.err.println("Error waiting... Codigo de Error: " + e.getLocalizedMessage());
            }
        }
        places--;
    }

    public synchronized void eixir(String nom) {
        places++;
        notify();
    }
}