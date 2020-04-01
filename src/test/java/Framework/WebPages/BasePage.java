package Framework.WebPages;

import StepDefinitions.SharedSD;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

//import com.gargoylesoftware.htmlunit.ElementNotFoundException;


public class BasePage {
static WebDriver driver = SharedSD.getDriver();
	// This is the most common wait function used in selenium
	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

	public void clickOn(By locator) {
		webAction(locator).click();

		//driver.findElement(locator).click();
	}

	public void setValue(By locator, String value) {
		webAction(locator).sendKeys(value);
		//driver.findElement(locator)
	}
	public String getValueFromElement(By locator) {
		return webAction(locator).getText();
		//driver.findElement(locator)
	}


	public String getTextFromElement(By locator) {
		return webAction(locator).getText();
		//driver.findElement(locator)
	}

	public ArrayList<String> getTextFromList(By locator)
	{
		List<WebElement> listElements= driver.findElements(locator);

		ArrayList<String> stringList = new ArrayList<>();

		for(int i=0;i<listElements.size();i++)
		{
			stringList.add(listElements.get(i).getText());
		}

		return stringList;
	}

	public boolean isElementDisplayed(By locator) {
		return webAction(locator).isDisplayed();
	}

	public boolean isElementSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public void selectFromDropdown(By locator, String dropdownText) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by visible text
		selectMonth.selectByVisibleText(dropdownText);
	}

	public void selectFromDropdown(By locator, int index) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by index
		selectMonth.selectByIndex(index);
	}


}
