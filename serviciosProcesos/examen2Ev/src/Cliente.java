import static java.lang.System.out;

import java.util.Random;

public class Cliente extends Thread {
	Random r = new Random();
	private Ruleta ruleta;

	private String nombre;
	private int tiradasCliente;
	private String metodo;
	private String estrategia;

	private int apuestaInicial;
	private int dineroInicial;
	private int dineroCliente;
	private int apuesta;
	private float totApuesta;
	final int randomFixed = r.nextInt(36) + 1;
	Boolean lastWin = false;

	public Cliente(String nombre, Ruleta ruleta, int dineroInicial, int apuestaInicial, String metodo,
			String estrategia) {
		this.nombre = nombre;
		this.ruleta = ruleta;
		this.dineroInicial = dineroInicial;
		this.apuestaInicial = apuestaInicial;
		this.metodo = metodo;
		this.estrategia = estrategia;
		dineroCliente = dineroInicial;

		start();
	}

	public void iniciar() {
		if (metodo.equals("F"))
			out.println(nombre + " - Dinero inicial: " + dineroCliente + "E - ApuestaFija: " + randomFixed);
		else
			out.println(nombre + " - Dinero inicial: " + dineroCliente + "E");
	}

	public void finalizar() {
		out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
				nombre + ": Fin de la partida - tiradasTotales: " + tiradasCliente + " - Dinero: " + dineroCliente
				+ "E\n" +
				nombre + ": Beneficio: " + (dineroCliente - dineroInicial) + "E. Rendimiento: "
				+ ((dineroCliente - dineroInicial) / totApuesta) * 100 + "%\n" +
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	int calcularApuesta() {
		if (metodo.equals("F")) {
			if (estrategia.equals("C")) {
				apuesta = apuestaInicial;
				return ruleta.apostar(nombre, randomFixed, apuesta);
			} else if (estrategia.equals("M")) {
				return ruleta.apostar(nombre, randomFixed, martinGala());
			} else {
				return ruleta.apostar(nombre, randomFixed, dAlembert());
			}
		} else {
			int randomRandom = r.nextInt(36) + 1;
			if (estrategia.equals("C")) {
				apuesta = apuestaInicial;
				return ruleta.apostar(nombre, randomRandom, apuesta);
			} else if (estrategia.equals("M")) {
				return ruleta.apostar(nombre, randomRandom, martinGala());
			} else {
				return ruleta.apostar(nombre, randomRandom, dAlembert());
			}
		}
	}

	int martinGala() {
		if (Boolean.TRUE.equals(lastWin)) {
			apuesta = apuestaInicial;
		} else {
			apuesta = apuesta * 2;
		}
		if (apuesta < apuestaInicial) {
			apuesta = apuestaInicial;
		}
		return apuesta;
	}

	int dAlembert() {
		if (Boolean.TRUE.equals(lastWin)) {
			apuesta--;
		} else {
			apuesta++;
		}
		return apuesta;
	}

	@Override
	public void run() {
		iniciar();
		while (ruleta.getState() != Thread.State.TERMINATED) {
			if (dineroCliente > apuesta) {
				int resultado = calcularApuesta();
				if (resultado >= 0) {
					tiradasCliente++;
					dineroCliente += resultado;
					totApuesta += apuesta;
					lastWin = true;
				} else {
					tiradasCliente++;
					dineroCliente += resultado;
					totApuesta += apuesta;
					lastWin = false;
				}
			} else {
				out.println("--------------------------------------------\n" +
						"No te queda dinero para apostar. Saliendo...\n" +
						"--------------------------------------------");
				break;
			}
		}
		finalizar();
	}
}