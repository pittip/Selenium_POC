package dataProvider;

import enums.DriverType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "configs/Configuration.properties";

    public ConfigFileReader(){
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();

            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration property not found at " + propertyFilePath);
        }
    }

    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath != null){
            return driverPath;
        }
        else {
            throw new RuntimeException("driverPath not specified in Configuration.properties file");
        }
    }

    public long getImplicitlyWait(){
        String implicitlyWait = properties.getProperty("implicitlyWait");

        if(implicitlyWait != null){
            return Long.parseLong(implicitlyWait);
        }
        else {
            throw new RuntimeException("implicitlyWait not specified in Configuration.properties file");
        }
    }

    public String getApplicationURL(){
        String url = properties.getProperty("applicationURL");
        if(url != null){
            return url;
        }
        else {
            throw new RuntimeException("applicationURL not specified in Configuration.properties file");
        }
    }

    public DriverType getBrowser(){
        String browser = properties.getProperty("browser");

        if(browser == null || browser.equals("firefox")){
            return DriverType.FIREFOX;
        }
        else {
            throw new RuntimeException("Browser entries in Configuration.properties is incorrect for " + browser);
        }
    }
}
