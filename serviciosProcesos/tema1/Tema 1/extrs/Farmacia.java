package ejercicioExtraThreadPool;

import java.util.ArrayList;

public class Farmacia implements Runnable {
	ArrayList<String> frases = new ArrayList<String>();
	ArrayList<String> frasesUsadas = new ArrayList<String>();
	String hidratate = "Hidratate bien";
	String camina5km = "Camina 5km al dia";
	String bebeAgua = "Bebe dos litros de agua al dia";
	String ejercicio = "Haz deporte diariamente";
	String fruta = "Come 5 piezas de fruta al dia";
	int r = -1;
	
	Farmacia() {
		frases.add(hidratate);
		frases.add(camina5km);
		frases.add(bebeAgua);
		frases.add(ejercicio);
		frases.add(fruta);
	}
	
	@Override
	public void run() {
		double random = Math.floor(Math.random() * frases.size());
		int n = (int)random;
		if (r != n)
			System.out.println(frases.get(n));
		r = n;
			
	}
}
