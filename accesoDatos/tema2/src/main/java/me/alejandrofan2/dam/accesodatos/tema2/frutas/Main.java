package me.alejandrofan2.dam.accesodatos.tema2.frutas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> lineasArchivo = Files.readAllLines(
                    new File("src\\main\\java\\me\\alejandrofan2\\dam\\accesodatos\\tema2\\frutas\\frutas.txt")
                            .toPath(),
                    StandardCharsets.UTF_8);
            File file = new File(
                    "src\\main\\java\\me\\alejandrofan2\\dam\\accesodatos\\tema2\\frutas\\frutas.csv");

            // Comprobar que el archivo esta creado ya
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file);

            // Introduzco en el writer el header
            writer.write("ID, Nombre, Precio, temporada?\n");

            for (String linea : lineasArchivo) {
                String id;
                String nombre;
                String temporada;
                String precio;

                String temp = linea.replaceAll(",", ".");
                String partes[] = temp.split(" ");

                id = partes[0];
                nombre = partes[1];
                precio = partes[2];
                temporada = partes[3];

                writer.write(id + ", " + nombre + ", " + precio + ", " + temporada + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Error durante el proceso de conversión \nCodigo de error: " + e.getLocalizedMessage());
        }
    }
}