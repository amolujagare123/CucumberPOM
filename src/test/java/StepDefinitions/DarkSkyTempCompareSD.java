package StepDefinitions;

import Framework.WebPages.DarkSkyPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DarkSkyTempCompareSD {

    DarkSkyPage darkSkyPage = new DarkSkyPage();

  static WebDriver driver = SharedSD.getDriver();
    @Given("I am on Darksky Home Page")
    public void i_am_on_Darksky_Home_Page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(driver.getTitle(),"Dark Sky - Broadway, New York, NY",
                "We are not on given page");

    }



    @Then("I verify current temp is not greater or less then temps from daily timeline")
    public void i_verify_current_temp_is_not_greater_or_less_then_temps_from_daily_timeline() {

        String expected = darkSkyPage.getCurrtemp();
        System.out.println(expected);
        String actual = darkSkyPage.getTempTimeline();
        System.out.println(actual);


        Assert.assertEquals(actual,expected,"Test is failed");


    }
}
