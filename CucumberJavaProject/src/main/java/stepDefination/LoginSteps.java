package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class LoginSteps {
	
	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@Given("User navigates to the Website OrangeHrm")
	public void user_navigates_website_OrangeHrm() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Given("User entering Username and Password")
	public void  Username_password_as() throws Exception {
	    
		Thread.sleep(6000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Then("Login must be successful.")
	public void login_must_be_successful() throws Exception {
	    
		Thread.sleep(6000);
		driver.close();
	}


}
