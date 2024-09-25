package rjmavendemo.resources;
import java.io.InputStream;
import java.util.Properties;

public class ResourceLoaderExample {

    public static void main(String[] args) {
        // Load resource using class loader
        try (InputStream input = ResourceLoaderExample.class.getClassLoader().getResourceAsStream("application.properties")) {

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            } 

            // Load a properties file from classpath
            Properties prop = new Properties();
            prop.load(input);

            // Get the property value
            System.out.println("app.version: " + prop.getProperty("app.version"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
