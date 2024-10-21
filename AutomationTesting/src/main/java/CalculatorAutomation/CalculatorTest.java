package CalculatorAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class CalculatorTest {
	
	@SuppressWarnings("rawtypes")
	private static WindowsDriver CalculatorSession = null;
	private static WebElement  CalculatorResult = null;

	@SuppressWarnings({ "rawtypes", "deprecation" })
	@BeforeClass
	public static void Setup()
	{
		try {
			DesiredCapabilities capabilities=new DesiredCapabilities();
			capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
			CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4723/"),capabilities);
			CalculatorSession.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			CalculatorResult=CalculatorSession.findElementByAccessibilityId("CalculatorResults");
			Assert.assertNotNull(CalculatorResult);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			
		}
	}
	
	@AfterClass
	public static void TearDown()
	{
		CalculatorResult = null;
		if(CalculatorSession !=null) {
			CalculatorSession.quit();
			
		}
		CalculatorSession = null;	
	}
	
	@Test
	public void Addition()
	{
		CalculatorSession.findElementByName("One").click();
		CalculatorSession.findElementByName("Plus").click();
		CalculatorSession.findElementByName("Seven").click();
		CalculatorSession.findElementByName("Equals").click();
		//Assert.assertEquals("8", _GetCalculatorResultText());
		String print=_GetCalculatorResultText();
		System.out.println("The Value is:"+ print);
	}
	
	protected String _GetCalculatorResultText() {
		
		return CalculatorResult.getText().replace("Display is", "").trim();
	}
}

