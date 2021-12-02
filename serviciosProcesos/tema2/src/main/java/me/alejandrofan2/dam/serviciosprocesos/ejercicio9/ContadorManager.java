package me.alejandrofan2.dam.serviciosprocesos.ejercicio9;

import static java.lang.String.format;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContadorManager {

    private String title = "[Adder Manager]";
    private int acumulado = 0;

    protected final Logger log = LoggerFactory.getLogger(title);
    protected Random random = new Random();

    public synchronized void acumula(String tName) {
        try {
            int aleatorio = random.nextInt(5000) + 1;
            int valorPrevio = acumulado;
            if (aleatorio % 2 == 0)
                acumulado += aleatorio;
            else
                acumulado -= aleatorio;
            log.info(format(
                    "%s%nNºAleatorio: %d%nCantidad Acumulada: %d > %d%n"
                            + "--------------------------------------------",
                    tName, aleatorio, valorPrevio, acumulado));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error(format("%s Thread.sleep() ERROR ", title));
            Thread.currentThread().interrupt();
        }
    }
}
