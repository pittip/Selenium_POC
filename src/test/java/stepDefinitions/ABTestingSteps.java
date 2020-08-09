package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageObjects.ABTestingPage;

public class ABTestingSteps {
    private final ABTestingPage abTestingPage;

    public ABTestingSteps(TestContext context){
        abTestingPage = context.getPageObjectManager().getABTestingPage();
    }

    @Then("^I check that AB header is displayed as expected$")
    public void checkABHeader(){
        abTestingPage.checkABHeader();
    }

    @And("^I check that AB paragraph is displayed as expected$")
    public void checkABParagraph(){
        abTestingPage.checkABTestingParagraph();
    }
}
