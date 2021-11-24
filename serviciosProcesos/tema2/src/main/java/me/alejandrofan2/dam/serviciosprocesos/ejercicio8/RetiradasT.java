package me.alejandrofan2.dam.serviciosprocesos.ejercicio8;

public class RetiradasT extends Thread {

    private String title;
    private TransaccionesManager manager;
    
    public RetiradasT(String title, TransaccionesManager manager) {
        this.title = title;
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            manager.retirar(title);
        }
    }
}