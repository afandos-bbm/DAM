package me.alejandrofan2.dam.serviciosprocesos;

public class TrabajadorT extends Thread {

    private TiendaManager manager;

    public TrabajadorT(String name, TiendaManager manager) {
        super(name);
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            manager.trabajar(super.getName());
        }
    }
}