package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public Properties init_prop(){
        properties = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/config/config.properties");
            properties.load(ip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
