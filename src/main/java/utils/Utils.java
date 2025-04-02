package utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Properties;

public class Utils {

    public static String getPropertyValue(String filePath, String key) {
        Properties properties = new Properties();
        try (InputStream in = Utils.class.getClassLoader().getResourceAsStream((filePath))) {
            if (in == null) {
                throw new RuntimeException("file not found: " + filePath);
            }
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file: " + filePath, e);
        }

        return properties.getProperty(key);
    }

}
