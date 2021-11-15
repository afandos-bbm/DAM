package repasoJava2;

import java.util.ArrayList;

/**
 * main
 */
public class main {

    private static ArrayList usuarios = new ArrayList<Usuario>();

    public static void main(String[] args) {
        Libro libro1 = new Libro("11AAA", "El vell y el mar", "Ernest Hemingway", 127);
        Libro libro2 = new Libro("22BBB", "La historia interminable", "Michael Ende", 434);
        Pelicula pelicula1 = new Pelicula("33CCC", "Star wars: El imperio chupacabras", 160, "español");
        Usuario usuario1 = new Usuario("Manuel", 24);
        usuario1.addMaterial(libro1);
        usuario1.addMaterial(libro2);
        usuario1.addMaterial(pelicula1);
        usuarios.add(usuario1);

        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((usuarios.get(i).toString()));
        }
    }
}