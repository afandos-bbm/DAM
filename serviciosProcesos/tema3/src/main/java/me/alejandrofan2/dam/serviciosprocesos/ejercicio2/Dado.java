package me.alejandrofan2.dam.serviciosprocesos.ejercicio2;

public class Dado extends Thread {

    Manager manager;

    public Dado(Manager manager) {
        super();

        this.manager = manager;
    }

    @Override
    public void run() {
        int random = (int) (Math.random() * 6 + 1);
        System.out.println(random);
        manager.setTotal(random);
    }

}