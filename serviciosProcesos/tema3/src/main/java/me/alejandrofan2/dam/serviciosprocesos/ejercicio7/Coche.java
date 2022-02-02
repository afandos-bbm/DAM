package me.alejandrofan2.dam.serviciosprocesos.ejercicio7;

public class Coche extends Thread {
    private Parking parking;

    public Coche(String matricula, Parking p) {
        super(matricula);
        this.parking = p;
        start();
    }

    public void run() {
        try {
            // Simular arribades en temps distints
            sleep((int) (Math.random() * 60000));
        } catch (InterruptedException e) {
        }
        parking.aparcar(getName());
        System.out.println(getName() + ": entra al pàrquing. "
                + "Places lliures: " + parking.getPlacesLliures());
        try {
            // Simular estada al pàrquing un temps aleatori
            sleep((int) (Math.random() * 30000));
        } catch (InterruptedException e) {
        }
        parking.eixir(getName());
        System.out.println(getName() + ": ix de pàrquing. "
                + "Places lliures: " + parking.getPlacesLliures());
    }

}