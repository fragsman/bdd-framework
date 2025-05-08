package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "selenium"}, //in selenium package we have the BaseTest which contains Cucumber Hooks
        plugin = {"html:target/results/TestReport.html"},
        //tags = "@non_browser_tests", //filter by tags
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    // No code needed here
}