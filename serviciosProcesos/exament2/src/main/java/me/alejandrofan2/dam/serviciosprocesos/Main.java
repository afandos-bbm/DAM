package me.alejandrofan2.dam.serviciosprocesos;

public class Main {
    public static void main(String[] args) {
        TiendaManager manager = new TiendaManager();
        for (int i = 1; i <= 4; i++)
            new TrabajadorT("Trabajador " + i, manager).start();

        for (int i = 1; i <= 5; i++)
            new RepartidorT("Repartidor " + i, manager).start();

        for (int i = 1; i < 15; i++)
            new ClienteT("Cliente " + i, manager).start();
    }

}
