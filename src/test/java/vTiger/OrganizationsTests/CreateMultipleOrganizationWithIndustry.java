package vTiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationPage;

public class CreateMultipleOrganizationWithIndustry {
	
	ExcelFileUtility eUtil = new ExcelFileUtility();
	JavaUtility jUtil = new JavaUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	
	
	@Test(dataProvider = "getData")
	public void createMultipleOrganization(String ORG, String INDUSTRY) throws Throwable
	{
		WebDriver driver = null;
		
		
		// Step -1 : Read all the Necessary Data.
		
		/* Read Data from Property File - Common Data */
		
		String BROWSER = pUtil.getDataFromPropertyFile("browser");
		String URL = pUtil.getDataFromPropertyFile("url");
		String USERNAME = pUtil.getDataFromPropertyFile("username");
		String PASSWORD = pUtil.getDataFromPropertyFile("password");
		
		
		/* Read Data from Excel Sheet - TestData */
		
		String ORGNAME = ORG+jUtil.getRandomNumber();
		
		
		// Step - 2 : Launch the Browser - Driver is acting Based on RunTime Data - Example of RunTime PolyMorphism.
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("===== "+BROWSER+" Browser Launched =====");
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("===== "+BROWSER+" Browser Launched =====");
			
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("===== "+BROWSER+" Browser Launched =====");
			
		}
		else
		{
			System.out.println("===== INVALID BROWSER =====");
			
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitforElementsToLoad(driver);
		
		
		
		// Step 3 : Load the URL.
		
		driver.get(URL);
		
		
		// Step 4 : Login to Application.
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		
		// Step 5 : Click on Organizations Link.
		
		HomePage hp= new HomePage(driver);
		hp.clickOnOrgLink();
		
		
		// Step 6 : Click on Organization Look Up Image.
		
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		
		// Step 7 : Create Organization.
		
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME, INDUSTRY);
		
		
		// Step - 8 : Validate.
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getHeaderText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println(OrgHeader);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		
		//Step - 10 : Logout of Application.
		
		hp.logoutOfApp(driver);
		System.out.println("Logout Successfull");
	}
	
	
	@DataProvider
	public Object[][] getData() throws Throwable, IOException
	{
		return eUtil.readMultipleData("MultipleOrg");
		
	}
	
}
