package repasoJava;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Persona Este codigo no dispone de control de errores para I/O ya que me
 * parece innecesareo para un ejercicio tan simple.
 */
public class Persona {

    private String nombre = "";
    private int edad = 0;
    private final String DNI;
    private char sexo = 'H';
    private int peso = 0;
    private int altura = 0;

    // El main esta creado aqui ya que es un ejercicio y asi ahorro tiempo y
    // espacio.
    // Como es logico el main deberia ir en una clase separada.
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // IO Declaration
        final Logger logger = Logger.getLogger(Persona.class.getName());
        Scanner in = new Scanner(System.in);

        // IO
        System.out.print("Introduce un nombre:");
        String nombre = in.nextLine();
        System.out.print("Introduce una edad:");
        int edad = in.nextInt();
        in.nextLine();
        System.out.print("Introduce un sexo(H/m):");
        char sexo = in.nextLine().charAt(0);
        System.out.print("Introduce un peso:");
        int peso = in.nextInt();
        System.out.print("Introduce una altura:");
        int altura = in.nextInt();

        // Objects
        ArrayList<Persona> personas = new ArrayList<Persona>();
        Persona personaCopy = new Persona("pepe", 21, 'H');

        personas.add(new Persona(nombre, edad, sexo, peso, altura));
        personas.add(new Persona(nombre, edad, sexo));
        personas.add(new Persona());
        personas.add(new Persona(personaCopy));

        System.out.println("\nInformación sobre el peso:");
        personas.forEach((Persona persona) -> {
            String imc;
            try {
                imc = Persona.convertirIMC(persona.calcularIMC());
            } catch (Exception e) {
                logger.warning("El peso o la altura no estan definidos para este Objeto");
                imc = "NO DATA";
            }
            System.out.println(String.format("%s IMC: %s", persona.getNombre(), imc));
        });
        System.out.println("\nInformación personal:");
        personas.forEach((Persona persona) -> System.out
                .println("\n" + persona.toString() + " Mayor de edad? " + persona.esMayorDeEdad()));
    }

    // Metodo estatico para comodidad en el main.
    public static String convertirIMC(int imcO) {
        if (imcO >= 25)
            return "Sobrepeso";
        else if (imcO < 20)
            return "Ideal";
        return "Por debajo de lo Ideal";
    }

    // Class

    public Persona() {
        DNI = generarDNI();
    }

    public Persona(String nombre, int edad, char sexo) {
        this.DNI = generarDNI();
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public Persona(String nombre, int edad, char sexo, int peso, int altura) {
        this.DNI = generarDNI();
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(Persona persona) {
        this.DNI = persona.DNI;
        this.nombre = persona.nombre;
        this.edad = persona.edad;
        this.sexo = persona.sexo;
        this.peso = persona.peso;
        this.altura = persona.altura;
    }

    public int calcularIMC() throws Exception {
        if (peso == 0 || altura == 0) {
            throw new Exception("No hay datos del peso y la altura");
        }
        double imc = peso / (Math.pow(altura, 2));
        if (imc < 20)
            return -1;
        else if (imc <= 25)
            return 0;
        return 1;
    }

    public Boolean esMayorDeEdad() {
        if (edad >= 18)
            return true;
        return false;
    }

    public boolean comprobarSexo(char sexo) {
        if (this.sexo == sexo)
            return true;
        return false;
    }

    private String generarDNI() {
        int randomnum = (int) (99999999 * Math.random());
        char randomchar = (char) (int) (25 * Math.random() + 65);
        return String.valueOf(randomnum) + randomchar;
    }

    public String toString() {
        return "DNI: " + DNI + "\nNombre: " + nombre + " Edad: " + edad + " Sexo: " + sexo + " Peso: " + peso
                + " Altura: " + altura;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDNI() {
        return this.DNI;
    }

    public char getSexo() {
        return this.sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}