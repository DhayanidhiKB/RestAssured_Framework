package org.restAssured.frameworkConstants;

import lombok.Getter;

public class FilePaths {

    private static @Getter
    final String RequestJsonPath = System.getProperty("user.dir") + "/src/test/resources/JsonFiles/";
    private static @Getter
    final String ResponseJsonPath = System.getProperty("user.dir") + "/src/test/resources/OutputJsonResponse/";
    private static @Getter
    final String PropertyFilePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
}
