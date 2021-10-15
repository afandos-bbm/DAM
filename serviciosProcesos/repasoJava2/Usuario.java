package repasoJava2;

import java.util.ArrayList;

public class Usuario {

    private ArrayList<Material> materiales = new ArrayList<Material>();
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

    public void addMaterial(Material material) {
        materiales.add(material);
    }

    public void rmLibro(Material material) {
        materiales.remove(material);
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
        for (int i = 0; i < materiales.size(); i++) {
            if (materiales.get(i) instanceof Libro) {
                Libro libro = (Libro) materiales.get(i);
                if (libro.getNumPage() >= 500) {
                    toString += "\n Libro:" + materiales.get(i).toString();
                } else {
                    toString += "\n" + materiales.get(i).toString();
                }
            }
            
        }
        return toString;

    }
}
