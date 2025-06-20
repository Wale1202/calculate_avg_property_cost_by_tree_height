import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class TreeDataParserTest {

    @Test
    public void testParseStreets() throws Exception {
        TreeDataParser parser = new TreeDataParser();
        File jsonFile = new File("dublin-trees.json");

        Set<String> shortStreets = parser.parseStreets(jsonFile, "short");

        assertTrue(shortStreets.contains("abbey drive"), "Should contain 'abbey drive'");
        assertFalse(shortStreets.contains("temple gardens"), "Should not contain 'temple gardens'");
    }
}
