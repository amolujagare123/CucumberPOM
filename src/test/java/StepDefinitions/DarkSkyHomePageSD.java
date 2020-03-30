package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ConfigReader;

public class DarkSkyHomePageSD {


    @Given("I am on Darksky Home Page")
    public void i_am_on_Darksky_Home_Page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I verify Home page");
        ConfigReader configReader = new ConfigReader();
		/*System.setProperty("webdriver.chrome.driver",
				configReader.getChromeDriverPath());*/
        WebDriverManager.chromedriver().setup();
WebDriver
        driver = new ChromeDriver();
    }

    @Then("I verify current temp is not greater or less then temps from daily timeline")
    public void i_verify_current_temp_is_not_greater_or_less_then_temps_from_daily_timeline() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I verify current temp is");
    }
}
