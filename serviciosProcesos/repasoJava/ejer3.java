package repasoJava;

import java.util.ArrayList;

/**
 * ejer3
 */
public class ejer3 {

    private static ArrayList usuarios = new ArrayList<Usuario>();
    private static ArrayList libros = new ArrayList<Libro>();

    public static void main(String[] args) {
        Libro libro1 = new Libro("11AAA", "El vell y el mar", "Ernest Hemingway", 127);
        Libro libro2 = new Libro("22BBB", "La historia interminable", "Michael Ende", 434);

        Usuario usuario1 = new Usuario("Manuel", 24);
        usuario1.addLibro(libro1);
        usuario1.addLibro(libro2);
        usuarios.add(usuario1);

        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((usuarios.get(i).toString()));
        }
    }
}