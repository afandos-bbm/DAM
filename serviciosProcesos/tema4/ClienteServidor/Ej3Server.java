import java.net.ServerSocket;
import java.net.Socket;

public class Ej3Server {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6969);
        Socket client = server.accept();
        System.out.println("\nClient connected\n");
        Thread clientT = new Thread(new ClientHandler(client));
        clientT.start();
        clientT.join();
        server.close();
    }

}