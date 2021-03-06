package com.crm.SDET25.ContactsTest;

import org.testng.annotations.Test;

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
public class CreateContactSupport_DateTest extends BaseClass{
	@Test
	public void createContactSupportDate() throws Throwable {

		//Random data
		int randomNum =  jLib.getRandomNumber();

		//reading data from Excel
		ExcelUtility exc = new ExcelUtility();
		String orgName = exc.readStringDataFromExcel("Sheet2", 1, 0)+randomNum;
		String contactName = exc.readStringDataFromExcel("Sheet2", 1, 1)+randomNum;
		String mobileNumber = exc.readStringDataFromExcel("Sheet2", 1, 5);
		
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
		String actualDate = jLib.getSystemDateWithFormat();
		cncp.createContactWithDate(actualDate, contactName, mobileNumber, orgName);
		ContactInformationPage cip = new ContactInformationPage(driver);
		
		//Verify
		if(contactName.equals(cip.getContactNameInfo().getText())) {
			System.out.println("Contact Name is Verified");
		}else {
			System.out.println("Contact Name is not Verified");
		}

		if(mobileNumber.equals(cip.getMobileNumberInfo().getText())) {
			System.out.println("Mobile Number is Verified");
		}else {
			System.out.println("Mobile Number is not Verified");	
		}

		if(actualDate.contains(cip.getSupportEndDate().getText())) {
			System.out.println("Entered date is verified");
		}else {
			System.out.println("Entered date is not Verified");
		}

	}
}