package com.school.web.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author jhonny
 */
public class PropertiesUtil {
    private static Properties properties;

    public static Properties getProperties() {
        if (properties == null) {
            try {
                InputStream is = PropertiesUtil.class.getResourceAsStream("/SchoolMessages.properties");
                properties = new Properties();
                properties.load(is);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return properties;
    }

    public static Properties getPropertiesByPropertiesFile(String propertiesFile) {
        Properties properties = new Properties();

        try {
            InputStream is = PropertiesUtil.class.getResourceAsStream(propertiesFile);

            properties.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
