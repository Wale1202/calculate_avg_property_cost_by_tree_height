import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class TreeDataParser {

    public Set<String> parseStreets(File jsonFile, String type) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(jsonFile);
        JsonNode target = root.get(type);
        Set<String> streets = new HashSet<>();
        collectStreets(target, streets, null);
        return streets;
    }

    private void collectStreets(JsonNode node, Set<String> streets, String possibleStreetName) {
        if (node == null) return;

        if (node.isObject()) {
            Iterator<String> fields = node.fieldNames();
            while (fields.hasNext()) {
                String field = fields.next();
                collectStreets(node.get(field), streets, field);  // Pass key down
            }
        } else if (node.isNumber() && possibleStreetName != null) {
            streets.add(possibleStreetName.toLowerCase());
        }
    }
}
