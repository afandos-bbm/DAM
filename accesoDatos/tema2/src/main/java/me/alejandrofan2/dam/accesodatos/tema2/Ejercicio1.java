package me.alejandrofan2.dam.accesodatos.tema2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ejercicio1 {
    public static void main(String[] args) {
        File file = new File(".\\ejercicio1.txt");

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                char ch = linea.charAt(0);
                if (Character.isDigit(ch))
                    System.out.println("Numero: " + linea);
                else
                    System.out.println("Texto: " + linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}