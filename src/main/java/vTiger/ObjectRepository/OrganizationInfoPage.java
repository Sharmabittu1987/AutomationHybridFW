package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	
	//Declaration.
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	
	//Initialization.
	
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	// Utilization.
	
	
	public WebElement getOrgHeaderText()
	{
		return OrgHeaderText;
	}
	
	
	// Business Library.
	
	
	/**
	 * 
	 * This method will Capture the Header Text & Return it to Caller.
	 * @return
	 * 
	 */
	
	
	public String getHeaderText()
	{
		return OrgHeaderText.getText();
		
	}

}
