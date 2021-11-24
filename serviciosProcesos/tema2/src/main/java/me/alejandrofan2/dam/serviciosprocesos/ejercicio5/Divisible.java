package me.alejandrofan2.dam.serviciosprocesos.ejercicio5;

import java.util.concurrent.Callable;

public class Divisible implements Callable<Integer> {
	
	private int input;

	public Divisible(int in) {
		super();
		this.input = in;
	}

	@Override
	public Integer call() throws Exception {
		if (input % 2 == 0 && input % 3 != 0) {
			return 0;
		} else if (input % 3 == 0 && input % 2 != 0) {
			return 1;
		} else if (input % 2 == 0 && input % 3 == 0) {
			return 2;
		} else {
			return -1;
		}
	}
}
