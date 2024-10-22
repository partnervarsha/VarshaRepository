package DemoTest;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class cucumberTest {
	
	public static void main(String[] args)
	{
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.close();
	
	}
	
}
