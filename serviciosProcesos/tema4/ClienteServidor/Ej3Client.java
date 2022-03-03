import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ej3Client {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        DataInputStream in = null;
        DataOutputStream out = null;

        Socket client = new Socket("127.0.0.1", 6969);
        out = new DataOutputStream(client.getOutputStream());
        in = new DataInputStream(client.getInputStream());
        run(keyboard, in, out, client);
    }

    private static void run(Scanner keyboard, DataInputStream in, DataOutputStream out,
            Socket client) {
        String data = "";
        boolean run = true;
        while (run) {
            try {
                data = in.readUTF();
                System.out.println(data);
                data = keyboard.nextLine();
                out.writeUTF(data);
                out.flush();
            } catch (Exception e) {
                System.err.println("Ej3Client.run() - " + e.getMessage() + " - " + e.getClass());
            } finally {
                if ((data.equalsIgnoreCase("Quit")) || data.equalsIgnoreCase("exit")) {
                    try {
                        run = false;
                        if (in != null)
                            in.close();
                        if (keyboard != null)
                            keyboard.close();
                        if (out != null)
                            out.close();
                        if (client != null)
                            client.close();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        }
    }
}
