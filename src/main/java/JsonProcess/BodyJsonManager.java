package JsonProcess;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class BodyJsonManager {
    private static final String BODIES_FILE_PATH = "src/test/resources/JsonBodies/bodiesJson.json";
    private final Map bodies;
    private JsonExtractor jsonExtractor;

    public BodyJsonManager() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonExtractor = new JsonExtractor();
            String jsonContent = new String(Files.readAllBytes(Paths.get(BODIES_FILE_PATH)));
            bodies = mapper.readValue(jsonContent, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Error initializing BodyJsonManager: " + e.getMessage(), e);
        }
    }

    public String buildBodyWithData(String bodyName, Map<String, Object> placeholders) throws Exception {

        String JsonTemplate = jsonExtractor.getBodyJsonTemplate(bodyName);
        if (JsonTemplate==null || JsonTemplate.isEmpty()) {
            throw new IllegalArgumentException("Body not found: " + bodyName);
        }
        for (Map.Entry<String, Object> entry : placeholders.entrySet()) {
            JsonTemplate = JsonTemplate.replace("{{" + entry.getKey() + "}}", entry.getValue().toString());

        }
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(JsonTemplate);
        return objectMapper.writeValueAsString(rootNode);

    }
}
