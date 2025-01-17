package org.vw.qa.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ReadPropertyFile {
    private ReadPropertyFile() {

    }

    private static Properties prop = new Properties();

    static {

        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/Configuration/Config.properties");
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getValue(String key) throws Exception {
        String value = "";
        value = prop.getProperty(key);
        if (Objects.isNull(value)) {
            throw new Exception("Property name" + key + "Please check Config.properties");

        }

        return value;

    }

}

