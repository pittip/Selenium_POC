package managers;

import enums.DriverType;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    protected static WebDriver driver;
    private static DriverType driverType;
    private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";

    public WebDriverManager(){
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
    }

    public WebDriver getDriver(){
        if(driver == null){
            driver = createDriver();
        }
        return driver;
    }

    private WebDriver createDriver(){
        switch (driverType){
            case FIREFOX:
                System.setProperty(FIREFOX_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
                break;
            case CHROME:
                break;
        }
        return driver;
    }

    public static void exitDriver(){
        driver.quit();
    }

    public static ArrayList<String> getBrowserDetails(){
        ArrayList<String> browserDetails = new ArrayList<>();

        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        browserDetails.add(cap.getBrowserName());
        browserDetails.add(cap.getVersion());
        browserDetails.add(cap.getPlatform().toString());

        return browserDetails;
    }
}
