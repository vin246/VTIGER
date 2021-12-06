package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
@FindBy (id = "dtlview_Last Name")
private WebElement contactNameInfo;

@FindBy (id = "dtlview_Mobile")
private WebElement mobileNumberInfo;

@FindBy( id = "dtlview_Support End Date")
private WebElement supportEndDate;

	public WebElement getContactNameInfo() {
	return contactNameInfo;
}

public WebElement getMobileNumberInfo() {
	return mobileNumberInfo;
}

	public WebElement getSupportEndDate() {
	return supportEndDate;
}

	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
