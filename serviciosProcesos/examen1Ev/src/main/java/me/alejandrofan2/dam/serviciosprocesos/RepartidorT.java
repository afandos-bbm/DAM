package me.alejandrofan2.dam.serviciosprocesos;

public class RepartidorT extends Thread {

    private TiendaManager manager;

    public RepartidorT(String name, TiendaManager manager) {
        super(name);
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            manager.repartir(super.getName());
        }
    }
}