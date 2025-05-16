package selenium;

import POM.BasePage;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import support.MyContext;
import utils.DriverManager;
import utils.Logger;

import java.io.File;
import java.io.IOException;

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

    //This won't run for those scenarios tagged as non_browser_tests as they don't need a driver
    @AfterStep("not @non_browser_tests")
    public void afterStep(Scenario scenario) {
        if(scenario.isFailed()){
            Logger.Info("AfterStep: Test failed, taking screenshot.");

            try{
                File sourcePath=    ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
                byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
                scenario.attach(fileContent, "image/png", scenario.getName());

            }catch(IOException e){
                Logger.Error("Error al capturar screenshot "+e);
            }

        }
    }
    
    public WebDriver getDriver() {
        return driver.get();
    }
}
