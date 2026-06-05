package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
            static
            {
                try
                {
                    FileInputStream file=new FileInputStream("src/test/resources/config.properties");
                    properties=new Properties();
                    properties.load(file);
                    file.close();

                } catch (FileNotFoundException e) {
                    System.out.println("File Not found");
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    System.out.println("Config File not found");
                    throw new RuntimeException(e);
                }
            }
            public static String getProperty(String key){
                return properties.getProperty(key);
            }
}
