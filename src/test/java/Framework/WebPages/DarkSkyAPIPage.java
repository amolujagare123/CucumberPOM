package Framework.WebPages;

import org.openqa.selenium.By;

public class DarkSkyAPIPage extends BasePage {

    By loginLink = By.xpath("//a[@class='button']");

    public void clickLoginLink()
    {
        clickOn(loginLink);
    }
}
