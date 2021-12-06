package com.crm.comcast.OrganizationTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
public class Create_OrganizationTest extends BaseClass{
	ExcelUtility eLib = new ExcelUtility();
	HomePage hp = new HomePage(sdriver);
	OrganizationPage op = new OrganizationPage(driver);
	CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
	OrganizationInformationPage oip = new OrganizationInformationPage(driver);
	SoftAssert sa = new SoftAssert();
	
	@Test(groups= {"smoke"})
	public void createOrganization() throws IOException, InterruptedException {
		//Random data
		int randomNum =  jLib.getRandomNumber();

		//Reading data from Excel File
		String orgName = eLib.readStringDataFromExcel("Sheet2", 2, 0)+randomNum;

		//Step:1 Create Organization
		hp.getOrganizationsLink().click();
		op.getCreateOrganizationImg().click();
		cnop.createOrganization(orgName);

		//Step:2 Verify whether the organization is created
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actualOrganizationName = oip.getOrganizationNameInfo().getText();
		Assert.assertEquals(orgName, actualOrganizationName, "Organization is not Created by "+ orgName + "==>Fail");
	}

	@Test(groups="regression")
	public void createOrganizationWithEducationAndTypeDropdown() throws IOException, InterruptedException {
		//Random data
		int randomNum =  jLib.getRandomNumber();

		//Reading data from Excel File
		String orgName = eLib.readStringDataFromExcel("Sheet2", 2, 0)+randomNum;
		String industryDropdown = eLib.readStringDataFromExcel("Sheet2", 10, 2);
		String typeDropdown = eLib.readStringDataFromExcel("Sheet2", 7, 3);

		//Step:1 Create Organization using Industry and Type Dropdown
		hp.getOrganizationsLink().click();
		op.getCreateOrganizationImg().click();
		cnop.createOrganization(orgName, industryDropdown, typeDropdown);
		
		//Step:2 Verify
		Assert.assertEquals(orgName, oip.getOrganizationNameInfo().getText(), "Organization is not Created" + "==>Fail");
		sa.assertEquals(industryDropdown, oip.getIndustryNameInfo().getText(), "Industry dropdown is not verified" + "==>Fail");
		sa.assertEquals(typeDropdown, oip.getTypeNameInfo().getText(), "Type dropdown is verified" + "==>Fail");
		sa.assertAll();
	}
}