package reporting;

import static com.vimalselvam.cucumber.listener.Reporter.*;
import static managers.WebDriverManager.getBrowserDetails;

public class Reports {

    public static void writeInfoToReport(){
        loadXMLConfig("Config/report.xml");
        setSystemInfo("Executed By", System.getProperty("user.name"));
        setSystemInfo("Browser Name", getBrowserDetails().get(0).toUpperCase());
        setSystemInfo("Browser Version", getBrowserDetails().get(1).toUpperCase());
        setSystemInfo("Browser Platform", getBrowserDetails().get(2).toUpperCase());
        setSystemInfo("Operating System Name", System.getProperty("os.name"));
        setSystemInfo("Operating System Version", System.getProperty("os.version"));
        setSystemInfo("Operating System Architecture", System.getProperty("os.arch"));
        setTestRunnerOutput("My work is my baby!!!");
    }

    public static void logStep(String stepName){
        addStepLog("<i>&nbsp;&nbsp;&nbsp;&nbsp;* " + stepName + "</i>");
    }
}
