package steps;

import POM.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import selenium.BaseTest;

public class CartSteps {

    private BaseTest baseTest;

    public CartSteps(BaseTest baseTest){
        this.baseTest = baseTest;
    }

    @Given("user selects proceed to checkout")
    public void user_selects_proceed_to_checkout() {
        CartPage cartPage = new CartPage(baseTest.getDriver());
        cartPage.clickOnProceedToCheckout();
    }

    @When("user enters an invalid coupon code {string}")
    public void user_enters_an_invalid_coupon_code(String invalidCode){
        CartPage cartPage = new CartPage(baseTest.getDriver());
        cartPage.enterCouponCode(invalidCode);
    }

    @Then("coupon error should display {string}")
    public void coupon_error_should_display(String errorMessage){
        CartPage cartPage = new CartPage(baseTest.getDriver());
        Assert.assertEquals(cartPage.getCouponErrorResult(),errorMessage,"Check error message due to invalid coupon code");
    }
}
