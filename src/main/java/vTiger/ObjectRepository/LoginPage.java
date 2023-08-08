package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  

// Rule 1 : Create a Separate POM Class for Every web Page.

{ 
	
	// Rule 2 : Identify the Web Element using @FindBy, @FindBys, @FindAll.
	
	// Declaration.
	
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	
	
	// Rule 3 : Create a Constructor to Initialize the Web Elements.
	
	// Initialization.
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	// Rule 4 : Provide Getters to Access these Web Elements.
	
	// Utilization.

	
	public WebElement getUserNameEdt() 
	{
		return userNameEdt;
	}

	public WebElement getPasswordEdt() 
	{
		return passwordEdt;
	}

	public WebElement getLoginBtn() 
	{
		return loginBtn;
	}
	
	
	// Rule 5 : Business Library - Project Specific generic Method.
	
	
	/**
	 * This method will Perform Login Operation.
	 * 
	 * @param USERNAME
	 * @param PASSWORD
	 * 
	 */
	
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
		
	}
	

}
