package cowd.core;

import cowd.properties.Settings;
import cowd.utils.L4j;
import cowd.utils.constants.Constants;
import org.apache.commons.cli.*;

public class CLI {

    private long optionValue;
    private String[] args;

    public CLI(String[] args){
        this.args = args;
        this.parserArgs();
    }

    private void parserArgs(){

        L4j.getL4j().debug("Parsing args whit apache cli");
        CommandLineParser CLIParser = new DefaultParser();

        Options options = new Options();
        options.addOption(Constants.secondsOptionShort, Constants.secondsOption, true, "Mooing every seconds");
        options.addOption(Constants.helpOptionShort, Constants.helpOption, false, "Show this help");

        try {
            CommandLine commandLine = CLIParser.parse(options, this.args);
            if(commandLine.hasOption(Constants.helpOptionShort)) {
                HelpFormatter helpFormatter = new HelpFormatter();
                helpFormatter.printHelp("Cowd", options);
                this.optionValue = -1;
            } else if(commandLine.hasOption(Constants.secondsOptionShort)){
                this.optionValue = Long.valueOf(commandLine.getOptionValue("s"));
            }

            if(this.getOptionValue() == 0) {
                this.optionValue = Long.valueOf(Settings.propertie().getElapsedInSeconds());
            }
        } catch (ParseException e) {
            L4j.getL4j().error("Command line parser exception: ", e);

        } catch (NumberFormatException n) {
            this.optionValue = -1;
            L4j.getL4j().error("Incorrect option format (options) : ", n);
        }
        L4j.getL4j().debug("OptionValue " + this.optionValue);
    }

    public long getOptionValue() {
        return optionValue;
    }

}
