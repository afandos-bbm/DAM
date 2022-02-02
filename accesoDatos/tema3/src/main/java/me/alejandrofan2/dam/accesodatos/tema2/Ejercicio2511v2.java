package me.alejandrofan2.dam.accesodatos.tema2;

import static java.lang.String.format;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;

public class Ejercicio2511v2 {

    public static File origin = new File(".\\Restaurants.csv");
    public static final char SEPARATOR = ';';
    public static final char QUOTE = '"';
    public static final char SPLIT = ',';

    public static CSVReader reader;
    public static Map<String, List<String>> rte = new HashMap<>();

    public static void main(String[] args) {
        importCsv(origin);
        for (int i = 0; i < rte.get("zip").size(); i++) {
            if (rte.get("zip").get(i).startsWith("6")) {
                System.out.println(format("--------------------   %s   ------------------------", i));
                System.out.println(rte.get("name").get(i) + "\n" + rte.get("city").get(i) + "\n"
                        + rte.get("city").get(i) + "\n" + rte.get("state").get(i) + "\n" + rte.get("zip").get(i));
            }
        }

    }

    public static void importCsv(File path) {
        rte.put("name", new ArrayList<String>());
        rte.put("address", new ArrayList<String>());
        rte.put("city", new ArrayList<String>());
        rte.put("state", new ArrayList<String>());
        rte.put("zip", new ArrayList<String>());
        try {
            reader = new CSVReader(new FileReader(origin));
            String[] nextLine = null;
            while ((nextLine = reader.readNext()) != null) {
                for (int i = 0; i < nextLine.length; i++) {
                    switch (i) {
                        case 0:
                            rte.get("name").add(nextLine[i]);
                            break;
                        case 1:
                            rte.get("address").add(nextLine[i]);
                            break;
                        case 2:
                            rte.get("city").add(nextLine[i]);
                            break;
                        case 3:
                            rte.get("state").add(nextLine[i]);
                            break;
                        case 4:
                            rte.get("zip").add(nextLine[i]);
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}