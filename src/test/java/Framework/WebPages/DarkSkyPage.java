package Framework.WebPages;

import org.openqa.selenium.By;

public class DarkSkyPage extends BasePage {

    By currTemp = By.xpath("//span[@class='summary swap']");
    By temOnTimeline = By.xpath("//span[@class='first']//span");

    public String getCurrtemp()
    {
       String tempText =  getTextFromElement(currTemp); //45˚ Overcast.

        return tempText.split("˚")[0];

    }

    public String getTempTimeline()
    {
        String tempTimelineText = getTextFromElement(temOnTimeline); //45°
        return tempTimelineText.split("°")[0];
    }
}
