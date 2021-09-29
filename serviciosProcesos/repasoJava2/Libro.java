package repasoJava2;

public class Libro extends Material {

    private String autor;
    private int numPage;

    public Libro(String codigo, String titulo, String autor, int numPage) {
        super(codigo, titulo);
        this.autor = autor;
        this.numPage = numPage;
    }

    public String toString() {
        return super.titulo + " ( Autor:" + autor + ", NºPaginas: " + numPage + ")\n" + "Codigo: " + super.codigo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPage() {
        return this.numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }
}