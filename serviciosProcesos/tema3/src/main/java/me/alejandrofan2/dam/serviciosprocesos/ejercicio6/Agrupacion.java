package me.alejandrofan2.dam.serviciosprocesos.ejercicio6;

public class Agrupacion {
    public static void main(String[] args) {
        ThreadGroup subGrup_1 = new ThreadGroup("pool1");
        ThreadGroup subGrup_2 = new ThreadGroup("pool2");
        new Thread(subGrup_1, "hilo 1");
        new Thread(subGrup_1, "hilo 2");
        new Thread(subGrup_2, "hilo 3");

        ThreadGroup gA = Thread.currentThread().getThreadGroup();

        System.out.println("Grup Actiu: " + gA);
        System.out.println("Número de Grups Actius: " +
                gA.activeGroupCount());
        gA.list();
        System.out.println("Prioritat grup main: " +
                gA.getMaxPriority());
        System.out.println("Prioritat subgrup 1: " +
                subGrup_1.getMaxPriority());
        System.out.println("Prioritat subgrup 2: " +
                subGrup_2.getMaxPriority());
        subGrup_1.setMaxPriority(7);
        subGrup_2.setMaxPriority(3);
        System.out.println("Prioritat subgrup 1: " +
                subGrup_1.getMaxPriority());
        System.out.println("Prioritat subgrup 2: " +
                subGrup_2.getMaxPriority());
        System.out.println("Nom grup main: " + gA.getName());
        System.out.println("Nom subgrup 1: " +
                subGrup_1.getName());
        System.out.println("Nom subgrup 2: " +
                subGrup_2.getName());
        System.out.println("Pare grup main: " + gA.getParent());
        System.out.println("Pare subgrup 1: " +
                subGrup_1.getParent());
        System.out.println("Pare subgrup 2: " +
                subGrup_2.getParent());

        if (subGrup_1.parentOf(gA))
            System.out.println("SubGrup_1 és pare del hilo principal");
        else
            System.out.println("SubGrup_1 NO és pare del hilo principal");
        if (subGrup_2.parentOf(gA))
            System.out.println("SubGrup_2 és pare del hilo principal");
        else
            System.out.println("SubGrup_2 NO és pare del hilo principal");
        if (gA.parentOf(subGrup_1))
            System.out.println("SubGrup_1 és hilol del hilo principal");
        else
            System.out.println("SubGrup_1 NO és hilol del hilo principal");
        if (gA.parentOf(subGrup_2))
            System.out.println("SubGrup_2 és hilol del hilo principal");
        else
            System.out.println("SubGrup_2 NO és hilol del hilo principal");
    }
}