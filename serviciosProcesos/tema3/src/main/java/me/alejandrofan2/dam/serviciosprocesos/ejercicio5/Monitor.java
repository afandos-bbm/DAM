package me.alejandrofan2.dam.serviciosprocesos.ejercicio5;

import java.util.ArrayList;

public class Monitor {

    public static void main(String[] args)
            throws InterruptedException {
        Monitor saf = new Monitor();
        new Thread(new Productor(saf)).start();
        new Thread(new Consumidor(saf)).start();
    }

    private ArrayList<Integer> array = new ArrayList<Integer>();

    public int getSize() {
        return array.size();
    }

    public synchronized int coger() {
        while (this.getSize() < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Error cogiendo el pedido");
            }
        }
        int num = array.get(0);
        array.remove(0);
        notify();
        return num;
    }

    public synchronized void dejar(int num) {
        while (this.getSize() >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Error dejando el pedido");
            }
        }
        array.add(num);
        notify();
    }
}