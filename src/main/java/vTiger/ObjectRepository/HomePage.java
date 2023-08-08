package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	
	// Declaration
	
	
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText = "Oppurtunities")
	private WebElement OppurtunitiesLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLink;
	
	
	// Initialization.
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	// Utilization.


	public WebElement getOrganizationsLink() 
	{
		return OrganizationsLink;
	}

	public WebElement getContactsLink() 
	{
		return ContactsLink;
	}

	public WebElement getOppurtunitiesLink() 
	{
		return OppurtunitiesLink;
	}

	public WebElement getAdministratorImg() 
	{
		return AdministratorImg;
	}
	
	public WebElement getSingOutLink() 
	{
		return SignOutLink;
	}
	
	
	// Business Library.
	
	
	/**
	 * 
	 * This method will Click on Organizations Link.
	 * 
	 */
	
	public void clickOnOrgLink()
	{
		OrganizationsLink.click();
	}
	
	
	/**
	 * 
	 * This method will Click on Contacts Link.
	 * 
	 */
	
	public void clickOnContactsLink()
	{
		ContactsLink.click();
	}
	
	
	/**
	 * 
	 * This method will Logout of Application.
	 * @param driver
	 * @throws Throwable
	 * 
	 */
	
	public void logoutOfApp(WebDriver driver) throws Throwable
	{
		mouseHoverAction(driver, AdministratorImg);
		Thread.sleep(1000);
		SignOutLink.click();
		
	}
	
}
