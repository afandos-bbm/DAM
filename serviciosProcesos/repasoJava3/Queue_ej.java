package repasoJava3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue_ej
 */
public class Queue_ej {

    public static void main(String[] args) {
        Queue<String> cola = new LinkedList<String>();

        cola.offer("uno");
        cola.offer("dos");
        cola.offer("tres");

        cola.poll();
        cola.poll();
        cola.offer("dos y medio");
        cola.offer("dos");
        cola.offer("uno");

        cola.forEach(item -> System.out.print(item + "\n"));
    }
}