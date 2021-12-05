package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtils.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy (name= "accountname")
	private WebElement organizationNameTextField;

	@FindBy (name= "industry")
	private WebElement industryDropdown;

	@FindBy (name= "accounttype")
	private WebElement typeDropdown;

	@FindBy (xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	@FindBy (xpath="//input[@title='Cancel [Alt+X]']")
	private WebElement cancelButton;

	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}
/**
 * This method is used to create an Organization using Organization Name
 * @param orgName
 */
	public void createOrganization(String orgName) {
		organizationNameTextField.sendKeys(orgName);
		saveButton.click();
	}
	/**
	 * This method is used to create an Organization using Organization Name & Industry Dropdown
	 * @param orgName
	 * @param industry
	 */
	public void createOrganization(String orgName, String industry) {
		organizationNameTextField.sendKeys(orgName);
		select(industryDropdown, industry);
		saveButton.click();
	}
	
	/**
	 * This method is used to Create an Organization using Organization Name, Indusry Dropdown & Type Dropdown
	 * @param orgName
	 * @param industry
	 * @param type
	 */
	public void createOrganization(String orgName, String industry, String type) {
		organizationNameTextField.sendKeys(orgName);
		select(industryDropdown, industry);
		select(typeDropdown, type);
		saveButton.click();
	}
}
