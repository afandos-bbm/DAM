package repasoJava5;

public class RegionInglesa extends Region {

    public RegionInglesa(String nombre) {
        super(nombre);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String format(int day, int month, int year) {
        // TODO Auto-generated method stub
        return month + "-" + day + "" + year;
    }
}
