package me.alejandrofan2.dam.serviciosprocesos.ejercicio4;

public class Manager {

    public static void main(String[] args) throws InterruptedException {
        Manager man = new Manager();
        HolaT t1 = new HolaT(man);
        AdiosT t2 = new AdiosT(man);

        t1.start();
        t2.start();
    }

    boolean check = false;

    public synchronized void escribeAdios() {
        while (check == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        check = false;
        System.out.println("Adéu");
    }

    public synchronized void escribeHola() {
        System.out.println("Hola");
        check = true;
        notify();
    }
}