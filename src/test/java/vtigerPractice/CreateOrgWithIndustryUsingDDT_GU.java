package vtigerPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class CreateOrgWithIndustryUsingDDT_GU {
	
	public static void main(String[] args) throws Throwable {
		
		// Create Object of Required Utilities
		
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		
		WebDriver driver = null;
		
		// Step 1 : Read all the Necessary Data.
		
		/* Read Data From Property File - Common Data */
		   
		String BROWSER = pUtil.getDataFromPropertyFile("browser");
		String URL = pUtil.getDataFromPropertyFile("url");
		String USERNAME = pUtil.getDataFromPropertyFile("username");
		String PASSWORD = pUtil.getDataFromPropertyFile("password");
		
		
		/* Read Data from Excel Sheet - Test Data */
		
		String ORGNAME = eUtil.getDataFromExcel("Organization", 5, 2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.getDataFromExcel("Organization", 5, 3);
		
		
		// Step 2 : Launch the Browser - Driver is Acting based on Run-Time Data -> Example of Run-Time Polymorphism. 
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+" Browser Launched");
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+" Browser Lauched");
		}
		else
		{
			System.out.println("==== INVALID BROWSER NAME ====");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitforElementsToLoad(driver);
		
		
		
		// Step 3 : Load the URL.
		
		driver.get(URL);
		
		
		// Step 4 : Login to the Application.
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
		// Step 5 : Click on Organizations Link.
		
		driver.findElement(By.linkText("Organizations")).click();
		
		
		// Step 6 : Click on Create Organization Look Up Image.
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		
		// Step 7 : Create Organization.
		
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		
		// Step 8 : Choose "Chemicals" in Industry Drop Down.
		
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		
		wUtil.handleDropDown(INDUSTRY, industryDropDown);
		
		
		// Step 9 : Save.
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		// Step 10 : Validate.
		
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println(OrgHeader);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		
		// Step 11 : Logout of Application.
		
		WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, AdminImg);
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("==== LOGOUT SUCCESSFUL ====");
		
		
	}

}
