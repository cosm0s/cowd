package cowd.core;

import cowd.domain.Banner;
import cowd.properties.Settings;
import cowd.utils.L4j;
import cowd.utils.constants.Constants;

public class cowd {

    public static void main(String[] args) {

        L4j.getL4j().debug("Start cowd");
        L4j.getL4j().setConfig(Constants.COWD_LOGS_PATH, Settings.propertie().getL4jGetLogger());

        CLI cli = new CLI(args);

        if(cli.getOptionValue()  > 0 ) {
            Banner banner = new Banner(cli.getOptionValue());
            Mooing mooing = new Mooing(cli.getOptionValue(), System.currentTimeMillis(), banner);
            L4j.getL4j().debug("Start mooing");
            mooing.start();
        } else {
            L4j.getL4j().error("Seconds can't be negative");
        }
        L4j.getL4j().debug("Exit cowd");
    }
}
