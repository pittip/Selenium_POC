package stepDefinitions;

import cucumber.TestContext;
import pageObjects.ABTestingPage;

public class ABTestingSteps {
    private ABTestingPage abTestingPage;
    private TestContext testContext;

    public ABTestingSteps(TestContext context){
        testContext = context;
        abTestingPage = testContext.getPageObjectManager().getABTestingPage();
    }

}
