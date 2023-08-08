package vTiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This Class provides Implementation to ITestListener Interface of TestNG. 
 * 
 * Example for Abstraction.
 * 
 * @author Bittu Kumar Sharma
 * 
 */


public class ListenerImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println("---- Execution Started ----"+methodName);
		
		test = report.createTest(methodName);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		//System.out.println("---- PASS ----"+methodName);
		
		test.log(Status.PASS, "---- PASS ----"+methodName);
	
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		
		//System.out.println("---- FAIL ----"+methodName);
		
		test.log(Status.FAIL, "---- FAIL ----"+methodName);
		
		// System.out.println(result.getThrowable());
		
		test.log(Status.INFO, result.getThrowable());
		
		
		/* Take ScreenShots for Failed Test Scripts - To Attach with Bug Rising */
		
		WebDriverUtility wU = new WebDriverUtility();
		
		JavaUtility jU = new JavaUtility();
		
		String screenshotName = methodName+jU.getSystemDateInFormat();
		
		try {
			wU.takeScreenShot(BaseClass.sdriver, screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		
		//System.out.println("---- SKIP ----"+methodName);
		
		test.log(Status.SKIP, "---- SKIP ----"+methodName);
		
		//System.out.println(result.getThrowable());
		
		test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		// Start of <Suite> - @BeforeSuite
		
		System.out.println("---- Suite Execution Started ----");
		
		// Configure the Extent Report.
		
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		
		htmlreport.config().setDocumentTitle("Vtiger Execution Report");
		htmlreport.config().setReportName("Build 3 Vtiger Execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		
		
		// Report Generation 
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Testing Environment");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base OS", "Windows");
		report.setSystemInfo("Base Reporter", "Bittu Kumar Sharma");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("---- Suite Execution Ended ----");
		
		
		// Report Generation.
		
		report.flush();
	}
	
	
}
