package ejerciciosPropuestos6;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un numero del 1 al 10: ");
		int n = teclado.nextInt();
		
		if (n > 0 && n <= 10) {
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(n);
			for (int i = 0; i <= n * 1000; i++) {
				Primo worker = new Primo(i);
				// Si descomentas lo de abajo se puede ver cuantos hilos estan ejecutando la tarea.
				// System.out.println("Thread: " + executor.getActiveCount());
				executor.execute(worker);
			}
			executor.shutdown();
		} else {
			System.out.println("El numero debe estar entre 1 y 10.");
			System.exit(0);
		}
		teclado.close();
	}

}
