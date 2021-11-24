package me.alejandrofan2.dam.serviciosprocesos.ejercicio8;

public class IngresosT extends Thread {

    private String title;
    private TransaccionesManager manager;

    public IngresosT(String title, TransaccionesManager manager) {
        this.title = title;
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            manager.ingresar(title);
        }
    }
}