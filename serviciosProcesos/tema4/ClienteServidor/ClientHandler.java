import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

class ClientHandler implements Runnable {
    private Socket client;
    private boolean run = true;
    private DataInputStream in;
    private DataOutputStream out;
    private ArrayList<Integer> arrayNum = new ArrayList<>();

    public ClientHandler(Socket client) {
        this.client = client;
    }

    private void init() throws IOException {
        in = new DataInputStream(client.getInputStream());
        out = new DataOutputStream(client.getOutputStream());
    }

    @Override
    public void run() {
        String data = "";
        try {
            init();
            out.writeUTF(
                    "Modo(Exit/Quit para salir):\n1.Espejo.\n2.Suma");
            switch (Integer.parseInt(in.readUTF())) {
                case 1:
                    data = espejo(data);
                    break;
                case 2:
                    data = suma(data);
                    break;
                default:
                    data = "Modo no valido";
                    break;
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if ((data.equalsIgnoreCase("Quit")) || data.equalsIgnoreCase("exit")) {
                try {
                    run = false;
                    if (in != null)
                        in.close();
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

    private String espejo(String data) {
        while (run) {
            try {
                out.writeUTF(data);
                out.flush();
                data = in.readUTF();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {
                if ((data.equalsIgnoreCase("Quit")) || data.equalsIgnoreCase("exit"))
                    run = false;
            }
        }
        return data;
    }

    private String suma(String data) {
        int sumaTotal = 0;
        try {
            out.writeUTF("Bienvenido al modo suma");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        while (run) {
            try {
                data = in.readUTF();
                if (data.equalsIgnoreCase("=")) {
                    for (int i = 0; i < arrayNum.size(); i++) {
                        sumaTotal = sumaTotal + arrayNum.get(i);
                    }
                    data = Integer.toString(sumaTotal);
                    out.writeUTF(data);
                    out.flush();
                    arrayNum.clear();
                    sumaTotal = 0;
                }
                if (Integer.class.isInstance(Integer.parseInt(data))) {
                    out.writeUTF("Has añadido el número: " + data);
                    out.flush();
                    arrayNum.add(Integer.parseInt(data));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if ((data.equalsIgnoreCase("Quit")) || data.equalsIgnoreCase("exit")) {
                    run = false;
                }
            }
        }
        return data;
    }
}