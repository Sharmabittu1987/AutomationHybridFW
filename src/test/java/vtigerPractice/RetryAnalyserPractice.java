package vtigerPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	
	@Test(retryAnalyzer = vTiger.GenericUtilities.RetryAnalyserImplementation.class)
	public void sample()
	{
		Assert.fail();
		System.out.println("Hi");
	}

}
