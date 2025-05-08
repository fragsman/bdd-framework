package steps;

import POM.MenPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import selenium.BaseTest;

public class MenStepsPage {

    BaseTest baseTest;

    public MenStepsPage(BaseTest baseTest){
        this.baseTest = baseTest;
    }

    @And("user performs a special search for {string}")
    public void userPerformsASpecialSearchFor(String search) {
        MenPage menPage = new MenPage(baseTest.getDriver());
        menPage.specialSearch();
    }

    @Then("user should see in the search results {string}")
    public void userShouldSeeInTheSearchResults(String search) {

        System.out.println("search is: " +search);
        MenPage menPage = new MenPage(baseTest.getDriver());
        System.out.println("actual is: " +menPage.getSearchResultsTitle());

        Assert.assertEquals(menPage.getSearchResultsTitle(),"Search results: "+search,"Verify the first letter is capital");
    }
}
