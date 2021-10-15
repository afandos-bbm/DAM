package repasoJava4;

public abstract class FiguraGeometrica implements Drawable, Comparable<FiguraGeometrica> {

    protected double area;
    protected double perimetro;

    public FiguraGeometrica() {
        super();
    }

    public abstract void calcularArea();

    public abstract void calcularPerimetro();

    @Override
    public int compareTo(FiguraGeometrica o) {
        if (this.area > o.area)
            return 1;
        else if (this.area < o.area)
            return -1;
        else {
            if (this.hashCode() > o.hashCode())
                return 1;
            return -1;
        }
    }
}