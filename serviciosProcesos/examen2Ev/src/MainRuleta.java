public class MainRuleta {

	public static void main(String[] args) {

		int dineroInicial = 1000;
		int apuestaInicial = 1;
		int maxTiradas = 50;

		Ruleta r = new Ruleta(maxTiradas);

		new Cliente("FijoConstante       ", r, dineroInicial, apuestaInicial, "F", "C");
		new Cliente("FijoMartin          ", r, dineroInicial, apuestaInicial, "F", "M");
		new Cliente("FijoDAlembert       ", r, dineroInicial, apuestaInicial, "F", "D");
		new Cliente("AleatorioConstante  ", r, dineroInicial, apuestaInicial, "A", "C");
		new Cliente("AleatorioMartinGala ", r, dineroInicial, apuestaInicial, "A", "M");
		new Cliente("AleatorioDAlembert  ", r, dineroInicial, apuestaInicial, "A", "D");

		// Start all the threads
		
		
	}
}
