package me.alejandrofan2.dam.accesodatos.tema2;

import java.io.File;
import java.util.Scanner;

public class Ejercicio2511v1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Indica una ruta: ");
        String line = in.nextLine();
        File file = new File(line);
        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Dir: " + file.getAbsolutePath());
            }
            if (file.isFile()) {
                System.out.println("File: " + file.getAbsolutePath());
                System.out.println("Name: " + file.getName() + "\nSize: " + file.length() + "\n Perms: r-> "
                        + file.canRead() + " w-> " + file.canWrite() + " x-> " + file.canExecute());
            }
        } else {
            System.out.println("INEXISTENT FILE, EXITING...");
        }
    }
}