package steps;

import POM.WomenPage;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import selenium.BaseTest;

public class WomenPageSteps {

    BaseTest baseTest;

    public WomenPageSteps(BaseTest baseTest){
        this.baseTest = baseTest;
    }

    @Then("user should see in {string} in page title and {string} in current navigation page")
    public void userShouldSeeInInPageTitleAndInCurrentNavigationPage(String txtInPageTitle, String txtInNav) {
        WomenPage womenPage = new WomenPage(baseTest.getDriver());

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(womenPage.getPageTitle(),txtInPageTitle,"Check title for Women page:");
        sa.assertEquals(womenPage.getCurrentPageInNav(),txtInNav,"Check navigation tree text for Women page:");
        sa.assertAll();
    }
}
