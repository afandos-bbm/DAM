package repasoJava2;

public class Pelicula extends Material {

    protected int duracion;
    protected String idioma;

    public Pelicula(String codigo, String titulo, int duracion, String idioma) {
        super(codigo, titulo);
        this.duracion = duracion;
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return super.titulo + " (Duración: " + duracion + ", Idioma: " + idioma + ")\n" + "Codigo: " + super.codigo;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getIdioma() {
        return this.idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

}
