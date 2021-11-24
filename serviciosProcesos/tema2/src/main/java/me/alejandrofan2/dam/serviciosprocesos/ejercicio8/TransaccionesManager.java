package me.alejandrofan2.dam.serviciosprocesos.ejercicio8;

import static java.lang.String.format;

import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class TransaccionesManager {

    private String title = "[Transaction Manager]";
    private Integer saldo;

    private Semaphore control = new Semaphore(0);
    private Logger log = LoggerFactory.getLogger(title);

    public TransaccionesManager(String title, int saldo) {
        this.title = title;
        this.saldo = saldo;
    }

    public void retirar(String threadTitle) {
        log.info(format("%s Iniciando proceso de retirada", threadTitle));
    }

    public void ingresar(String threadTitle) {
        log.info(format("%s Iniciando proceso de ingreso", threadTitle));
    }
}