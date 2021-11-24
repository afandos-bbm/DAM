package me.alejandrofan2.dam.accesodatos.ejercicios;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ejercicio2 {

    static Logger log = LoggerFactory.getLogger(ejercicio2.class);
    static Boolean running = true;

    public static void main(String[] args) {
        File root = File.listRoots()[0];
        File path = root;

        while (running) {
            // Menu
            log.info(path.toPath().toString());
            
        }
    }
}
