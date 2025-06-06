package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Interactor;
import utils.Logger;

public class HeaderBar extends BasePage{
    private final By cartIcon = By.xpath("//div[@id='ast-desktop-header']//div[@class='ast-cart-menu-wrap']");
    private final By cartIconCount = By.xpath("//div[@id='ast-desktop-header']//div[@class='ast-cart-menu-wrap']/span");

    public HeaderBar(WebDriver driver) {
        super(driver);
    }

    public void enterToCart() {
        driver.get("https://askomdch.com/cart/");
    }

    public int getCurrentItemsInCart(){
        String cartText = Interactor.findElement(driver, cartIconCount).getText();
        cartText.replace(" ","");
        return Integer.parseInt(cartText);
    }
}
