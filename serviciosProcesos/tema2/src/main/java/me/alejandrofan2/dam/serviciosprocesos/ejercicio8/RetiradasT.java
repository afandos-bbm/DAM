package me.alejandrofan2.dam.serviciosprocesos.ejercicio8;

import static java.lang.String.format;

import java.util.Random;

public class RetiradasT extends Thread {

    private String title;
    private TransaccionesManager manager;

    public RetiradasT(String name, TransaccionesManager manager) {
        super(name);
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            try {
                manager.retirar(super.getName());
            } catch (InterruptedException e) {
                manager.log.error(format("%s Error en el proceso de retirada%nOmitiendo... %n%s", title,
                        e.getStackTrace().toString()));
            }
        }
    }
}