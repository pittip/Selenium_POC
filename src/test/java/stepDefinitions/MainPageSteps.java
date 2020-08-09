package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import pageObjects.MainPage;

public class MainPageSteps {

    private MainPage mainPage;
    private TestContext testContext;

    public MainPageSteps(TestContext context){
        testContext = context;
        mainPage = testContext.getPageObjectManager().getMainPage();
    }

    @Given("^I click on A/B Testing link$")
    public void clickOnABTestingLink(){
        mainPage.clickOnABLink();
    }

    @Given("^I click on Add/Remove Elements link$")
    public void clickOnAddRemoveElementsLink(){
        mainPage.clickOnAddRemoveElementsLink();
    }
}
