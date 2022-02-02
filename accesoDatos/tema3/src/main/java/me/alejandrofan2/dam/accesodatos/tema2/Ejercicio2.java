package me.alejandrofan2.dam.accesodatos.tema2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ejercicio2 {
    public static void main(String[] args) {
        File file = new File(".\\ejercicio2.txt");

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] split = linea.split(" ");
                for (int i = 0; i < split.length; i++) {
                    if (Character.isDigit(split[i].charAt(0)))
                        System.out.println("Numero: " + split[i]);
                    else
                        System.out.println("Palabra: " + split[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}