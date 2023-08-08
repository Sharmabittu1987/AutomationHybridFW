package vTiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This Class Provides Implementation for IRetryAnalyser Interface.
 * @author Bittu Kumar Sharma
 *
 */

public class RetryAnalyserImplementation implements IRetryAnalyzer {
	
	int count = 1;
	
	int retryCount = 3;
	
	public boolean retry(ITestResult result)
	{
		while(count<=retryCount)
		{
			count++;
			return true;
		}
		
		return false;
		
	}

}
