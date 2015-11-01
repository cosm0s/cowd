package cowd.utils;

import cowd.properties.Settings;
import org.apache.log4j.*;

public class L4j {

    private static final L4j instance;
    static Logger log;

    static {
        instance = new L4j();
    }

    private L4j(){
        ConsoleAppender console = new ConsoleAppender();
        console.setName(Settings.propertie().getAppName());
        console.setLayout(new PatternLayout(Settings.propertie().getL4jPattern()));
        console.setThreshold(Level.INFO);
        console.activateOptions();
        Logger.getRootLogger().addAppender(console);
        log = Logger.getLogger(Settings.propertie().getL4jGetLogger());
    }

    public static L4j getL4j() {
        return instance;
    }

    public void setConfig(String filename, String level) {
        FileAppender fileAppender = new FileAppender();
        fileAppender.setName(Settings.propertie().getAppName());
        fileAppender.setFile(filename);
        fileAppender.setLayout(new PatternLayout(Settings.propertie().getL4jPattern()));
        fileAppender.setThreshold(Level.toLevel(level));
        fileAppender.setAppend(true);
        fileAppender.activateOptions();
        Logger.getRootLogger().getLoggerRepository().resetConfiguration();
        Logger.getRootLogger().addAppender(fileAppender);
        log = Logger.getLogger(Settings.propertie().getAppName());
    }

    public void error(String msg) {
        if (log.isEnabledFor(Level.ERROR)) {
            log.error(msg);
        }
    }

    public void error(String msg, Throwable t) {
        if (log.isEnabledFor(Level.ERROR)) {
            log.error(msg, t);
        }
    }

    public void debug(String msg) {
        if (log.isDebugEnabled()) {
            log.debug(msg);
        }
    }
}
