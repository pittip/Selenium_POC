package stepDefinitions;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.FileReaderManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    private TestContext testContext;

    public Hooks(TestContext context){
        testContext = context;
    }

    @Before
    public void beforeTests(){
        testContext.getWebDriverManager().getDriver().get(FileReaderManager.getInstance().getConfigReader().getApplicationURL());
    }

    @After
    public void afterTests(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            String screenshotFileName = scenario.getName().replaceAll(" ", "_") + new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            File sourceFile = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
            File destinationPath = new File(System.getProperty("user.dir") + "/target/FailedScenariosScreenshots/" + screenshotFileName + ".png");
            FileUtils.moveFile(sourceFile, destinationPath);
            Reporter.addScreenCaptureFromPath("../FailedScenariosScreenshots/" + screenshotFileName + ".png", "Click to see failure screenshot");
        }
    }
}
