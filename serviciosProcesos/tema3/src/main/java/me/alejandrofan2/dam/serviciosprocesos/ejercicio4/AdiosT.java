package me.alejandrofan2.dam.serviciosprocesos.ejercicio4;

public class AdiosT extends Thread {

    Manager man;

    public AdiosT(Manager man) {
        this.man = man;
    }

    @Override
    public void run() {
        man.escribeAdios();
    }

}