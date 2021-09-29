package repasoJava;

import java.util.ArrayList;

/**
 * ejer1
 */
public class ejer1 {

    private static ArrayList libros = new ArrayList<Libro>();

    public static void main(String[] args) {
        Libro libro1 = new Libro("11AAA", "El vell y el mar", "Ernest Hemingway", 127);
        Libro libro2 = new Libro("22BBB", "La historia interminable", "Michael Ende", 434);
        Libro libro3 = new Libro("33CCC", "lorem ipsum", "Michael Ende", 234);
        Libro libro4 = new Libro("44DDD", "La historia interminable 2", "Michael Ende", 456);
        Libro libro5 = new Libro("55EEE", "La vida de Moi", "Alejandro Fandos", 163);

        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro4);
        libros.add(libro5);

        for (int i = 0; i < libros.size(); i++) {
            System.out.println((libros.get(i).toString()));
        }
    }
}