package repasoJava4;

public class Circulo extends FiguraGeometrica {

    protected final double PI = Math.PI;

    protected double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public void calcularArea() {
        area = PI * Math.pow(radio, 2);
    }

    @Override
    public void calcularPerimetro() {
        perimetro = 2 * PI * radio;
    }

    @Override
    public void draw() {
        System.out.println("Print del metodo Draw en la clase Circulo");
    }
}
