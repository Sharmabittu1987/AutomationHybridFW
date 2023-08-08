package vTiger.OrganizationsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationPage;

public class CreateOrganizationWithIndustryTest extends BaseClass{
	
	@Test
	public void createOrganizationWithIndustryTest() throws Throwable, Throwable
	{
		
		/* Create Organization */
		
		
		// Step 1 : Read all the Necessary Data.
		
		String ORGNAME = eUtil.getDataFromExcel("Organization", 5, 2)+ jUtil.getRandomNumber();
		String LASTNAME = eUtil.getDataFromExcel("Organization", 5, 3);
		
		
		// Step 2 : Click on Organizations Link.
		
		HomePage hp= new HomePage(driver);
		hp.clickOnOrgLink();
		
		
		// Step 3 : Click on Create Organization Look Up Image.
		
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		
		// Step 4 : Create Organization.
		
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME, LASTNAME);
		
		
		// Step 5 : Validate.
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getHeaderText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println(OrgHeader);
		
	}
	

}
