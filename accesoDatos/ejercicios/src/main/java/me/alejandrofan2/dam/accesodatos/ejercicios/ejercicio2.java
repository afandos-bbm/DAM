package me.alejandrofan2.dam.accesodatos.ejercicios;

import static java.lang.String.format;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collections;

public class ejercicio2 {

    private static String title = "DirView";
    private static boolean init = false;
    private static ArrayList<File> listaRutas = new ArrayList<File>();
    private static File listaRutaPadre = new File(File.listRoots()[0], "");

    private static Scanner in = new Scanner(System.in);
    private static final Logger log = LoggerFactory.getLogger(title);

    private static final String DIRTAG = "<Directorio>";
    private static final String DIV = "----------------------------------------------";

    public static void main(String[] args) throws IOException {

        String ruta = "";
        int select = 0;
        listaRutas.add(listaRutaPadre);
        ruta = listaRutas.get(0).getCanonicalPath();

        do {
            if (select <= listaRutas.size() && select >= 0 && listaRutas.get(select).isDirectory() && listaRutas.get(select).canRead()) {
                if (select == 0) {
                    if (!init)
                        init = true;
                    else
                        ruta = listaRutas.get(select).getParentFile().getCanonicalPath();
                } else
                    ruta = listaRutas.get(select).getCanonicalPath();

                listaRutaPadre = new File(ruta);
                listaRutas.clear();
                listaRutas.add(listaRutaPadre);
                Collections.addAll(listaRutas, listaRutaPadre.listFiles());

                log.info(DIV);
                for (int i = 0; i < listaRutas.size(); i++) {
                    if (listaRutas.get(i).isDirectory()) {
                        log.info(format("|%d.-%-1s %25s", i, listaRutas.get(i).getName(), DIRTAG));
                    } else {
                        log.info(format("|%d.-%-1s %25d", i, listaRutas.get(i).getName(), listaRutas.get(i).length()));
                    }
                }
            } else {
                select = 0;
                init = false;
                continue;
            }
            log.info("--- (0 para mostrar padre | -1 para salir) ---");
            System.out.print("[" + title + "] " + ruta + " > ");
            select = Integer.parseInt(in.nextLine());
        } while (select != -1);
        log.warn(format("Exiting...%n"));
    }
}
