package stepDefination;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


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
	
	@When("User navigates to Admin Page")
	public void user_navigates_AdminPage() throws Exception
	{
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1][text()='Admin']")).click();
		driver.findElement(By.xpath("(//span[@class='oxd-topbar-body-nav-tab-item'])[2][text()='Job ']")).click();
	}
	
	@And("User click on Job dropdown")
	public void job_dropdown() throws Exception
	{
		Thread.sleep(6000);
		driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']//li//a[contains(text(),'Job Titles')]")).click();
	}
	
	
	@Then("Job Titles page is displayed.")
	public void job_titles_page_is_displayed() throws Exception 
	{

		Thread.sleep(6000);
		String title = driver.getTitle();
		System.out.println(title);
	   
	}

	
	@Then("Login must be successful.")
	public void login_must_be_successful() throws Exception {
	    
		Thread.sleep(6000);
		driver.close();
	}


}
