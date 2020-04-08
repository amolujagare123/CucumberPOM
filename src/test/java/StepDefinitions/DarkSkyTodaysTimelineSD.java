package StepDefinitions;

import Framework.WebPages.DarkSkyPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;

public class DarkSkyTodaysTimelineSD {

    DarkSkyPage darkSkyPage = new DarkSkyPage();


    @When("^I expand todays timeline$")
    public void i_expand_todays_timeline() throws Throwable {
       darkSkyPage.clickTodaysTimLine();
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void i_verify_lowest_and_highest_temp_is_displayed_correctly() throws Throwable {
        ArrayList<String> expected = darkSkyPage.todaysTempListMinMax();
        ArrayList<String> actual = darkSkyPage.timelineTempListMinMax();

        Assert.assertEquals(actual,expected,"lowest & highest temperatures are not displayed correctly ");


    }

}
