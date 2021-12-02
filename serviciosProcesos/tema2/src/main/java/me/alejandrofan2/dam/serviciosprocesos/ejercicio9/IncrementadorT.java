package me.alejandrofan2.dam.serviciosprocesos.ejercicio9;

public class IncrementadorT extends Thread {
    private ContadorManager manager;

    public IncrementadorT(String name, ContadorManager manager) {
        super(name);
        this.manager = manager;
    }

    @Override
    public void run() {
        manager.acumula(super.getName());
    }
}
