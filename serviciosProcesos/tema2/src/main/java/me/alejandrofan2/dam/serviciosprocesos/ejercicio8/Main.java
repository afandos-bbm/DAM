package me.alejandrofan2.dam.serviciosprocesos.ejercicio8;

public class Main {
    public static void main(String[] args) {
        TransaccionesManager manager = new TransaccionesManager("[Transaction Manager]", 0);
        new IngresosT("[Ingresos] => ", manager).start();
        new RetiradasT("[Retiradas] => ", manager).start();
    }
}
