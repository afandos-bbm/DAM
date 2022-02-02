package me.alejandrofan2.dam.accesodatos.tema2.concesionario2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Main {
    private static File file = new File(
            "src\\main\\java\\me\\alejandrofan2\\dam\\accesodatos\\tema2\\concesionario\\concesionario.xml");
    private static SAXBuilder saxBuilder = new SAXBuilder();
    private static XMLOutputter xmlFormatter = new XMLOutputter();

    public static void main(String[] args) {
        Document doc;
        Element concesionario;
        Element coches;
        Element coche;
        Element marca;
        Element precio;

        try {
            doc = saxBuilder.build(file);

            concesionario = new Element("concesionario");
            coches = new Element("coches");
            coche = new Element("coche");
            marca = new Element("marca");
            precio = new Element("precio");

            concesionario.addContent(coches);
            coches.addContent(coche);

            marca.setText("AUDI");
            precio.setText("30000");
            coche.setAttribute("matricula", "1111AAA");

            coche.addContent(precio);
            coche.addContent(marca);

            marca.setText("SEAT");
            precio.setText("10000");
            coche.setAttribute("matricula", "2222BBB");

            marca.setText("BMW");
            precio.setText("20000");
            coche.setAttribute("matricula", "3333CCC");

            marca.setText("TOYOTA");
            precio.setText("10000");
            coche.setAttribute("matricula", "4444DDD");

            xmlFormatter.setFormat(Format.getPrettyFormat());
            xmlFormatter.output(doc,
                    new FileWriter(
                            "src\\main\\java\\me\\alejandrofan2\\dam\\accesodatos\\tema2\\concesionario2\\concesionario2.xml"));

        } catch (JDOMException ex) {
            System.err.println("Error creando el fichero\nCodigo de Error: " + ex.getLocalizedMessage());
        } catch (IOException e) {
            System.err.println("Fichero no valido\nCodigo de Error: " + e.getLocalizedMessage());
        }
    }
}