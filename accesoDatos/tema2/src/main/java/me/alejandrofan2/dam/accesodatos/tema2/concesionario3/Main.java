package me.alejandrofan2.dam.accesodatos.tema2.concesionario3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Main {
    private static XMLOutputter xmlFormatter = new XMLOutputter();

    private static Element concesionario = new Element("concesionario");;
    private static Element coches = new Element("coches");
    private static Element coche;
    private static Document doc = new Document(concesionario);

    private static String id;
    private static String marca;
    private static String precio;
    private static String loop = "y";

    public static void main(String[] args) {
        try {
            concesionario.addContent(coches);

            Scanner in = new Scanner(System.in);
            do {
                System.out.print("Introduce la matricula: ");
                id = in.nextLine();

                System.out.print("Introduce la marca: ");
                marca = in.nextLine();

                System.out.print("Introduce el precio: ");
                precio = in.nextLine();

                System.out.print("Quieres seguir introduciendo elementos? (Y/n)");
                loop = in.nextLine().toLowerCase();

                coche = new Element("coche").setAttribute("matricula", id);
                coches.addContent(coche);
                coche.addContent(new Element("marca").setText(marca));
                coche.addContent(new Element("precio").setText(precio));

            } while (loop.startsWith("y"));

            xmlFormatter.setFormat(Format.getPrettyFormat());
            xmlFormatter.output(doc,
                    new FileWriter(
                            "src\\main\\java\\me\\alejandrofan2\\dam\\accesodatos\\tema2\\concesionario3\\concesionario3.xml"));
        } catch (IOException e) {
            System.err.println("Fichero no valido\nCodigo de error: " + e.getLocalizedMessage());
        }
    }
}
