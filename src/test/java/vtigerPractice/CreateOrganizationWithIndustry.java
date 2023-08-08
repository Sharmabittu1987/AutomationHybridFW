package vtigerPractice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustry {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		int random = r.nextInt(1000);
		
		// Step 1 : Launch The Browser
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		// Step 2 : Load the URL
		
		driver.get("http://localhost:8888");
		
		
		// Step 3 : Login To The Application
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		
		// Step 4 : Click on Organizations Link
		
		driver.findElement(By.linkText("Organizations")).click();
		
		
		// Step 5 : Click on create Organization Look-Up Image
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		
		// Step 6 : Create Organization
		
		String OrgName = "L&T"+random;
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		
		// Step 7 : Choose "Chemicals" in Industry Drop Down
		
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		Select s = new Select(industryDropDown);
		s.selectByValue("Chemicals");
		
		
		// Step 8 : Save
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		
		// Step 9 : Validate
		
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(OrgName))
		{
			System.out.println("PASS");
			System.out.println(OrgHeader);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		
		// Step - 10 : Log Out of Application
		
		WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(AdminImg).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("Logout Successfull");
	}

}
