import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class PropertyDataLoader {

    public Map<String, List<Double>> loadPropertyData(String csvFile) throws Exception {
        Map<String, List<Double>> data = new HashMap<>();

        try (Reader reader = new FileReader(csvFile);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            for (CSVRecord record : csvParser) {
                String street = record.get("Street Name").trim().toLowerCase();
                String priceStr = record.get("Price").trim();

                // Debug csv:
               // System.out.println("Parsed CSV Street: " + street + " | Price: " + priceStr);

                // Clean price:
                priceStr = priceStr.replaceAll("[^0-9.]", "");
                int firstDot = priceStr.indexOf('.');
                if (firstDot != -1) {
                    priceStr = priceStr.substring(0, firstDot + 1) +
                            priceStr.substring(firstDot + 1).replaceAll("\\.", "");
                }

                if (!priceStr.isEmpty()) {
                    try {
                        double price = Double.parseDouble(priceStr);
                        data.computeIfAbsent(street, k -> new ArrayList<>()).add(price);
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping invalid price: " + priceStr);
                    }
                }
            }
        }

        return data;
    }
}
