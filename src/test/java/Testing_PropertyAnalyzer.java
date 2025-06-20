import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
public class Testing_PropertyAnalyzer {
    @Test
    public void testCalculateAverage() {
        PropertyAnalyzer analyzer = new PropertyAnalyzer();

        Set<String> jsonStreets = new HashSet<>();
        jsonStreets.add("sample street");

        Map<String, List<Double>> propertyData = new HashMap<>();
        propertyData.put("sample street", Arrays.asList(100000.0, 200000.0));

        double avg = analyzer.calculateAverage(jsonStreets, propertyData);

        assertEquals(150000.0, avg, 0.01);
    }
}
