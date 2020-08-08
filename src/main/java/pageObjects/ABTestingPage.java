package pageObjects;

import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ABTestingPage {

    private WebDriver driver = new WebDriverManager().getDriver();

    @FindBy(css = "h3")
    private WebElement headerABTestingPage;

    public ABTestingPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


}
