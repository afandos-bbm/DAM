package me.alejandrofan2.dam.serviciosprocesos;

public class ClienteT extends Thread {

    private TiendaManager manager;

    public ClienteT(String name, TiendaManager manager) {
        super(name);
        this.manager = manager;
    }

    @Override
    public void run() {
        manager.pedir(super.getName());
    }
}