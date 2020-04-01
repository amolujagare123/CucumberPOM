package Framework.WebPages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class DarkSkyPage extends BasePage {

    By currTemp = By.xpath("//span[@class='summary swap']");
    By temOnTimeline = By.xpath("//span[@class='first']//span");
    By timelineTemListTxt =By.xpath("//span[@class='hour']/span");


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
