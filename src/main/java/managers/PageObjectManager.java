package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.ABTestingPage;
import pageObjects.MainPage;

public class PageObjectManager {

    private WebDriver driver;
    private MainPage mainPage;
    private ABTestingPage abTestingPage;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public MainPage getMainPage(){
        return (mainPage == null) ? new MainPage(driver) : mainPage;
    }

    public ABTestingPage getABTestingPage(){
        return (abTestingPage == null) ? new ABTestingPage(driver) : abTestingPage;
    }
}
