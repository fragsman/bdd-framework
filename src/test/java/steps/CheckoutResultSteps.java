package steps;

import POM.CheckoutPage;
import POM.CheckoutResults;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import selenium.BaseTest;

public class CheckoutResultSteps {

    private BaseTest baseTest;

    public CheckoutResultSteps(BaseTest baseTest){
        this.baseTest = baseTest;
    }

    @When("user places the order")
    public void user_places_the_order() {
        CheckoutPage checkoutPage = new CheckoutPage(baseTest.getDriver());
        checkoutPage.placeOrder();
    }
    @Then("checkout notice should display {string}")
    public void checkout_notice_should_display(String expected) {
        CheckoutResults checkoutResults = new CheckoutResults(baseTest.getDriver());
        Assert.assertEquals(checkoutResults.getCheckoutNotice(), expected,"Check that checkout message is correct");
    }
}
