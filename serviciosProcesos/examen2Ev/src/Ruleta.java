import static java.lang.System.out;
import java.util.Random;

public class Ruleta extends Thread {

	private Random r = new Random();

	private int tiradas;
	private int maxTirades;
	private int numeroGanador;
	private static final String SEPARATOR = "############################################################";

	public Ruleta(int mT) {
		maxTirades = mT;
		tiradas = 0;
		start();
	}

	public synchronized void iniciar() {
		out.println(SEPARATOR);
		out.println("Empieza la partida");
		out.println(SEPARATOR);
		notifyAll();
	}

	public void finalitzar() {
		out.println(SEPARATOR);
		out.println("Fin de la partida - Tiradas: " + tiradas);
		out.println(SEPARATOR);
	}

	public synchronized int apostar(String cliente, int numeApostado, int dineroApostado) {
		out.println(cliente + "| Apuesta " + dineroApostado + "E al numero: " + numeApostado);
		try {
			wait();
		} catch (InterruptedException e) {
			System.err.println("Ruleta.apostar() - InterruptedException - wait()");
		}

		if (numeApostado == numeroGanador) {
			dineroApostado *= 36;
			out.println(cliente + "| Gana " + dineroApostado + "!");
			return dineroApostado;
		} else {
			out.println(cliente + "| Pierde " + dineroApostado + "!");
			return -dineroApostado;
		}
	}

	public synchronized void rodarRuleta() {
		if (tiradas <= maxTirades) {
			numeroGanador = r.nextInt(37);
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				System.err.println("Ruleta.rodarRuleta() - InterruptedException - Thread.sleep()");
			}
			out.println(SEPARATOR);
			out.println("La ruleta ha girado y ha salido el numero " + numeroGanador);
			out.println(SEPARATOR);
			tiradas++;
		}
	}

	public synchronized void nextRound() {
		notifyAll();
	}

	@Override
	public void run() {
		iniciar();
		while (tiradas <= maxTirades) {
			nextRound();
			rodarRuleta();
		}
		finalitzar();
	}
}