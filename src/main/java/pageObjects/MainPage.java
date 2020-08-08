package pageObjects;

import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private final WebDriver driver = new WebDriverManager().getDriver();

    @FindBy(css = "a[href*='abtest']")
    private WebElement linkABTest;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clickOnABLink(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(linkABTest)).click();
    }

}
