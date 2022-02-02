package me.alejandrofan2.dam.serviciosprocesos.ejercicio4;

public class HolaT extends Thread {

    Manager man;

    public HolaT(Manager man) {
        this.man = man;
    }

    @Override
    public void run() {
        man.escribeHola();
    }

}