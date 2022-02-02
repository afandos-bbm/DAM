package ejerciciosPropuestos456;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class FCFS {
	static Scanner teclado = new Scanner (System.in);
	
	static class BCP implements Comparable<BCP> {
		
		int id;
		int llegada;
		int ejecucion;
		int retorno;
		int espera;
		
		public BCP(int id, int llegada, int ejecucion) {
			super();
			this.id = id;
			this.llegada = llegada;
			this.ejecucion = ejecucion;
		}

		@Override
		public int compareTo(BCP o) {
			return  this.llegada - o.llegada;
		}
		
	}
	
	static BCP[] bcp;
	static Queue<BCP> queue = new PriorityQueue<>();
	
	static void recibirInformacion() {
		System.out.println("Introduce el numero de procesos: ");
		int num = teclado.nextInt();
		bcp = new BCP[num+1];
		
		System.out.println("Introduce la hora de llegada y el tiempo de ejecucion: ");
		for (int i = 0; i < num; i++) {
			System.out.println("P" + i + ":");
			bcp[i] = new BCP(i, teclado.nextInt(), teclado.nextInt());
			queue.offer(bcp[i]);
		}
	}
	
	static void run() {
		int tiempoActual = 0;
		
        if(!queue.isEmpty()) {
            tiempoActual = queue.peek().llegada;
        }
        
        while (true) {
            if(queue.isEmpty()) {
                System.out.println("----- Fin de todos los procesos actuales -----");
                break;
            } else {
                BCP runBCP = queue.poll();
                System.out.print("[" + tiempoActual + "] ");
                System.out.println("P" + runBCP.id + " //INICIO//");
                runBCP.espera = tiempoActual - runBCP.llegada;
                tiempoActual += runBCP.ejecucion;
                System.out.print("[" + tiempoActual +"] ");
                System.out.println("P" + runBCP.id + " //FIN//");
                runBCP.retorno = tiempoActual - runBCP.llegada;
            }
        }
	}
	
	public static void main(String[] args) {
        recibirInformacion();
        System.out.println("----- El procesador comienza a funcionar -----");
        run();
    }
}
