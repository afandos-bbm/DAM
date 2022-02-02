package me.alejandrofan2.dam.accesodatos.tema2.concesionario;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Main {
    private static File input = new File(
            "src\\main\\java\\me\\alejandrofan2\\dam\\accesodatos\\tema2\\concesionario\\concesionario.xml");
    private static SAXBuilder saxBuilder = new SAXBuilder();

    public static void main(String[] args) {
        Document doc = null;
        Element root = null;
        try {
            doc = saxBuilder.build(input);
        } catch (JDOMException ex) {
            System.err.println("Fichero XML no valido\nCodigo de Error: " + ex.getLocalizedMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Fichero no valido\nCodigo de Error: " + e.getLocalizedMessage());
            System.exit(1);
        }

        root = doc.getRootElement().getChild("coches");
        List printCue = root.getChildren("coche");
        for (int i = 0; i < printCue.size(); i++) {
            Element nodo = (Element) printCue.get(i);
            System.out.println("Con matricula: " + nodo.getAttributeValue("matricula"));
            System.out.println("Marca del vehiculo: " + nodo.getChild("marca").getValue());
            System.out.println("Precio del vehiculo: " + nodo.getChild("precio").getValue() + "\n");
        }
    }
}