package vtigerPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndustryUsingDDT {
		
	public static void main(String[] args) throws IOException {
			
		WebDriver driver = null;
			
		Random r = new Random();
		int random = r.nextInt(1000);
			
		// Step 1 : Read all the Necessary Data.
			
        /* Read Data From Property File */
			
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			
		Properties pObj = new Properties();
			
		pObj.load(fisp);
			
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
			
			
		/* Read Data from Excel Sheet - Test Data */
			
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Organization");
		String ORGNAME = sh.getRow(5).getCell(2).getStringCellValue()+random;
		String INDUSTRY = sh.getRow(5).getCell(3).getStringCellValue();
			
			
			
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
			System.out.println(BROWSER+" Browser Launched");
		}
		else
		{
		    System.out.println("==== INVALID BROWSER NAME ====");
		}
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			
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
		Select s = new Select(industryDropDown);
		s.selectByValue(INDUSTRY);
			
			
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
		Actions act = new Actions(driver);
		act.moveToElement(AdminImg).perform();
			
		driver.findElement(By.linkText("Sign Out")).click();
			
		System.out.println("==== LOGOUT SUCCESSFUL ====");
			
			
	}

}

