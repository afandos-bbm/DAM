package me.alejandrofan2.dam.serviciosprocesos.ejercicio8;

public class Encontrar extends Thread {
    public static void main(String[] args) throws InterruptedException {
        int dies = 100;
        int[] a = new int[dies];
        int nfils = 10;
        int[] maxParcial = new int[nfils];
        int maxT = a[0];
        for (int i = 0; i < dies; i++) {
            a[i] = (int) (56 * Math.random()) - 10;
        }
        Encontrar[] fils = new Encontrar[nfils];
        int rang = dies / nfils;
        int limit_superior, limit_inferior = 0;
        for (int i = 0; i < nfils; i++) {
            limit_superior = limit_inferior + rang - 1;
            fils[i] = new Encontrar(a, limit_inferior,
                    limit_superior, maxParcial, i);
            limit_inferior = limit_superior + 1;
        }
        for (int i = 0; i < nfils; i++)
            fils[i].start();
        for (int i = 0; i < nfils; i++)
            fils[i].join();
        for (int i = 0; i < nfils; i++)
            if (maxParcial[i] > maxT)
                maxT = maxParcial[i];
        System.out.println("Tempeatura màxima= " + maxT + "ºC");
    }

    private int l_max;
    private int limit_inferior;
    private int limit_superior;
    private int[] arr;
    private int[] res;
    private int pos;

    public Encontrar(int[] ar, int li, int ls, int[] m, int p) {
        arr = ar;
        limit_inferior = li;
        limit_superior = ls;
        l_max = -30;
        res = m;
        pos = p;
    }

    public void run() {
        while (limit_inferior < limit_superior) {
            l_max = Math.max(l_max, arr[limit_inferior]);
            limit_inferior += 1;
        }
        System.out.println(this.getName() + ": Màxim trobat: " + l_max + "ºC");
        res[pos] = l_max;
    }
}