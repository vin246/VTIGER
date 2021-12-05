package com.crm.comcast.OrganizationTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;
import com.crm.comcast.GenericUtils.ExcelUtility;
import com.crm.comcast.ObjectRepository.CreateNewOrganizationPage;
import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.OrganizationInformationPage;
import com.crm.comcast.ObjectRepository.OrganizationPage;

public class CreateOrganizationWithTwoDropdownsTest extends BaseClass{
	@Test
	public void createOrganizationWithEducationAndTypeDropdown() throws IOException, InterruptedException {
		//Random data
		int randomNum =  jLib.getRandomNumber();

		//Reading data from Excel File
		ExcelUtility eLib = new ExcelUtility();
		String orgName = eLib.readStringDataFromExcel("Sheet2", 2, 0)+randomNum;
		String industryDropdown = eLib.readStringDataFromExcel("Sheet2", 10, 2);
		String typeDropdown = eLib.readStringDataFromExcel("Sheet2", 7, 3);

		//Step:1 Create Organization using Industry and Type Dropdown
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationImg().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(orgName, industryDropdown, typeDropdown);
		
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		
		//Step:2 Verify
		
		if(orgName.equals(oip.getOrganizationNameInfo().getText())) {
			System.out.println("Organization is Created by "+orgName + "==>Pass");
		}else {
			System.out.println("Organization is not Created" + "==>Fail");
		}

		if(industryDropdown.equals(oip.getIndustryNameInfo().getText())) {
			System.out.println("Industry dropdown is verified" + "==>Pass");
		}else {
			System.out.println("Industry dropdown is not verified" + "==>Fail");
		}

		if(typeDropdown.equals(oip.getTypeNameInfo().getText())) {
			System.out.println("Type dropdown is verified" + "==>Pass");
		}else {
			System.out.println("Type dropdown is verified" + "==>Fail");
		}
	}
}