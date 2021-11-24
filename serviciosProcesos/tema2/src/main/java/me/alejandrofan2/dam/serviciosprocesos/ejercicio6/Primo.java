package me.alejandrofan2.dam.serviciosprocesos.ejercicio6;

public class Primo implements Runnable {

	private int range;

	public Primo(int range) {
		super();
		this.range = range;
	}

	static boolean esPrimo(int n) {
		if (n < 2)
			return false;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;

		int max = n / 2;
		for (int i = 3; i < max; i = i + 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	@Override
	public void run() {
		for (int i = 0; i < range * 1000; i++) {
			if (esPrimo(i))
				System.out.println("[Thread " + this.range + "] " + i + " es primo.");
		}

	}

}
