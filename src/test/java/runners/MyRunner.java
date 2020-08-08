package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import static managers.WebDriverManager.exitDriver;
import static reporting.Reports.writeInfoToReport;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        tags = {"~@ignore"},
        features = {"src/test/resources"},
        glue = {"stepDefinitions"}
)

public class MyRunner {
    @AfterClass
    public static void runExtentReport(){
        writeInfoToReport();
        exitDriver();
        try {
            Thread.sleep(5000);
            Runtime.getRuntime().exec("firefox target/cucumber-reports/report.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
