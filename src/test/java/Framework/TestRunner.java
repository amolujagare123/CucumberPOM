package Framework;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

        features="Features",

         tags="@VerifyiSuiteHotel",
        plugin={"pretty","html:target/cucumber","json:target/cucumber.json",
                "junit:target/cuckes.xml"},

        glue="StepDefinitions"


)
public class TestRunner {
}
