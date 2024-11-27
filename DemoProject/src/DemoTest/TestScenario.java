package DemoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestScenario {
	
	public static void main(String[] args) throws Exception
	{
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	Thread.sleep(6000);
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.close();
	
	}
	
}
