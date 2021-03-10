package globedr.selenium.configuration;

import globedr.selenium.constants.FilePath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SysConfig {

    private static Properties getConfig() {

        Properties system = new Properties();
        InputStream filePath = null;
        try {
            filePath = new FileInputStream(FilePath.SYSTEM_FILE);
            system.load(filePath);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return system;
    }

    public static String getProperty(String key){
        return getConfig().getProperty(key);
    }

    public static int getInt(String key){
        System.out.println("!!! " + Integer.parseInt(getConfig().getProperty(key)));
        return Integer.parseInt(getConfig().getProperty(key));
    }

    public static long getTimeOutElement(){
        return Long.parseLong(getProperty("element.timeout"));
    }


}
