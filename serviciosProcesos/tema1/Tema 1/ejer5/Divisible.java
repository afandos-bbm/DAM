package ejerciciosPropuestos5;

import java.util.concurrent.Callable;

public class Divisible implements Callable<Integer>{
	int n;

	public Divisible(int n) {
		super();
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	@Override
	public Integer call() throws Exception {
		if (n % 2 == 0 & n % 3 != 0) {
			return 0;
		} if (n % 3 == 0 & n % 2 != 0) {
			return 1;
		} if (n % 2 == 0 & n % 3 == 0) {
			return 2;
		} else {
			return -1;
		}
	}
	
	
}
