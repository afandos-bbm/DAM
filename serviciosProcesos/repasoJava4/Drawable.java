package repasoJava4;

public interface Drawable {

    public default void draw() {
        System.out.println("Print del metodo draw por defecto.");
    }
}
