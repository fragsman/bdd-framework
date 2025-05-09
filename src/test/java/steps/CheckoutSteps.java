package steps;

import POJO.test.BillingAddress;
import POM.CheckoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import selenium.BaseTest;
import utils.JacksonUtil;

public class CheckoutSteps {

    BaseTest baseTest;

    public CheckoutSteps(BaseTest baseTest){
        this.baseTest = baseTest;
    }

    @When("user sets the billing address")
    public void user_sets_the_billing_address() {
        BillingAddress billingAddress = JacksonUtil.deserializeJson("billingAddress.json", BillingAddress.class);

        CheckoutPage checkoutPage = new CheckoutPage(baseTest.getDriver());
        checkoutPage.setBillingAddress(billingAddress);
    }

    @When("user selects the country in position {int}")
    public void user_selects_the_country_in_position(int position){
        CheckoutPage checkoutPage = new CheckoutPage(baseTest.getDriver());
        checkoutPage.selectNthCountry(position);
    }

    @Then("country selected in checkout should be {string}")
    public void country_selected_in_checkout_should_be(String expectedCountry){
        CheckoutPage checkoutPage = new CheckoutPage(baseTest.getDriver());
        String currentCountry = checkoutPage.getCurrentSelectedCountry();
        Assert.assertEquals(currentCountry,expectedCountry,"selected country does not match the expected:");
    }
}
