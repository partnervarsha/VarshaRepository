package CalculatorAutomation;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class AutomatingWeatherApps {
	
		private AppiumDriver<WebElement> driver;

		@SuppressWarnings("deprecation")
		@BeforeClass
	    public void setUp() throws Exception {
			
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("platformName", "Windows 10");
	        caps.setCapability("platformVersion", "10.0");
	        caps.setCapability("deviceName", "INGBTCPIC6VWM41");
	        caps.setCapability("app", "Microsoft.BingWeather_8wekyb3d8bbwe!App");

	        driver = new AppiumDriver<>(new URL(" http://127.0.0.1:4723/"), caps);
	    }

	    @Test
	    public void testWeatherApp() 
	    {
	        for (WebElement el : driver.findElements(By.xpath("//ListItem[contains(@Name, 'day ')]"))) {
	            el.click();
	            WebElement sunrise = driver.findElement(MobileBy.AccessibilityId("Almanac_Sunrise"));
	            WebElement sunset = driver.findElement(MobileBy.AccessibilityId("Almanac_Sunset"));
	            System.out.println(el.getAttribute("Name"));
	            System.out.println("Sunrise: " + sunrise.getAttribute("Name"));
	            System.out.println("Sunset: " + sunset.getAttribute("Name"));
	            System.out.println("----------------------------");
	        }
	    
	}
	    
	    @AfterClass
	    public void tearDown() {
	        try {
	            driver.quit();
	        } catch (Exception e) {}
	    }

}
