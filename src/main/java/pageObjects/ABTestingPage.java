package pageObjects;

import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ABTestingPage {

    private final WebDriver driver = new WebDriverManager().getDriver();

    @FindBy(css = "h3")
    private WebElement headerABTestingPage;

    @FindBy(css = "p")
    private WebElement textABTestingParagraph;

    public ABTestingPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void checkABHeader(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(headerABTestingPage, "A/B Test Variation 1"));
    }

    public void checkABTestingParagraph(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(textABTestingParagraph, "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through)."));
    }
}
