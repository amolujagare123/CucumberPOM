package Framework.WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class DarkSkyPage extends BasePage {

    By currTemp = By.xpath("//span[@class='summary swap']");
    By temOnTimeline = By.xpath("//span[@class='first']//span");
    By timelineTemListTxt =By.xpath("//span[@class='hour']/span");

    By todaysTimeLine = By.xpath("//body[@class='forecast']/div[@id='week']/a[1]/span[3]");

     By todaysMinTemp= By.xpath("//a[@class='day revealed']//span[@class='minTemp']");
     By todaysMaxTemp = By.xpath("//a[@class='day revealed']//span[@class='maxTemp']");

     By timeLineMinTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']//span[@class='temp']");
     By timelineMaxTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']//span[@class='temp']");

     By darkSkyAPILink = By.xpath("//a[contains(text(),'Dark Sky API')]");

     public void clickDarkSkyAPILink()
     {
         clickOn(darkSkyAPILink);
     }

    public ArrayList<String> timelineTempListMinMax()
    {
        ArrayList<String> timelinesTempList = new ArrayList<>();

        timelinesTempList.add(getTextFromElement(timeLineMinTemp).split("˚")[0]);
        timelinesTempList.add(getTextFromElement(timelineMaxTemp).split("˚")[0]);
        System.out.println(timelinesTempList);
        return  timelinesTempList;

    }


    public ArrayList<String> todaysTempListMinMax()
    {
        ArrayList<String> todaysTempList = new ArrayList<>();

        todaysTempList.add(getTextFromElement(todaysMinTemp).split("˚")[0]);
        todaysTempList.add(getTextFromElement(todaysMaxTemp).split("˚")[0]);

        System.out.println(todaysTempList);
        return  todaysTempList;

    }

    public void clickTodaysTimLine()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,850)");

        //clickOn(todaysTimeLine);
        WebElement expand = driver.findElement(todaysTimeLine);
        js.executeScript("arguments[0].click();",expand);
    }

    public ArrayList<Integer>   getTimelineList()
    {
         ArrayList<String> stringList =  getTextFromList(timelineTemListTxt);
         // [1am, 3am, 5am, 7am, 9am, 11am, 1pm, 4pm, 6pm, 8pm, 10pm]
        System.out.println(stringList);
        ArrayList<Integer> intList = new ArrayList<>();

        for(int i=0;i<stringList.size();i++)
        {
            int l = stringList.get(i).length();
            String numWithPostfix = stringList.get(i).substring(0,l-2);
            intList.add(Integer.parseInt(numWithPostfix));
        }

        System.out.println(intList);
        return intList;
    }


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
