package me.alejandrofan2.dam.accesodatos.ejercicios;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ejercicio1 {

    static File folder;
    static File file;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Set the workpace folder(Path): ");
        folder = new File(in.nextLine());
        if (!folder.exists()) {
            System.exit(1);
        }

        System.out.println("Name of the file: ");
        file = new File(folder + in.nextLine());
        if (file.exists()) {
            System.out.println("El tamaño del archivo es de: " + file.length() + " B");
        } else {
            try {
                file.createNewFile();
                System.out.println("Se ha creado el fichero con nombre: " + file.getName() + " en el directorio "
                        + folder.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("[!] Error durante la creación del archivo");
            }
        }
    }
}
