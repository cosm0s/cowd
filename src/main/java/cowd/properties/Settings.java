package cowd.properties;

import cowd.utils.constants.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {

    private static Settings instance;

    private String elapsedInSeconds;

    private String appName;
    private String l4jPattern;
    private String l4jGetLogger;

    private Settings() {
    }

    public static synchronized Settings propertie() {
        if (instance == null) {
            instance = new Settings();
            instance.readBaseProperties();
        }
        return instance;
    }


    private static void readBaseProperties() {
        FileInputStream fileProperties;
        try {
            fileProperties = new FileInputStream(Constants.COWD_PROPERTIES_PATH);
            Properties confProperties = new Properties();
            confProperties.load(fileProperties);
            instance.setAppName(confProperties.getProperty("appName"));
            instance.setL4jPattern(confProperties.getProperty("l4jPattern"));
            instance.setL4jGetLogger(confProperties.getProperty("l4jgetLogger"));
            instance.setElapsedInSeconds(confProperties.getProperty("seconds_elapsed"));
            fileProperties.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getElapsedInSeconds() {
        return elapsedInSeconds;
    }

    public void setElapsedInSeconds(String elapsedInSeconds) {
        this.elapsedInSeconds = elapsedInSeconds;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getL4jPattern() {
        return l4jPattern;
    }

    public void setL4jPattern(String l4jPattern) {
        this.l4jPattern = l4jPattern;
    }

    public String getL4jGetLogger() {
        return l4jGetLogger;
    }

    public void setL4jGetLogger(String l4jGetLogger) {
        this.l4jGetLogger = l4jGetLogger;
    }

}
