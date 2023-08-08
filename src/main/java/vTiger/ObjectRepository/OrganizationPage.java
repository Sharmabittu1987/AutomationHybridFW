package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	
	// Declaration.
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;
	
	
	// Initialization.
	
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	// Utilization.
	
	
	public WebElement getCreateOrgLookUpImg()
	{
		return CreateOrgLookUpImg;
	}
	
	
	// Business Library.
	
	
	/**
	 * 
	 * This method will Click on Create Organization look Up Image.
	 * 
	 */
	
	public void clickOnCreateOrgLookUpImg()
	{
		CreateOrgLookUpImg.click();
	}

	
}
