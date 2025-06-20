import java.util.List;
import java.util.Map;
import java.util.Set;


public class PropertyAnalyzer {

    public double calculateAverage(Set<String> targetStreets, Map<String, List<Double>> propertyData) {
        double total = 0;
        int count = 0;

        for (String csvStreet : propertyData.keySet()) {
            String normalizedCsvStreet = csvStreet.replaceAll("[^a-zA-Z ]", "").toLowerCase().trim();
            for (String jsonStreet : targetStreets) {
                String normalizedJsonStreet = jsonStreet.replaceAll("[^a-zA-Z ]", "").toLowerCase().trim();
                if (normalizedCsvStreet.contains(normalizedJsonStreet)) { // Loose match
                    System.out.println("MATCH FOUND: CSV = '" + csvStreet + "' JSON = '" + jsonStreet + "'");
                    List<Double> prices = propertyData.get(csvStreet);
                    if (prices != null) {
                        for (double price : prices) {
                            total += price;
                            count++;
                        }
                    }
                    break; // its to avoid double-counting
                }
            }
        }
        return count > 0 ? total / count : 0;
    }
}
