package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	
	
	// Declaration
	
	
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	
	// Initialization.
	
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	// Utilization.
	
	
	public WebElement getOrgNameEdt()
	{
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() 
	{
		return IndustryDropDown;
	}

	public WebElement getSaveBtn() 
	{
		return SaveBtn;
	}
	
	
	// Business Library.
	
	
	/**
	 * 
	 * This method will Create Organization with Mandatory Fields.
	 * @param ORGNAME
	 * 
	 */
	
	
	public void createOrganization(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	
	
	/**
	 * 
	 * This method will Create Organization with Industry Drop Down.
	 * 
	 * @param ORGNAME
	 * @param INDUSTRY
	 * 
	 */
	
	
	public void createOrganization(String ORGNAME, String INDUSTRY)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDown,INDUSTRY);
		SaveBtn.click();
		
	}
	
}
