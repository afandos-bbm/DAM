package me.alejandrofan2.dam.serviciosprocesos.ejercicio6;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

	private static Scanner in = new Scanner(System.in);
	private static ThreadPoolExecutor executor;

	public static void main(String[] args) {
		System.out.print("Introduce un numero del 1 al 10: ");
		int n = in.nextInt();
		
		if (n <= 10 && n >= 1) {
			executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(n);
			for (int i = 1; i <= n; i++) {
				Primo runnable = new Primo(i);
				executor.execute(runnable);
			}
			executor.shutdown();
		} else {
			System.out.println("Se ha excedido el rango (1-10)\n Saliendo...");
			System.exit(1);
		}
	}

}
