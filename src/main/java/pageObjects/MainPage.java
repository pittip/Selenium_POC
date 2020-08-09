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

    @FindBy(css = "a[href*='add_remove_elements']")
    private WebElement linkAddRemoveElements;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clickOnABLink(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(linkABTest)).click();
    }

    public void clickOnAddRemoveElementsLink(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(linkAddRemoveElements)).click();
    }

}
