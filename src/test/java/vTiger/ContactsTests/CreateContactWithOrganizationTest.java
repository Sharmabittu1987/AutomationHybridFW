package vTiger.ContactsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationPage;

public class CreateContactWithOrganizationTest extends BaseClass{
	
	@Test
	public void createContactWithOrganizationTest() throws Throwable
	{
		
		/* Create Organization */
		
		// Step 1 : Read all the Necessary Data.
		
		String ORGNAME = eUtil.getDataFromExcel("Contacts", 4, 3)+ jUtil.getRandomNumber();
		String LASTNAME = eUtil.getDataFromExcel("Contacts", 4, 2);
		
		
		// Step 2 : Click on Organizations Link
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		
		
		// Step 3 : Click on Create Organization Look Up Image.
		
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		
		// Step 4 : Create Organization.
		
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);
		
		
		// Step 5 : Validate for Organization.
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getHeaderText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println(OrgHeader);
		
		
		/* Create Contact Using Organization */
		
		
		// Step 6 : Click on Contacts Link. - 500 - Update
		
		hp.clickOnContactsLink();
		
		
		// Step 7 : Navigate to Create Contact Look Up Image.
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImage();
		
		
		// Step 8 : Create a Contact with Mandatory Information.
		
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(driver, LASTNAME, ORGNAME);
		
		
		// Step 9 : Validate for Organization.
		
		ContactInfoPage cip = new ContactInfoPage(driver);
		String ContactHeader = cip.getContactHeader();
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		System.out.println(ContactHeader);
		
	}

}
