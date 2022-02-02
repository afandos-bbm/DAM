package me.alejandrofan2.dam.serviciosprocesos.ejercicio3;

public class Cliente extends Thread {

    AvionMan man;

    public Cliente(String nombre, AvionMan manager) {
        super(nombre);
        this.man = manager;
    }

    public void pagar() {
        System.out.println("Iniciando el pago...");
        try {
            sleep(3000);
            System.out.println("Pago completado.");
        } catch (InterruptedException e) {
            System.out.println("Error durante el pago, omitiendo...");
        }
    }

    @Override
    public void run() {
        if (man.asientosLibres(3)) {
            pagar();
            man.reservarAsientos(3);
        }
    }

}
