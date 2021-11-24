package me.alejandrofan2.dam.serviciosprocesos.ejercicio8;

import static java.lang.String.format;

import java.util.Random;

public class IngresosT extends Thread {

    private String title;
    private TransaccionesManager manager;

    public IngresosT(String name, TransaccionesManager manager) {
        super(name);
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            try {
                manager.ingresar(super.getName());
            } catch (InterruptedException e) {
                manager.log.error(format("%s Error en el proceso de ingreso%nOmitiendo...", title));
            }
        }
    }
}