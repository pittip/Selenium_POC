package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageObjects.AddRemoveElementsPage;

public class AddRemoveElementsSteps {

    private AddRemoveElementsPage addRemoveElementsPage;

    public AddRemoveElementsSteps(TestContext context){
        addRemoveElementsPage = context.getPageObjectManager().getAddRemoveElementsPage();
    }

    @Then("^I check that AddRemoveElements page header is displayed as expected$")
    public void checkHeader(){
        addRemoveElementsPage.checkHeader();
    }

    @And("^I check that Delete button appears when Add Element button is clicked$")
    public void checkDeleteButtonAppearance(){
        addRemoveElementsPage.checkDeleteButtonAppearance();
    }
}
