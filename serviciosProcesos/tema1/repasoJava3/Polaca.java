package repasoJava3;

import java.util.Stack;

public class Polaca {
    private static Stack<String> pila = new Stack<String>();

    public static void main(String[] args) {
        String operacion = "7645+-";
        String[] arrayOperaciones = operacion.trim().split(" ");
        int resultado = -1;
        for (int i = 0; i < arrayOperaciones.length; i++) {
            if (arrayOperaciones[i].equals("+") || arrayOperaciones[i].equals("-") || arrayOperaciones[i].equals("*")) {
                pila.push(arrayOperaciones[i]);
            }
        }
        for (String a : pila) {
            if (a.equals("+") || a.equals("-") || a.equals("*")) {
                switch (a) {
                    case "+":
                        resultado = Integer.parseInt(pila.pop()) + Integer.parseInt(pila.pop());
                        break;

                    case "-":
                        resultado = Integer.parseInt(pila.pop()) - Integer.parseInt(pila.pop());
                        break;

                    case "*":
                        resultado = Integer.parseInt(pila.pop()) * Integer.parseInt(pila.pop());
                        break;

                    default:
                        // System.out.println("No hay input para calcular la DATA");
                        // System.exit(1);
                }
            }
        }
        System.out.println("Resultado: " + resultado);
    }
}
