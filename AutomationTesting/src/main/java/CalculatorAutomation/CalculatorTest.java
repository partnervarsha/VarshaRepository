package CalculatorAutomation;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;

public class CalculatorTest {

	  @SuppressWarnings("rawtypes")
	  static WindowsDriver calSession;
	  @SuppressWarnings("deprecation")
	
	  public static void main(String[] args) throws Exception
	  {
		  DesiredCapabilities caps = new DesiredCapabilities();
	      caps.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
	      calSession = new WindowsDriver<>(new URL("  http://127.0.0.1:4723/"), caps);
	      System.out.println(calSession.getSessionId());
	      calSession.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      
	      String calName = calSession.findElementByAccessibilityId("Header").getText();
	      System.out.println(calName);
	      
	      calSession.findElementByName("One").click();
	      calSession.findElementByName("Plus").click();
	      calSession.findElementByName("Nine").click();
	      calSession.findElementByName("Equals").click();
	      
	      String result = calSession.findElementByAccessibilityId("CalculatorResults").getText();
	      System.out.println(result);
	      calSession.findElementByName("Close Calculator").click();
	      
	  }
}

// winAppdriver must should be on while runnning this programme