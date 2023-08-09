package vtigerPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPracticeModified 
{
	@Test
	public void sampleTest()
	{
		int a = 1;   // Expected
		int b = 2;   // Actual
		
		System.out.println("Step - 1");
		System.out.println("Step - 2");
		
		Assert.assertEquals(b, a);
		
		System.out.println("Execution & Validation Completed");
		
		System.out.println("Step - 4");
		System.out.println("Step - 5");
	}

	@Test
	public void sampleTest1()
	{
		SoftAssert sa = new SoftAssert();
		
		int a = 1;    // Expected
		int b = 2;    // Actual
		
		System.out.println("Step - 1");
		System.out.println("Step - 2");
		
		sa.assertEquals(b, a);      // Fail 
		
		System.out.println("Executed & Validation Completed");
		
		System.out.println("Step - 3");
		System.out.println("Step - 4");
	}
	
	
	@Test
	public void sampleTest2()
	{
		SoftAssert sa = new SoftAssert();
		
		int a = 1;   // Expected
		int b = 2;   // Actual
		
		System.out.println("Step - 1");
		System.out.println("Step - 2");
		
		sa.assertEquals(b, a);        // FAIL
		
		System.out.println("Step - 3");
		System.out.println("Step - 4");
		
		sa.assertTrue(false);          // FAIL
		
		System.out.println("Execution & Validation Completed");
		
		sa.assertAll();               // Logging All the Failures            
	}
}
