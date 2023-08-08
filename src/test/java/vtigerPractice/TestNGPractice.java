package vtigerPractice;

import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test(invocationCount = 2,priority = -1)
	public void createCustomer()
	{
		System.out.println("Customer Created");
	}
	
	
	@Test(dependsOnMethods = "createCustomer")
	public void modifyCustomer()
	{
		System.out.println("Customer Modified");
	}
	
	
	@Test(dependsOnMethods = {"createCustomer" , "modifyCustomer"})
	public void deleteCustomer()
	{
		System.out.println("Customer Deleted");
	}

}
