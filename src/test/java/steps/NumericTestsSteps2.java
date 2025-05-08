package steps;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import selenium.BaseTest;
import support.MyContext;

public class NumericTestsSteps2 {

    private MyContext context;

    public NumericTestsSteps2(BaseTest baseTest){
        context = MyContext.getInstance();
    }

    @Then("user is allowed to log into the website")
    public void userIsAllowedToLogIntoTheWebsite() {
        boolean allowed = (boolean)context.getData("userAllowed");
        Integer age = (Integer)context.getData("userAge");
        String name = (String)context.getData("userName");
        Assert.assertTrue(allowed, "The user " + name + " wasn't accepted into the system because it's a minor: " + age);
    }
}
