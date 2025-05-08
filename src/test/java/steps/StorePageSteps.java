package steps;

import POM.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import selenium.BaseTest;

public class StorePageSteps {
    BaseTest baseTest;

    public StorePageSteps(BaseTest baseTest){
        this.baseTest = baseTest;
    }

    @Then("user should see in the search title {string}")
    public void verifySearchTitleShows(String text){
        StorePage storePage = new StorePage(baseTest.getDriver());
        Assert.assertEquals(storePage.getCurrentPageInNav(),text,"Check that Store link leads to a page that contains '"+text+"' on its navigation tree");
    }

    @Given("user selects the first available product")
    public void user_selects_the_first_available_product() {
        StorePage storePage = new StorePage(baseTest.getDriver());
        storePage.clickOnFirstAvailableProduct();
    }
}
