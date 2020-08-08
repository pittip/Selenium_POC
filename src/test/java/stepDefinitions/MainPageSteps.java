package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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

    @Then("^I check that header is displayed as expected$")
    public void checkHeader(){

    }
}
