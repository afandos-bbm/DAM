package me.alejandrofan2.dam.accesodatos.ejercicios;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ejercicio1 {

    static File folder;
    static File file;
    static Scanner in = new Scanner(System.in);
    private static final Logger log = LoggerFactory.getLogger("Ejercicio 1");

    public static void main(String[] args) {
        System.out.print("Set the workpace folder(Path): ");
        folder = new File(in.nextLine());
        if (!folder.exists()) {
            System.exit(1);
        }

        System.out.print("Name of the file: ");
        file = new File(folder + in.nextLine());
        if (file.exists()) {
            log.info("El tamaño del archivo es de: " + file.length() + " B");
        } else {
            try {
                file.createNewFile();
                log.info("Se ha creado el fichero con nombre: " + file.getName() + " en el directorio "
                        + folder.getAbsolutePath());
            } catch (IOException e) {
                log.error("[!] Error durante la creación del archivo");
            }
        }
    }
}
