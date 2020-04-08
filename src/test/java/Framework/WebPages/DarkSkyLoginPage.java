package Framework.WebPages;

import org.openqa.selenium.By;

public class DarkSkyLoginPage extends BasePage {

    By loginButton = By.xpath("//button[contains(text(),'Log in')]");

    public void clickLoginButton()
    {
        clickOn(loginButton);
    }
}
