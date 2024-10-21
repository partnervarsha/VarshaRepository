package TestProject;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NewClass {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.amazon.com");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[contains(@data-action-type,'DISMISS')]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']//span[contains(text(),'All')]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[@class='nav-sprite hmenu-close-icon']")).click();
		Thread.sleep(6000);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.id("nav-link-accountList")));
		act.build().perform();
		WebElement AccountList = driver.findElement(By.id("nav-flyout-accountList"));
		TakesScreenshot ts =((TakesScreenshot)AccountList);
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		String filename = new SimpleDateFormat("dd-MM-yyyy HH-mm").format(new Date());
		File desfile=new File("./Screenshots/ST.png " + filename);
		FileUtils.copyFile(srcfile,desfile);
		act.moveToElement(driver.findElement(By.id("nav-link-accountList")));
		act.build().perform();
		driver.findElement(By.xpath("//a[@class='nav-a'][contains(text(),'Start here.')]")).click();
		String excelPath = "./Excel Sheet/Sheet.xlsx";
		ExcelSheet es = new ExcelSheet();
		for (int i = 1; i <= es.getRowCount(excelPath, "Sheet1"); i++) 
		{
		    // Get cell data
		    String usr = es.getCellData(excelPath, "Sheet1", i, 1);
		    Thread.sleep(3000);
		    WebElement name = driver.findElement(By.xpath("//input[contains(@placeholder,'First and last name')]"));
		    name.sendKeys(usr);
		    String placeholdername = name.getAttribute("value"); // Use getAttribute to get input field value
		    es.setCellData(excelPath, "Sheet1", i, 2, "placeholdername");
		    es.setCellData(excelPath, "Sheet1", i, 3, placeholdername);
		}
	}
	
	
}
	    




		
		
		
				
	

