package repasoJava5;

public class RegionEspanola extends Region {

    public RegionEspanola(String nombre) {
        super(nombre);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String format(int day, int month, int year) {
        // TODO Auto-generated method stub
        return day + "-" + month + "" + year;
    }
}
