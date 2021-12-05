package com.crm.SDET25.ContactsTest;

import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;
import com.crm.comcast.GenericUtils.ExcelUtility;
import com.crm.comcast.ObjectRepository.ContactInformationPage;
import com.crm.comcast.ObjectRepository.ContactsPage;
import com.crm.comcast.ObjectRepository.CreateNewContactPage;
import com.crm.comcast.ObjectRepository.HomePage;
/***
 * 
 * @author Vinay_Dasari
 *
 */
public class CreateContactTest extends BaseClass{
	@Test
	public void createContact() throws Throwable {
		//Random Data
		int randomNum =  jLib.getRandomNumber();

		//reading data from Excel
		ExcelUtility exc = new ExcelUtility();
		String contactName = exc.readStringDataFromExcel("Sheet2", 1, 1)+randomNum;
		String mobileNumber = exc.readStringDataFromExcel("Sheet2", 1, 5);

		// Step:1 Create contact
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactImg().click();

		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(contactName, mobileNumber);

		//Step:2 Verify
		ContactInformationPage cip = new ContactInformationPage(driver);
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
		
	}
}
