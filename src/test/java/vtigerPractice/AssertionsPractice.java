package vtigerPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsPractice 
{
	@Test
	public void sampleTest()
	{
		int a = 1;   // Expected
		int b = 1;   // Actual
		Assert.assertEquals(b, a);
		System.out.println("Execution & Validation Completed");
	}

}
