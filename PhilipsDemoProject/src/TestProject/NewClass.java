package TestProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewClass {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://ingbtcpic5vw430.code1.emi.philips.com/gfn/PD2");
		driver.navigate().refresh();
		//driver.close();
		

	}

}
