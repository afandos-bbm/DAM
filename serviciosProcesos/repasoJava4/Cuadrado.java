package repasoJava4;

public class Cuadrado extends FiguraGeometrica {

    protected double lado;

    public Cuadrado(double lado) {
        this.lado = lado;

        calcularPerimetro();
        calcularArea();
    }

    @Override
    public void calcularArea() {
        area = lado * lado;
    }

    @Override
    public void calcularPerimetro() {
        perimetro = lado * 4;
    }

    @Override
    public void draw() {
        System.out.println("Print del metodo Draw en la clase Cuadrado");
    }
}
