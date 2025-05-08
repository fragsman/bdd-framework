package steps;

import POM.HeaderBar;
import POM.MainPage;
import io.cucumber.java.en.Given;
import selenium.BaseTest;

public class MainPageSteps {

    BaseTest baseTest;

    public MainPageSteps(BaseTest baseTest){
        this.baseTest = baseTest;
    }

    @Given("user selects the {string} link")
    public void userSelectsTheLink(String link){
        MainPage mainPage = new MainPage(baseTest.getDriver());
        mainPage.clickOnSuperiorLink(link);
    }

    @Given("user enters to cart details")
    public void user_enters_to_cart_details() {
        HeaderBar headerBar = new HeaderBar(baseTest.getDriver());
        headerBar.enterToCart();
    }
}
