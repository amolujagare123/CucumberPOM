package StepDefinitions;

import Framework.WebPages.DarkSkyAPIPage;
import Framework.WebPages.DarkSkyLoginPage;
import Framework.WebPages.DarkSkyPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DarkSkyLoginSD {
    static WebDriver driver = SharedSD.getDriver();
    DarkSkyPage darkSkyPage = new DarkSkyPage();
    DarkSkyAPIPage darkSkyAPIPage = new DarkSkyAPIPage();
    DarkSkyLoginPage darkSkyLoginPage = new DarkSkyLoginPage();

    @Given("^I am on the darksky Login page$")
    public void i_am_on_the_darksky_login_page() throws Throwable {

        darkSkyPage.clickDarkSkyAPILink();
        darkSkyAPIPage.clickLoginLink();



    }

    @When("^I click on Login button$")
    public void i_click_on_login_button() throws Throwable {
        darkSkyLoginPage.clickLoginButton();
    }

    @Then("^I verify I am on Login page by asserting Login page title$")
    public void i_verify_i_am_on_login_page_by_asserting_login_page_title() throws Throwable {
       String extected ="Dark Sky API: Log In";
       String actual = driver.getTitle();

        Assert.assertEquals(actual,extected,"we are not on login page");
    }

}
