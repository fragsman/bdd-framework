package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.EnvironmentManager;
import utils.Interactor;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected final By overlayBlockers = By.cssSelector("div.blockUI.blockOverlay");

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToMainPage(){
        driver.get(EnvironmentManager.getInstance().getBaseUrl());
    }

    public void waitForBlockingOverlays(){
        Interactor.waitForBlockingOverlays(driver);
    }
}
