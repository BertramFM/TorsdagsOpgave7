package util;

import model.Vare;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public List<Vare> readFile(String fileName) throws IOException, FileNotFoundException {
        List<Vare> Varer = new ArrayList<>();

        try  (BufferedReader read = new BufferedReader(new FileReader(fileName))) {
            String line;
            read.readLine(); // header skip

            while ((line = read.readLine()) != null) {
                String[] p = line.split(";");

                Vare newItem = new Vare(
                        p[0],                       // String id
                        p[1],                       // String name
                        LocalDate.parse(p[2]),      // localDate priceDate
                        Double.parseDouble(p[3]),   // double price
                        Integer.parseInt(p[4]),     // quantity
                        p[5]                        // String unit
                );
                Varer.add(newItem);

            }
        }
        return Varer;
    }
}