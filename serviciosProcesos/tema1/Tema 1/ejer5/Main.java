package ejerciciosPropuestos5;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Divisible> dos = new ArrayList<Divisible>();
		ArrayList<Divisible> tres = new ArrayList<Divisible>();
		ArrayList<Divisible> dosTres = new ArrayList<Divisible>();
		for (int i = 1; i < 100; i++) {
			Divisible d = new Divisible(i);
			try {
				int n = d.call();
				if (n == 0) {
					dos.add(d);
				} if (n == 1) {
					tres.add(d);
				} if (n == 2) {
					dosTres.add(d);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.print("Divisibles por dos: ");
		for (int i = 0; i < dos.size(); i++) {
			System.out.print(dos.get(i).n + ", ");
		}
		System.out.print("\nDivisibles por tres: ");
		for (int i = 0; i < tres.size(); i++) {
			System.out.print(tres.get(i).n + ", ");
		}
		System.out.print("\nDivisibles por dos y tres: ");
		for (int i = 0; i < dosTres.size(); i++) {
			System.out.print(dosTres.get(i).n + ", ");
		}
		
	}
}
