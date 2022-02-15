import static java.lang.System.err;
import static java.lang.System.out;

import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Scanner;

public class Ej2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String data = "";
        boolean run = true;

        while (run) {
            try {
                out.print("(Exit/Quit para salir)\nIntroduce una URL: ");
                URLConnection stream = new URL(in.nextLine()).openConnection();
                if (stream.getContentType().startsWith("text/")) {
                    String[] type = stream.getContentType().split("; ");
                    System.out.println("Tipo de URL: " + type[0]);
                    System.out.println("Tipo de Codex: " + type[1]);
                } else if (stream.getContentType().startsWith("application/")) {
                    System.out.println("Tamaño del archivo: " + stream.getContentLength());
                    System.out.println("Fecha de modificacion: " + new Date(stream.getLastModified()));
                } else if (stream.getContentType().startsWith("image/")) {
                    System.out.println("Tamaño de la imagen: " + stream.getContentLength());
                }

            } catch (Exception e) {
                err.println();
            }
            if ((data.equalsIgnoreCase("Quit")) || data.equalsIgnoreCase("exit"))
                run = false;
        }
        in.close();
    }
}