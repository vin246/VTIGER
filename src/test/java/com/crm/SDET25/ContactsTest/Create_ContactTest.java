package com.crm.SDET25.ContactsTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.GenericUtils.BaseClass;
import com.crm.comcast.GenericUtils.ExcelUtility;
import com.crm.comcast.ObjectRepository.ContactInformationPage;
import com.crm.comcast.ObjectRepository.ContactsPage;
import com.crm.comcast.ObjectRepository.CreateNewContactPage;
import com.crm.comcast.ObjectRepository.CreateNewOrganizationPage;
import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.OrganizationInformationPage;
import com.crm.comcast.ObjectRepository.OrganizationPage;
/***
 * 
 * @author Vinay_Dasari
 *
 */
public class Create_ContactTest extends BaseClass{
	SoftAssert sa = new SoftAssert();
	@Test(groups="smoke")
	public void createContact() throws Throwable {
		//Random Data
		int randomNum =  jLib.getRandomNumber();

		//reading data from Excel
		ExcelUtility eLib = new ExcelUtility();
		String contactName = eLib.readStringDataFromExcel("Sheet2", 1, 1)+randomNum;
		String mobileNumber = eLib.readStringDataFromExcel("Sheet2", 1, 5);

		// Step:1 Create contact
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactImg().click();

		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(contactName, mobileNumber);

		//Step:2 Verify
		ContactInformationPage cip = new ContactInformationPage(driver);
		Assert.assertEquals(contactName, cip.getContactNameInfo().getText(), "Contact Name is not Verified ==>Fail");
		sa.assertEquals(mobileNumber, cip.getMobileNumberInfo().getText(), "Mobile Number is not Verified ==>Fail");
	}

	@Test(groups="regression")
	public void createContactUsingOrganization() throws IOException, InterruptedException {
		//Random data
		int randomNum =  jLib.getRandomNumber();

		//Reading data from Excel File
		ExcelUtility eLib = new ExcelUtility();
		String orgName = eLib.readStringDataFromExcel("Sheet2", 2, 0)+randomNum;
		String contactName = eLib.readStringDataFromExcel("Sheet2", 1, 1)+randomNum;
		String mobileNumber = eLib.readStringDataFromExcel("Sheet2", 1, 5);

		//Step:1 Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationImg().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(orgName);

		//Step:2 Verify whether the organization is created ?
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actualOrganizationName = oip.getOrganizationNameInfo().getText();
		Assert.assertEquals(orgName, actualOrganizationName, "Organization is not Created ==> Fail");

		//Step:3 Create contact using Organization
		hp.getContactsLink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactImg().click();

		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(contactName, mobileNumber, orgName);

		//Step:4 Verify
		ContactInformationPage cip = new ContactInformationPage(driver);
		Assert.assertEquals(contactName, cip.getContactNameInfo().getText(), "Contact Name is not Verified ==>Fail");
		sa.assertEquals(mobileNumber, cip.getMobileNumberInfo().getText(), "Mobile Number is not Verified ==>Fail");
	}

	@Test(groups= "regression")
	public void createContactSupportDate() throws Throwable {

		//Random data
		int randomNum =  jLib.getRandomNumber();

		//reading data from Excel
		ExcelUtility eLib = new ExcelUtility();
		String orgName = eLib.readStringDataFromExcel("Sheet2", 1, 0)+randomNum;
		String contactName = eLib.readStringDataFromExcel("Sheet2", 1, 1)+randomNum;
		String mobileNumber = eLib.readStringDataFromExcel("Sheet2", 1, 5);

		//Step:1 Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationImg().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(orgName);

		//Step:2 Verify whether the organization is created ?
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actualOrganizationName = oip.getOrganizationNameInfo().getText();
		Assert.assertEquals(orgName, actualOrganizationName, "Organization is not Created ==> Fail");

		//Step:3 Create contact using Organization
		hp.getContactsLink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactImg().click();

		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		String actualDate = jLib.getSystemDateWithFormat();
		cncp.createContactWithDate(actualDate, contactName, mobileNumber, orgName);

		//Verify
		ContactInformationPage cip = new ContactInformationPage(driver);
		Assert.assertEquals(contactName, cip.getContactNameInfo().getText(), "Contact Name is not Verified ==>Fail");
		sa.assertEquals(mobileNumber, cip.getMobileNumberInfo().getText(), "Mobile Number is not Verified ==>Fail");
		sa.assertEquals(actualDate, cip.getSupportEndDate().getText(), "Entered date is not Verified ==>Fail");

	}
}
