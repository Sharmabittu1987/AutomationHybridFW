package vTiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;



/**
 * This Class Consists of all the Re - Usable methods related to Web Driver Actions 
 * @author Bittu Kumar Sharma
 *
 */


public class WebDriverUtility {
	
	
	/**
	 * This Method will Maximize the Window.
	 * @param driver 
	 * 
	 */
	
	
	public void maximizeWindow(WebDriver driver)                 // Updated Driver Reference
	{
		driver.manage().window().maximize();
		
	}
	

	
	/**
	 * This Method will minimize the Window.
	 * @param driver
	 * 
	 */
	
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	
	
	/**
	 * This Method will Wait for All the findElement & findElements Operations To Be Performed.
	 * @param driver
	 * 
	 */
	
	
	public void waitforElementsToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	
	/**
	 * This Method will wait Until the Specified Element is Visible in DOM.
	 * @param driver
	 * @param element  
	 *  
	 */
	
	
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
	 WebDriverWait wait	 = new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 
	}
	
	
	/**
	 * This Method will Handle Drop Down Using Index.
	 * @param element 
	 * @param index 
	 * 
	 */
	
	
	public void handleDropDown(WebElement element, int index)
	{
		Select sel = new Select (element);
		sel.selectByIndex(index);
		
	}
	
	
	/**
	 * This Method will Handle Drop Down Using Value.
	 * @param element 
	 * @param value 
	 * 
	 */
	
	
	public void handleDropDown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
		
	}
	
	
	
	/**
	 * This Method will Handle Drop Down Using Visible Text.
	 * @param element 
	 * @param text 
	 * 
	 */
	
	
	public void handleDropDown(String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
		
	}
	
	
	/**
	 * This Method will Perform Mouse Hover Action on a Target Element.
	 * @param driver 
	 * @param element 
	 * 
	 */
	
	
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	
	/**
	 * This Method will Double Click Anywhere on the WebPage.
	 * @param driver 
	 * 
	 */
	
	
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	
	/**
	 * This Method will Double Click on a Web Element.
	 * @param driver 
	 * @param element 
	 * 
	 */
	
	
	public void doubleClickAction(WebElement element, WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	
	
	/**
	 * This Method will Perform Right Click Anywhere on the Web Page.
	 * @param driver 
	 * 
	 */
	
	
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	
	
	/**
	 * This Method will Perform Right Click on a Particular Web Element.
	 * @param driver 
	 * @param element 
	 * 
	 */
	
	
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	
	
	/**
	 * This Method will Perform Drag & Drop Action.
	 * @param driver 
	 * @param srcElement 
	 * @param targetElement 
	 * 
	 */
	
	
	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement targetElement)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, targetElement).perform();
		
	}
	
	
	
	/**
	 * This Method is Used to Move the Cursor Anywhere on the WebPage based on Offset Values.
	 * @param driver 
	 * @param xOffSet 
	 * @param yOffSet 
	 * 
	 */
	
	
	public void moveAcrossWebpage(WebDriver driver, int xOffSet, int yOffSet)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(xOffSet, yOffSet).click().perform();
	}
	
	
	
	/**
	 * This Method will Scroll Vertically for 500 Pixels.
	 * @param driver 
	 * 
	 */
	
	
	
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);","");
		
	}
	
	
	
	/**
	 * This Method will Scroll Vertically Until the Element Reference.
	 * @param driver 
	 * @param element 
	 * 
	 */
	
	
	
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+");", element);
		
		// js.executeScript("argument[0].scrollIntoView();", element);
		
	}
	
	
	
	/**
	 * This Method will Accept the Alert Pop-Ups.
	 * @param driver 
	 * 
	 */
	
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	
	
	/**
	 * This Method will Cancel the Alert / Confirmation Pop-Up.
	 * @param driver 
	 * 
	 */
	
	
	
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
		
	}
	
	
	
	/**
	 * This Method will Enter the Text in Prompt Pop-Up.
	 * @param driver 
	 * @param text 
	 * 
	 */
	
	
	
	public void sendTextToAlert(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	
	
	/**
	 * This Method will Capture the Alert Message & Return to the Caller.
	 * @param driver 
	 * 
	 */
	
	
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	
	
	/**
	 * This method will Handle Frame Based on Frame Index.
	 * @param driver 
	 * @param index 
	 * 
	 */
	
	
	
	public void handleFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	
	/**
	 * This Method will Handle Frame based on Value of Name or ID Attributes.
	 * @param driver 
	 * @param nameorID 
	 *  
	 */
	
	
	
	public void handleFrame(WebDriver driver, String nameorID)
	{
		driver.switchTo().frame(nameorID);
	}
	
	
	
	/**
	 * This Method will handle Frame Based on Web Element.
	 * @param driver 
	 * @param element 
	 * 
	 */
	
	
	
	public void handleFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	
	
	/**
	 * This Method will Help to Switch the Control Back to Immediate Parent.
	 * @param driver 
	 * 
	 */
	
	
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	
	
	/**
	 * This Method will help to Switch the Control Back to Current Page.
	 * @param driver 
	 * 
	 */
	
	
	public void handleFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	
	
	/**
	 * This Method will Switch the Selenium Control from Parent Window To Child Window or 
	 * Child Window to Parent Window based on Partial Window Title.
	 * @param driver 
	 * @param partialwinTitle 
	 * 
	 */
	
	
	public void switchToWindow(WebDriver driver, String partialwinTitle)
	{
		// Step 1 : Capture all the Window IDs.
		
		Set<String> allWindowsIds = driver.getWindowHandles();
		
		
		// Step 2 : Iterate through Individual IDs.
		
		for(String winID:allWindowsIds)
		{
			
		// Step 3 : Switch to each ID & Capture the Title.
			
			String currentTitle = driver.switchTo().window(winID).getTitle();
			
			
		// Step 4 : Compare the Title with Required Reference.
			
			if(currentTitle.contains(partialwinTitle))
			{
				break;
				
			}
				
		}
	}
	
	
	
	/**
	 * This Method will Take Screen Shot & Return the Absolute Path of it.
	 * @param driver 
	 * @param screenshotName 
	 * @throws IOException
	 * @return Path 
	 *  
	 */
	
	
	public String takeScreenShot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+screenshotName+".png");
		Files.copy(src, dst);                                           // This Class is From Commons IO Tool; we have to add the Commons IO Dependency.
		
		return dst.getAbsolutePath();                                   // Used for attaching the Screen Shot to Extent Reports 
			
		
	}
	

}
