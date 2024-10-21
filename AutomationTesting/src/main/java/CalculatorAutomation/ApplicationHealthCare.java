package CalculatorAutomation;

import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.windows.WindowsDriver;

public class ApplicationHealthCare {
	
	@SuppressWarnings("rawtypes")
	WindowsDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
    public void setUp() throws Exception {
		
		
		Desktop desk=Desktop.getDesktop();
		desk.open(new File("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe"));
		
		Thread.sleep(4000);
		
        DesiredCapabilities caps = new DesiredCapabilities();
        
        caps.setCapability("app", "C:\\Program Files (x86)\\Philips IntelliSpace Portal\\System\\PortalLoginApplication.exe");
        caps.setCapability("ms:waitForAppLaunch", "25");
        driver = new WindowsDriver<>(new URL("  http://127.0.0.1:4723/"), caps);
        System.out.println(driver.getSessionId());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	
	@Test
    public void NotepadSave() 
    {
		   System.out.println("Test");
    }

	

}


//"C:\Program Files (x86)\Philips IntelliSpace Portal\System\PortalLoginApplication.exe