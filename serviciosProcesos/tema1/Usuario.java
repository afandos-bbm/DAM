package repasoJava;

import java.util.ArrayList;

public class Usuario {

    private ArrayList libros = new ArrayList<Libro>();
    private String nombre;
    private int edad;

    public Usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Usuario(Usuario usuario) {
        this.nombre = usuario.nombre;
        this.edad = usuario.edad;
    }

    public void addLibro(Libro libro) {
        libros.add(libro);
    }

    public void rmLibro(Libro libro) {
        libros.remove(libro);
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        String toString = "Nombre: " + nombre + " Edad: " + edad;
        for (int i = 0; i < libros.size(); i++) {
            toString += "\n" + libros.get(i).toString();
        }
        return toString;

    }
}
