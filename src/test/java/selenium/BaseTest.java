package selenium;

import POM.BasePage;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.Logger;

public class BaseTest{

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected DriverManager driverManager;

    @BeforeAll
    public static void beforeAll(){
        Logger.initLogFile();
        Logger.Info("onStart: Init log file");
    }

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
    public void afterScenario(Scenario scenario){
        Logger.Info("After: Closing driver and taking screenshot (if test failed)");
        attachScreenshotToReport(scenario);
        driver.get().quit();
        driver.remove();
    }

    private void attachScreenshotToReport(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName().replace(" ","_"));
        }
    }

    @AfterAll
    public static void afterAll(){
        Logger.Info("onFinish: Closing log writer");
        Logger.closeWriter();
    }
    
    public WebDriver getDriver() {
        return driver.get();
    }
}
