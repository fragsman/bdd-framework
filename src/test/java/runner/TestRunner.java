package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "selenium"}, //in selenium package we have the BaseTest which contains Cucumber Hooks
        plugin = {
                "pretty", //generate beauty output in console
                "me.jvt.cucumber.report.PrettyReports:target/results/", //generate cucumber-html-reports
        },
        tags = TagConfigs.all_but_disabled,
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}