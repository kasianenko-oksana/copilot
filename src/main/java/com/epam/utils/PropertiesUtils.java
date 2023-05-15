package com.epam.utils;

import com.epam.utils.exception.FileException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    public static String readPropertyFromFile(String fileName, String propertyName) {

        try (InputStream input = PropertiesUtils.class.getClassLoader().getResourceAsStream(fileName)) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty(propertyName);
        } catch (IOException ex) {
            throw new FileException(ex.getMessage());
        }
    }
}

