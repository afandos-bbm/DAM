package me.alejandrofan2.dam.serviciosprocesos.ejercicio2;

public class Manager {

    private int total = 0;

    public static void main(String[] args) {
        Manager manager = new Manager();
        Dado dado1 = new Dado(manager);
        Dado dado2 = new Dado(manager);
        Dado dado3 = new Dado(manager);

        dado1.start();
        dado2.start();
        dado3.start();

        try {
            dado1.join();
            dado2.join();
            dado3.join();
        } catch (Exception e) {
            System.err.println("Error getting the number | " + e.getStackTrace());
        }
        
        System.out.println("Total: " + manager.getTotal());
    }

    /**
     * @return int return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int suma) {
        total += suma;
    }

}