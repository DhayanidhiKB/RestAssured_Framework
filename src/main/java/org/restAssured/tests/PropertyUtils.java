package org.restAssured.tests;

import org.restAssured.frameworkConstants.FilePaths;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtils {

    private static Properties prop = new Properties();
    private static Map<String, String> values = new HashMap<>();

    static {
        try (FileInputStream fileInputStream = new FileInputStream(FilePaths.getPropertyFilePath())) {
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        prop.entrySet().forEach(e -> values.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));
    }

    public static String getValue(String key) {
        return values.get(key);
    }

}
