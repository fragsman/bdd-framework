package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import selenium.BaseTest;
import support.MyContext;

public class NumericTestsSteps{

    private MyContext context;

    public NumericTestsSteps(BaseTest baseTest){
        context = MyContext.getInstance();
    }

    @Given("the user {string} inputs its {int}")
    public void theUserInputsItsAge(String name, Integer age) {
        boolean allowed = age > 18;
        context.setData("userAllowed",allowed);
        context.setData("userName",name);
        context.setData("userAge",age);
    }


}
