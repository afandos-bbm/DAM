package repasoJava;

public class Libro {

    private String codigo;
    private String titulo;
    private String autor;
    private int numPage;

    public Libro(String codigo, String titulo, String autor, int numPage) {
        super();

        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.numPage = numPage;
    }

    public String toString() {
        return titulo + " (" + autor + ", " + numPage + ")";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.equals(""))
            this.codigo = codigo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
