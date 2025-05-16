package steps;

import POJO.test.ContactUs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import selenium.BaseTest;
import support.MyContext;
import utils.DBManager;
import java.util.List;

public class DisabledSteps {

    BaseTest baseTest;
    MyContext context;

    public DisabledSteps(BaseTest baseTest){
        this.baseTest = baseTest;
        context = MyContext.getInstance();
    }

    @Given("user {string} completes the contact us form with {string}")
    public void userCompletesTheContactUsFormWith(String userEmail, String message) {
        context.setData("contactUsEmail",userEmail);
        context.setData("contactUsMsg", message);
        //Selenium code to complete the form with email and message, then submit it
    }

    @Then("information in db should be correct")
    public void informationInDbShouldBeCorrect(){
        String expectedMsg = (String)context.getData("contactUsMsg");
        DBManager dbManager = new DBManager();
        List<ContactUs> contacts = dbManager.getContactUsByEmail((String)context.getData("contactUsEmail"));
        //The user might have sent many messages of contact us. We want the last of these. So we order by date.
        List<ContactUs> orderedContacts = contacts.stream().sorted((c1, c2) -> c1.getDate().compareTo(c2.getDate())).toList();
        //If the order is: newer dates first we use getFirst(), otherwise we use getLast() (or size-1)
        int size = orderedContacts.size();
        Assert.assertEquals(orderedContacts.get(size-1).getMessage(),expectedMsg,"Message was stored in BD correctly");
    }
}
