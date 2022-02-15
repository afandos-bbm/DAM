import static java.lang.System.err;
import static java.lang.System.out;
import static java.net.InetAddress.getByName;

import java.net.InetAddress;
import java.util.Scanner;

public class Ej1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String data = "";
        boolean run = true;

        while (run) {
            out.print("(Exit/Quit para salir)\nIntroduce un dominio/IP:");
            data = in.nextLine();

            try {
                if (Character.isDigit(data.charAt(0))) {
                    InetAddress iAddr = getByName(data);
                    out.println("Dominio: " + iAddr.getHostName());
                } else {
                    InetAddress iAddr = getByName(data);
                    out.println("IP: " + iAddr.getHostAddress());
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