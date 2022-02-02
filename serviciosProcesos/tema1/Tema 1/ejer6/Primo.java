package ejerciciosPropuestos6;

public class Primo implements Runnable {

	public Primo(int n) {
		super();
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	int n;
	
	boolean esPrimo() {
        if(n < 2) 
        	return false;
        if(n == 2) 
        	return true;
        if(n % 2 == 0) 
        	return false;

        int max = n / 2;
        for(int i = 3; i < max; i = i + 2) {
            if (n % i == 0)
                return false;
        }
                return true;
    }

	@Override
	public void run() {
		if(esPrimo() == true) {
			System.out.println(n + " es primo.");
		} else {
		}
	}
	
}
