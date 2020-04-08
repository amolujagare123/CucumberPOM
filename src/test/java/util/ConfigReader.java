package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigReader {

    private String url;


    public ConfigReader() throws IOException {

        Properties prop = new Properties();
        InputStream input
                = new FileInputStream("C:\\Users\\PC\\IdeaProjects\\CucumberPOM\\Resources\\Config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            this.url = prop.getProperty("url");

    }

    public String getUrl() {

        return url;
    }

   /* public String getChromeDriverPath() {

        return chromeDriverPath;
    }*/

   /* public String getMobilePlatformName() {
        return mobilePlatformName;
    }

    public String getMobileAutomationName() {
        return mobileAutomationName;
    }

    public String getMobileVersion() {
        return mobileVersion;
    }

    public String getMobileDeviceName() {
        return mobileDeviceName;
    }

    public String getMobileAppPath() {
        return mobileAppPath;
    }*/
}
