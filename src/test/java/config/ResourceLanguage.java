package config;

import com.rest.core.Logger;
import enums.Language;
import globedr.selenium.Assert;
import globedr.selenium.constants.FilePath;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class ResourceLanguage {
    private static ResourceLanguage instance;
    private Properties resourceLanguage;
    private String currentLanguage;

    private ResourceLanguage() {
        try {
            Properties props = new Properties();
            FileInputStream input = new FileInputStream(new File(FilePath.DATA_RESOURCES + "language.properties"));
            props.load(new InputStreamReader(input, Charset.forName("UTF-8")));
            this.resourceLanguage = props;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ResourceLanguage getInstance() {
        if (instance == null) {
            instance = new ResourceLanguage();
        }
        return instance;
    }

    public String translate(String key) {
        String result = null;
        if (getResourceLanguage() != null) {
            String expectedKey = String.format("%s.%s", key.toLowerCase().trim(), getCurrentLanguage().trim());

            result = getResourceLanguage().getProperty(expectedKey);
            if (result == null || result.isEmpty()) {
                if (!getResourceLanguage().stringPropertyNames().stream().anyMatch(k -> k.equalsIgnoreCase(expectedKey))) {
                    Assert.fail(String.format("Not found key language '%s.%s' into resource language", key.toLowerCase().trim(), getCurrentLanguage().trim()));
                }
            }

        } else {
            Assert.fail("Not found resource language");
        }

        return result;
    }

    public void setCurrentLanguage(String language) {

        if (language.equalsIgnoreCase(Language.EN.toString()))
            this.currentLanguage = "en";
        else
            this.currentLanguage = "vn";
    }

    public Properties getResourceLanguage() {
        return resourceLanguage;
    }

    public void setResourceLanguage(Properties resourceLanguage) {
        this.resourceLanguage = resourceLanguage;
    }

    public String getCurrentLanguage() {
        return currentLanguage;
    }
}
