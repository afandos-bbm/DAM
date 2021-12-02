package me.alejandrofan2.dam.accesodatos.tema2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Ejercicio2511v4 {

    public static File origin = new File(".\\Restaurants.csv");

    public static CSVReader reader;
    public static CSVWriter writer;

    public static Map<String, List<String>> rte = new HashMap<>();

    public static void main(String[] args) throws IOException {
        importCsv(origin);
        rte.get("name").add("Patxingar");
        rte.get("address").add("Calle la pantomima n13");
        rte.get("city").add("Baltimore");
        rte.get("state").add("Louisiana");
        rte.get("zip").add("12600");

        exportCsv(origin);
    }

    public static void importCsv(File path) {
        rte.put("name", new ArrayList<String>());
        rte.put("address", new ArrayList<String>());
        rte.put("city", new ArrayList<String>());
        rte.put("state", new ArrayList<String>());
        rte.put("zip", new ArrayList<String>());
        try {
            reader = new CSVReader(new FileReader(path));
            String[] nextLine = null;
            reader.readNext();
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

    public static Boolean exportCsv(File path) throws IOException {
        writer = new CSVWriter(new FileWriter(path));
        String[] nextLine;
        for (int i = 0; i < rte.get("name").size(); i++) {
            nextLine = (rte.get("name").get(i) + "@" + rte.get("address").get(i) + "@"
                    + rte.get("city").get(i) + "@" + rte.get("state").get(i) + "@" + rte.get("zip").get(i)).split("@");
            writer.writeNext(nextLine, false);
        }
        writer.close();
        return true;
    }
}