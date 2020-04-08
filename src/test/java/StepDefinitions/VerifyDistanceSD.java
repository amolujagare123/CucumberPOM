package StepDefinitions;

import Framework.WebPages.HotelsHomePage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;

public class VerifyDistanceSD {

    HotelsHomePage hotelsHomePage = new HotelsHomePage();

    @Then("^I verify system displays all hotels within 10 miles radius of airport$")
    public void i_verify_system_displays_all_hotels_within_10_miles_radius_of_airport() throws Throwable {

        ArrayList<Double> distList =  hotelsHomePage.getDistanceList();
        System.out.println(distList);

        ArrayList<Double> greaterDistList = new ArrayList<>();

        boolean flag = true ;

        for(int i=0;i<distList.size();i++) {
            if (distList.get(i)>16.09) // 10 miles = 16.09 km
            {
                flag = false;
                greaterDistList.add(distList.get(i));
            }
        }

        Assert.assertTrue(flag,"all distances are not within 10 miles"+greaterDistList);
    }


    @Then("^I verify iSuite Hotel is within radius$")
    public void i_verify_isuite_hotel_is_within_radius() throws Throwable {

        ArrayList<String> hotelsList = hotelsHomePage.getHotelsnames();
        System.out.println(hotelsList);

        boolean flag = false;

        for(int i =0; i<hotelsList.size();i++)
        {
            if(hotelsList.get(i).equals("iSuite Hotel"))
            {
                flag = true;
            }

        }

        Assert.assertTrue(flag,"There is no hotel with the name 'iSuite Hotel'");
    }

}
