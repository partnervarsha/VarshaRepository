package CalculatorAutomation;

import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.windows.WindowsDriver;

public class NotepadApp {
	
	@SuppressWarnings("rawtypes")
	WindowsDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
    public void setUp() throws Exception {
		
		Desktop desk=Desktop.getDesktop();
		desk.open(new File("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe"));
		
		Thread.sleep(3000);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
        driver = new WindowsDriver<>(new URL("  http://127.0.0.1:4723/"), caps);
        System.out.println(driver.getSessionId());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
	
	@Test
    public void NotepadSave() 
    {
           driver.findElementByName("Text Editor").sendKeys("varsha");
           driver.findElementByName("File").click();
           driver.findElementByAccessibilityId("3").click();
           driver.findElementByAccessibilityId("1001").sendKeys("Automation File");
           driver.findElementByName("Save").click();
           driver.close();
    }
    
	
	@SuppressWarnings("deprecation")
	@AfterTest
	public void CloseUp() throws Exception
	{
		Runtime.getRuntime().exec("taskkill /F /IM WinAppDriver.exe");
	}

}
