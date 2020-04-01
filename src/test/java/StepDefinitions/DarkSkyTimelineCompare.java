package StepDefinitions;

import Framework.WebPages.DarkSkyPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;

public class DarkSkyTimelineCompare {

DarkSkyPage darkSkyPage = new DarkSkyPage();

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented()
    {
        ArrayList<Integer> myList = darkSkyPage.getTimelineList() ;
        ArrayList<Integer> myListDiff = new ArrayList<>();

        for(int i=0;i<myList.size()-1;i++)
        {
            int time1 = myList.get(i);
            int time2 = myList.get(i+1);

            if(time2>time1)
            myListDiff.add(time2-time1);

            if(time1>time2)
                myListDiff.add((time2+12) - time1);

        }

        System.out.println(myListDiff);

        boolean actual = Collections.frequency(myListDiff, 2) == myListDiff.size();

        Assert.assertTrue(actual,"test is failed");

       //s System.out.println(myList);

    }
}
