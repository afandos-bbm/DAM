package me.alejandrofan2.dam.accesodatos.tema2.frutas2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class Main {

	private static File csv = new File(
			"src\\main\\java\\me\\alejandrofan2\\dam\\accesodatos\\tema2\\frutas2\\frutas.csv");
	private static File csv2 = new File(
			"src\\main\\java\\me\\alejandrofan2\\dam\\accesodatos\\tema2\\frutas2\\frutas2.csv");

	public static void main(String[] args) {
		try {
			if (!csv2.exists())
				csv2.createNewFile();

			CSVWriter writer = new CSVWriter(new FileWriter(csv2), CSVWriter.DEFAULT_SEPARATOR,
					CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.RFC4180_LINE_END);
			CSVReader reader = new CSVReader(new FileReader(csv));
			String[] row;
			while ((row = reader.readNext()) != null) {
				if (!row[3].equals(" No"))
					writer.writeNext(row);
			}
			writer.close();
		} catch (IOException e) {
			System.err.println("Error reading the file \nCodigo de error: " + e.getLocalizedMessage());
		} catch (CsvValidationException e) {
			System.err.println("Error parsing the file \nCodigo de error: " + e.getLocalizedMessage());
		}
	}
}
