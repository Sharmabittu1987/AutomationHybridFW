package vTiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/**
 * This Class consists of all the Basic Configuration Annotations
 * for all the Common Actions. 
 * @author Bittu Kumar Sharma
 *
 */

public class BaseClass {
	
	public JavaUtility jUtil = new JavaUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	
	
	public WebDriver driver = null;
	
	// Only Used for Listener to take Screen Shots.
	
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})               // FOR BATCH GROUP EXECUTION USE--> (groups = {"SmokeSuite","RegressionSuite"})in @BeforeSuite 
	public void bsConfig()
	{
		System.out.println("====== DATABASE CONNECTION SUCCESSFUL =====");
	}
	
	
	// @BeforeClass(alwaysRun = true)                                     // FOR BATCH EXECUTION, GROUP EXECUTION USE--> alwaysrun = True ; in EVERY TEST METHOD 
	@Parameters("browser")                                                // FOR CROSS BROWSER EXECUTION USE--> @Parameters("browser")
	@BeforeTest()
	public void bcConfig(String BROWSER)throws Throwable                  // FOR PARALLEL EXECUTION USE--> @BeforeTest IN PLACE OF @BeforeClass(alwaysRun = true)
	                                                                      // FOR CROSS BROWSER EXECUTION USE-->public void bcConfig(String BROWSER)throws Throwable IN PLACE OF public void bcConfig()throws Throwable 
	{                                                                        
		// Read Browser Name & URL from Property File
		
	                                                                     // FOR CROSS BROWSER EXECUTION DONT GIVE -->String BROWSER = pUtil.getDataFromPropertyFile("browser") AS IT WILL NOT READ THE BROWSER FROM PROPERTY FILE
		String URL = pUtil.getDataFromPropertyFile("url");
		
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("======= "+BROWSER+" Browser Launched ========");
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("======== "+BROWSER+" Browser Launched ========");
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver();
			driver = new EdgeDriver();
			System.out.println("======== "+BROWSER+" Browser Launched");
		}
		else
		{
			System.out.println(" ======== INVALID BROWSER NAME =========");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitforElementsToLoad(driver);
		
		
		// Only Used for Listener to take Screen Shots.
		
		sdriver = driver;
		
		// Load The URL
		
		driver.get(URL);
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws Throwable
	{
		// Read User-Name & Password from Property File.
		
		String USERNAME = pUtil.getDataFromPropertyFile("username");
		String PASSWORD = pUtil.getDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println(" ===== LOGIN SUCCESSFUL =====");
		
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws Throwable
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println(" ===== LOGOUT SUCCESSFUL =====");
		
	}
	
	
	//@AfterClass(alwaysRun = true)                                     // FOR PARALLEL & CCROSS BROWSER EXECUTION USE--> @AfterTest() in place of @BeforeClass(alwaysRun = true)
	@AfterTest()
	public void acConfig()
	{
		driver.quit();
		System.out.println(" ===== BROWSER CLOSED =====");
		
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println(" ===== DATABASE CONNECTION CLOSED =====");
		
	}
	

}
