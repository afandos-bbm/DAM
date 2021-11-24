package me.alejandrofan2.dam.serviciosprocesos.ejercicio8;

import static java.lang.String.format;

import java.util.Random;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransaccionesManager {

    private String title = "[Transaction Manager]";
    private Integer saldo = 0;
    private static final String DIVIDER = "------------------------------------------------------------------";

    protected Random randomFactory = new Random();
    protected Semaphore control = new Semaphore(1);
    protected Logger log = LoggerFactory.getLogger(title);

    public TransaccionesManager(String title, int saldo) {
        this.title = title;
        this.saldo = saldo;
    }

    public void retirar(String threadTitle) throws InterruptedException {
        log.info("Iniciando proceso de retirada");
        control.acquire();

        int dRetirada = randomFactory.nextInt(150) + 1;
        if ((saldo - dRetirada) >= 0) {
            saldo -= dRetirada;

            log.info(DIVIDER);
            log.warn(format("%s > Tramite de retirada realizado correctamente.", threadTitle));
            log.info(format("Cantidad retirada: %d | Saldo disponible: %d", dRetirada, saldo));
            log.info(DIVIDER);

        } else {
            log.info(DIVIDER);
            log.warn(format("%s > Cantidad de credito insuficiente! Omitiendo...", threadTitle));
            log.info(DIVIDER);
        }
        control.release();

        Thread.sleep(1000);
    }

    public void ingresar(String threadTitle) throws InterruptedException {
        log.info("Iniciando proceso de ingreso");
        control.acquire();

        int dIngreso = randomFactory.nextInt(150) + 1;
        saldo += dIngreso;

        log.info(DIVIDER);
        log.warn(format("%s > Tramite de ingreso realizado correctamente.", threadTitle));
        log.info(format("Cantidad ingresada: %d | Saldo disponible: %d", dIngreso, saldo));
        log.info(DIVIDER);

        control.release();

        Thread.sleep(1000);
    }
}