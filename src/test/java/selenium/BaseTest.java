package selenium;

import POM.BasePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import utils.DriverManager;
import utils.Logger;

public class BaseTest{

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected DriverManager driverManager;

    //This won't run for those scenarios tagged as non_browser_tests as they don't need a driver
    @Before("not @non_browser_tests")
    public void beforeScenario(Scenario scenario){
        Logger.Info("Before: Creating driver, opening browser and navigating to homepage");
        driverManager = new DriverManager();
        driver.set(driverManager.getDriver());
        BasePage basePage = new BasePage(getDriver());
        basePage.navigateToMainPage();
    }

    //This won't run for those scenarios tagged as non_browser_tests as they don't need a driver
    @After("not @non_browser_tests")
    public void afterScenario(){
        Logger.Info("After: Closing driver");
        driver.get().quit();
        driver.remove();
    }
    
    public WebDriver getDriver() {
        return driver.get();
    }
}
