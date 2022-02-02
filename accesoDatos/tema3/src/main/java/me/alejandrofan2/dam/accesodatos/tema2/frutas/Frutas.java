package me.alejandrofan2.dam.accesodatos.tema2.frutas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Frutas {

    public static final String PATH = "./src/main/java/me/alejandrofan2/dam/accesodatos/tema2/frutas/";

    public static void main(String[] args) {
        try {
            writeCSV(read(PATH + "frutas.txt").split(" "), PATH + "frutas.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        StringBuilder sb = new StringBuilder();
        sb.append("ID Nombre precio temp?\n");
        try {
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        return sb.toString();
    }

    public static void readCSV(String path) throws FileNotFoundException {
        CSVReader reader = new CSV.Reader(new FileReader(PATH + "frutas.CSV"));
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
           // nextLine[] is an array of values from the line
           System.out.println(nextLine[0] + nextLine[1] + "etc...");
        }
    }

    public static void writeCSV(String[] data, String path) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(path));
        writer.writeNext(data, false);
        writer.close();
    }
}