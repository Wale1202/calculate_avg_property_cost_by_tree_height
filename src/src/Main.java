import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        TreeDataParser treeParser = new TreeDataParser();
        PropertyDataLoader dataLoader = new PropertyDataLoader();
        PropertyAnalyzer analyzer = new PropertyAnalyzer();

        File jsonFile = new File("dublin-trees.json");
        String csvFile = "dublin-property.csv";

        Set<String> shortStreets = treeParser.parseStreets(jsonFile, "short");
        Set<String> tallStreets = treeParser.parseStreets(jsonFile, "tall");
        Map<String, List<Double>> propertyData = dataLoader.loadPropertyData(csvFile);

        double avgShort = analyzer.calculateAverage(shortStreets, propertyData);
        double avgTall = analyzer.calculateAverage(tallStreets, propertyData);

       // System.out.println("Short Streets: " + shortStreets);
       // System.out.println("Tall Streets: " + tallStreets);



        System.out.println("Average price (Short Tree Streets): €" + avgShort);
        System.out.println("Average price (Tall Tree Streets): €" + avgTall);
    }
}
