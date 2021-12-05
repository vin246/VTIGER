package com.crm.comcast.OrganizationTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;
import com.crm.comcast.GenericUtils.ExcelUtility;
import com.crm.comcast.ObjectRepository.CreateNewOrganizationPage;
import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.OrganizationInformationPage;
import com.crm.comcast.ObjectRepository.OrganizationPage;
/***
 * 
 * @author Vinay_Dasari
 *
 */
public class CreateOrganizationTest extends BaseClass{
	@Test
	public void createOrganization() throws IOException, InterruptedException {
		//Random data
		int randomNum =  jLib.getRandomNumber();

		//Reading data from Excel File
		ExcelUtility eLib = new ExcelUtility();
		String orgName = eLib.readStringDataFromExcel("Sheet2", 2, 0)+randomNum;

		//Step:1 Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationImg().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(orgName);

		//Step:2 Verify whether the organization is created
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actualOrganizationName = oip.getOrganizationNameInfo().getText();

		if(orgName.equals(actualOrganizationName)) {
			System.out.println("Organization is Created by "+orgName + "==>Pass");
		}else{
			System.out.println("Organization is not Created by "+ orgName + "==>Fail");
		}
	}
}