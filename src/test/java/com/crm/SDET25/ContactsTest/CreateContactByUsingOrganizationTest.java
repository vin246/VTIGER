package com.crm.SDET25.ContactsTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;
import com.crm.comcast.GenericUtils.ExcelUtility;
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
public class CreateContactByUsingOrganizationTest extends BaseClass{
	@Test
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

		if(orgName.equals(actualOrganizationName)) {
			System.out.println("Organization is Created by "+orgName + "==>Pass");
		}else{
			System.out.println("Organization is not Created by "+ orgName + "==>Fail");
		}

		//Step:3 Create contact using Organization
		hp.getContactsLink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactImg().click();

		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(contactName, mobileNumber, orgName);

		//Step:4 Verify
		if(contactName.equals(driver.findElement(By.id("dtlview_Last Name")).getText())) {
			System.out.println("Contact Name is Verified");
		}else {
			System.out.println("Contact Name is not Verified");
		}

		if(mobileNumber.equals(driver.findElement(By.id("dtlview_Mobile")).getText())) {
			System.out.println("Mobile Number is Verified");
		}else {
			System.out.println("Mobile Number is not Verified");	
		}

	}
}