package StepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ConfigReader;

import java.util.concurrent.TimeUnit;

public class SharedSD {

	private static WebDriver driver = null;

	@Before("@web")
	public static void before() {

		ConfigReader configReader = new ConfigReader();
		/*System.setProperty("webdriver.chrome.driver",
				configReader.getChromeDriverPath());*/
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(configReader.getUrl());
	}

	@After("@web")
	public static void after() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			//driver.quit();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
