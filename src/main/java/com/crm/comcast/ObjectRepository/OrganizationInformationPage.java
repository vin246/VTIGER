package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "dtlview_Organization Name")
	private WebElement organizationNameInfo;
	
	@FindBy (id = "dtlview_Industry")
	private WebElement industryNameInfo;
	
	@FindBy (id = "dtlview_Type")
	private WebElement typeNameInfo;
	
	@FindBy (id = "dtlview_Phone")
	private WebElement phoneNumberInfo;

	public WebElement getOrganizationNameInfo() {
		return organizationNameInfo;
	}

	public WebElement getIndustryNameInfo() {
		return industryNameInfo;
	}

	public WebElement getTypeNameInfo() {
		return typeNameInfo;
	}

	public WebElement getPhoneNumberInfo() {
		return phoneNumberInfo;
	}

}
