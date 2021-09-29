package repasoJava;

import java.util.ArrayList;

/**
 * ejer2
 */
public class ejer2 {

    private static ArrayList usuarios = new ArrayList<Usuario>();

    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Manuel", 24);
        usuarios.add(new Usuario(usuario1));
        usuarios.add(new Usuario("Pepe", 21));

        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((usuarios.get(i).toString()));
        }
    }
}