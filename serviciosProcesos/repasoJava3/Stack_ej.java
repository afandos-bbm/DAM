package repasoJava3;

import java.util.Stack;

/**
 * main
 */
public class Stack_ej {

    public static void main(String[] args) {

        Stack<String> pila = new Stack<String>();

        pila.add("1");
        pila.add("2");
        pila.add("3");
        pila.pop();
        pila.add("2.5");
        pila.add("3");

        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
    }
}