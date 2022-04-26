package tests.utils;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfig {
    public static String propertyFile ="src/test/resources/config.properties";
    public static Properties prop = new Properties();

    public static Properties readProperties() throws Exception{
        InputStream input = new FileInputStream(propertyFile);
        prop.load(input);
        return prop;


    }
}
