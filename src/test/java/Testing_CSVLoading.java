import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
public class Testing_CSVLoading {
    @Test
    public void testLoadPropertyData() throws Exception {
        PropertyDataLoader loader = new PropertyDataLoader();
        Map<String, List<Double>> data = loader.loadPropertyData("InventoryLot_v4.csv");

        assertTrue(data.containsKey("sample street"));
        assertEquals(200000.0, data.get("sample street").get(0), 0.01);
    }
}
