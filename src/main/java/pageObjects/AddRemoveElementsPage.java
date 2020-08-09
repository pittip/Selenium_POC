package pageObjects;

import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddRemoveElementsPage {

    private final WebDriver driver = new WebDriverManager().getDriver();

    @FindBy(css = "h3")
    private WebElement headerAddRemoveElementsPage;

    @FindBy(xpath = "//button[text()='Add Element']")
    private WebElement buttonAddElement;

    @FindBy(css = "button.added-manually")
    private WebElement buttonDelete;

    public AddRemoveElementsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void checkHeader(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(headerAddRemoveElementsPage, "Add/Remove Elements"));
    }

    public void checkDeleteButtonAppearance(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(buttonAddElement)).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(buttonDelete)).isDisplayed();
    }


}
