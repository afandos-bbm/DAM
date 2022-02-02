package ejercicioExtraThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		final Farmacia r = new Farmacia();
		executor.scheduleWithFixedDelay(r, 0, 1, TimeUnit.SECONDS);
	}
}
