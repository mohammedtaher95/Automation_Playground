package utilities.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    public static Properties WebConfig;

    public PropertiesManager() {

    }

    public static void initializeProperties() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/main/resources/WebConfigurations.properties");
            WebConfig = new Properties();
            WebConfig.load(fileInputStream);
        } catch (FileNotFoundException e) {
            System.out.println("Property file is not found");
        } catch (IOException e) {
            System.out.println("File isn't readable");
        }
    }
}
