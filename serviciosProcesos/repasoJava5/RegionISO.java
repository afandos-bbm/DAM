package repasoJava5;

public class RegionISO extends Region {

    public RegionISO(String nombre) {
        super(nombre);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String format(int day, int month, int year) {
        // TODO Auto-generated method stub
        return year + "-" + month + "" + day;
    }
}
