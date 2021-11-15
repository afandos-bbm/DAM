package repasoJava4;

public class Rectangulo extends FiguraGeometrica {

    protected double base;
    protected double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;

        calcularPerimetro();
        calcularArea();
    }

    @Override
    public void calcularArea() {
        area = base * altura;
    }

    @Override
    public void calcularPerimetro() {
        perimetro = (2 * base) + (2 * altura);
    }

    @Override
    public void draw() {
        System.out.println("Print del metodo Draw en la clase Rectangulo");
    }
}
