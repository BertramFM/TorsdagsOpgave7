package util;

import model.Vare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public static List<Vare> readFile(String fileName) {
        List<Vare> Varer = new ArrayList<>();

        try  (BufferedReader read = new BufferedReader(new FileReader(fileName))) {
            String line;
            read.readLine(); // header skip

            while ((line = read.readLine()) != null) {
                String[] p = line.split(";");

                Vare newItem = new Vare(
                        p[0].trim(),                        // String id
                        p[1].split(",")[0].trim(),    // String name
                        LocalDate.parse(p[2]),              // localDate priceDate
                        Double.parseDouble(p[3]),           // double price
                        Double.parseDouble(p[5]),           // quantity
                        p[6]                                // String unit
                );
                Varer.add(newItem);

            }
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName);
        }
        return Varer;
    }
}