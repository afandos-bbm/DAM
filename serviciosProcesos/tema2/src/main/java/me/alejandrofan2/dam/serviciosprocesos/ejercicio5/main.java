package me.alejandrofan2.dam.serviciosprocesos.ejercicio5;

import java.util.ArrayList;

public class Main {

	static ArrayList<Integer> div2 = new ArrayList<Integer>();
	static ArrayList<Integer> div3 = new ArrayList<Integer>();
	static ArrayList<Integer> div23 = new ArrayList<Integer>();

	public static void main(String[] args) {

		for (int i = 1; i <= 99; i++) {
			Divisible divCheker = new Divisible(i);
			try {
				int n = divCheker.call();
				if (n == 0)
					div2.add(i);
				else if (n == 1)
					div3.add(i);
				else if (n == 2)
					div23.add(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.print("\nDivisibles por dos: ");
		for (int num : div2) {
			System.out.print(num + ", ");
		}
		System.out.print("\nDivisibles por tres: ");
		for (int num : div3) {
			System.out.print(num + ", ");
		}
		System.out.print("\nDivisibles por dos y tres: ");
		for (int num : div23) {
			System.out.print(num + ", ");
		}

	}
}
