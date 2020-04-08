package StepDefinitions;

import Framework.WebPages.HotelsHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class StarRatingsSD {
    HotelsHomePage hotelsHomePage = new HotelsHomePage();


    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen() throws Throwable {

        hotelsHomePage.setDestinationTextBox("mumbai");
        hotelsHomePage.clcickSearchButton();

        SharedSD.getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }

    @When("^I select property class (.+)$")
    public void i_select_property_class(String stars) throws Throwable {
// String star parameter has e.g 5 stars as per defined in feature file

        String rating = stars.split(" ")[0];

        hotelsHomePage.clickStarRatings(rating); // 1,2,3,4,5

    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) throws Throwable {
// 5-star | String stars ->  5 stars
       ArrayList<String> starList =  hotelsHomePage.getStarList();

       String givenStarConverted = stars.split(" ")[0] +"-star";

        System.out.println(starList);
        System.out.println(stars+" "+givenStarConverted);

        boolean result
                = Collections.frequency(starList,givenStarConverted)==starList.size();

        Assert.assertTrue(result,"the webelement list is of different stars");


    }

}
