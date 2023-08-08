package vTiger.ContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class CreateContactWithOrganisation {
	
	public static void main(String[] args) throws Throwable {
		
		/* Create Organization */
		
		// Create Object of Required Utilities
		
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		WebDriver driver = null;
		
		// Step 1 : Read all the Necessary Data.
		
		String BROWSER = pUtil.getDataFromPropertyFile("browser");
		String URL = pUtil.getDataFromPropertyFile("url");
		String USERNAME = pUtil.getDataFromPropertyFile("username");
		String PASSWORD = pUtil.getDataFromPropertyFile("password");
		
		/* Read Data from Excel Sheet - Test Data */
		
		String ORGNAME = eUtil.getDataFromExcel("Contacts", 4, 3)+ jUtil.getRandomNumber();
		String LASTNAME = eUtil.getDataFromExcel("Contacts", 4, 2);
		
		
		// Step 2 : Launch the Browser - Driver is acting based on RunTime Data.
		            
		            /* Example of RunTime Polymorphism */
		
		if(BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+ " Browser Launched");
			
		} 
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+ " Browser Launched");
		
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER+ " Browser Launched");
			
		}
		else
		{
			System.out.println(" INVALID BROWSER NAME");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitforElementsToLoad(driver);
		
		
		// Step 3 : Load the URL.
		
		driver.get(URL);
		
		
		// Step 4 : Login to Application.
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
		// Step 5 : Click on Organizations Link.
		
		driver.findElement(By.linkText("Organizations")).click();
		
		
		// Step 6 : Click on Create Organization Look Up Image.
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		
		// Step 7 : Create Organization.
		
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		
		// Step 8 : Save
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		// Step 9 : Validate for Organization.
		
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("Organization Created");
			System.out.println(OrgHeader);
			
		} 
		else
		{
			System.out.println(" --- FAIL --- ");
			
		}
		
		/* Create Contact Using Organization */
		
		
		// Step 10 : Click on Contacts Link.
		
		driver.findElement(By.linkText("Contacts")).click();
		
		
		// Step 11 : Navigate to Create Contact Look Up Image.
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		
		// Step 12 : Create a Contact with Mandatory Information.
		
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		
		
		// Step 13 : Switch to Child Window.
		
		wUtil.switchToWindow(driver, "Accounts");
		
		
		// Step 14 : Search for Organization.
		
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();          // Dynamic Xpath
		
		
		// Step 15 : Switch the Control Back to Parent Window.
		
		wUtil.switchToWindow(driver, "Contacts");
		
		
		// Step 16 : Save.
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		// Step 17 : Validate for Organization.
		
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(ContactHeader.contains(LASTNAME))
		{
			System.out.println(" ---- PASS ---- ");
			System.out.println(ContactHeader);
			
		}
		else
		{
			System.out.println(" ---- FAIL ---- ");
			
		}
		
		
		// Step 18 : Logout.
		
		WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		wUtil.mouseHoverAction(driver, AdminImg);
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println(" ---- LOGOUT SUCCESSFULL ---- ");
	
	}

}
