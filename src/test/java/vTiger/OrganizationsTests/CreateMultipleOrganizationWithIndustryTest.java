package vTiger.OrganizationsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationPage;

public class CreateMultipleOrganizationWithIndustryTest extends BaseClass

{	
	@Test(dataProvider = "getData")
	public void createMultipleOrganizationWithIndustryTest(String ORG, String INDUSTRY) throws Throwable
	{
			
		/* Read Data from Excel Sheet - TestData */
		
		String ORGNAME = ORG+jUtil.getRandomNumber();
		
		
		// Step 5 : Click on Organizations Link.
		
		HomePage hp= new HomePage(driver);
		hp.clickOnOrgLink();
		
		
		// Step 6 : Click on Organization Look Up Image.
		
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		
		// Step 7 : Create Organization.
		
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME, INDUSTRY);
		
		
		// Step - 8 : Validate.
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getHeaderText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println(OrgHeader);
		
	}
	
	
	@DataProvider
	public Object[][] getData() throws Throwable, IOException
	{
		return eUtil.readMultipleData("MultipleOrg");
		
	}

}
