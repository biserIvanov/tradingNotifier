import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by biso on 23.04.17.
 */
public class Runner {

    private static List<String> instrumentsToTrack;
    private static List<String> timeChartsToUse;
    private static List<String> emailNotificationList;
    private static List<String> indicators;

    public static final Logger logger = LoggerFactory.getLogger(Runner.class);


    public static void main(String[] args) {
        logger.info("START");
        handleArguments(args);

        logger.info("END");
    }

    private static void handleArguments(String[] args) {
        handleArgs(args);

        handlePropFile();
    }

    private static void handlePropFile() {
        Properties prop = null;
        try {
            prop = new Properties();
            InputStream in = Runner.class.getResourceAsStream("config.properties");     // loads default properties
            prop.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error: ", e);
        } catch (Exception e) {
            logger.error("Error occurred when getting the properties from the config.properties file! ", e);
            e.printStackTrace();
        }

        if(instrumentsToTrack == null) {
            instrumentsToTrack = Arrays.asList(prop.getProperty("instrumentsToTrack").split(","));
        }
        if(indicators == null) {
            indicators = Arrays.asList(prop.getProperty("indicators").split(","));
        }
        if(timeChartsToUse == null) {
            timeChartsToUse = Arrays.asList(prop.getProperty("timeChartsToUse").split(","));
        }
        if(emailNotificationList == null) {
            emailNotificationList = Arrays.asList(prop.getProperty("emailNotificationList").split(","));
        }
    }

    private static void handleArgs(String[] args) {
        for(String argument: args) {
            if(argument.startsWith("instrumentsToTrack")) {
                argument = argument.substring(argument.indexOf("=") + 1);
                instrumentsToTrack = Arrays.asList(argument.split(","));
            } else if(argument.startsWith("timeChartsToUse")) {
                argument = argument.substring(argument.indexOf("=") + 1);
                timeChartsToUse = Arrays.asList(argument.split(","));
            } else if(argument.startsWith("emailNotificationList")) {
                argument = argument.substring(argument.indexOf("=") + 1);
                emailNotificationList = Arrays.asList(argument.split(","));
            } else if(argument.startsWith("indicators")) {
                argument = argument.substring(argument.indexOf("=") + 1);
                indicators = Arrays.asList(argument.split(","));
            } else {logger.error("Unknown argument passed: " + argument);}
        }
    }
}
