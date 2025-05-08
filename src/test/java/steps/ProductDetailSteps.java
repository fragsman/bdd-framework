package steps;

import POM.ProductDetailPage;
import io.cucumber.java.en.Given;
import selenium.BaseTest;

public class ProductDetailSteps {

    private BaseTest baseTest;

    public ProductDetailSteps(BaseTest baseTest){
        this.baseTest = baseTest;
    }

    @Given("user adds the product to the cart")
    public void user_adds_the_product_to_the_cart() {
        ProductDetailPage productDetailPage = new ProductDetailPage(baseTest.getDriver());
        productDetailPage.clickAddToCartButton();
    }
}
