package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{
	
	
	// Declaration.
	
	
	@FindBy(name = "lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy(name = "search")
	private WebElement OrgSearchBtn;
	
	
	// Initialization.
	
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	// Utilization.
	
	
	public WebElement getLastNameEdt() 
	{
		return LastNameEdt;
	}

	public WebElement getSaveBtn() 
	{
		return SaveBtn;
	}

	public WebElement getOrgLookUpImg() 
	{
		return OrgLookUpImg;
	}

	public WebElement getOrgSearchEdt() 
	{
		return OrgSearchEdt;
	}

	public WebElement getOrgSearchBtn() 
	{
		return OrgSearchBtn;
	}
	
	
	// Business Library.
	
	
	/**
	 * 
	 * This method will Create Contact with Mandatory Information.
	 * @param LASTNAME
	 * 
	 */
	
	public void createContact(String LASTNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
		
	}
	
	
	/**
	 * 
	 * This method will Create Contact with Relevant Organization.
	 * 
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 * 
	 */
	
	
	public void createContact(WebDriver driver, String LASTNAME, String ORGNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		switchToWindow(driver,"Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		OrgSearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		switchToWindow(driver,"Contacts");
		SaveBtn.click();
		
	}
	
}
