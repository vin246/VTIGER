package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtils.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{
	WebDriver driver;
	@FindBy (name= "lastname")
	private WebElement lastNameTextField;

	@FindBy (xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement organizationLookUpIcon;

	@FindBy (id = "mobile")
	private WebElement mobileNumberTextField;

	@FindBy (id = "jscal_field_support_end_date")
	private WebElement supportFieldEndDate;

	@FindBy (xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	@FindBy (xpath="//input[@title='Cancel [Alt+X]']")
	private WebElement cancelButton;


	public CreateNewContactPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getOrganizationLookUpIcon() {
		return organizationLookUpIcon;
	}

	public WebElement getMobileNumberTextField() {
		return mobileNumberTextField;
	}

	public WebElement getSupportFieldEndDate() {
		return supportFieldEndDate;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	//Business Logic 

	public void createContact(String contactName) {
		lastNameTextField.sendKeys(contactName);
		saveButton.click();
	}

	public void createContact(String contactName, String mobileNumber) {
		lastNameTextField.sendKeys(contactName);
		mobileNumberTextField.sendKeys(mobileNumber);
		saveButton.click();	
	}
	/**
	 * This method is used to create a Contact using Organization
	 * @param contactName
	 * @param mobileNumber
	 * @param orgName
	 */
	public void createContact(String contactName, String mobileNumber, String orgName) {
		lastNameTextField.sendKeys(contactName);
		mobileNumberTextField.sendKeys(mobileNumber);
		organizationLookUpIcon.click();
		switchToWindow(driver, "Accounts");
		OrganizationPage op = new OrganizationPage(driver);
		op.getSearchTextField().sendKeys(orgName);
		op.getSearchButton().click();
		driver.findElement(By.linkText(orgName)).click();
		switchToWindow(driver, "Contacts");
		saveButton.click();	
	}
	/**
	 * This is used to create a Contact with Support Date 
	 * @param date
	 * @param contactName
	 * @param mobileNumber
	 * @param orgName
	 */
	public void createContactWithDate(String date, String contactName, String mobileNumber, String orgName) {
		lastNameTextField.sendKeys(contactName);
		mobileNumberTextField.sendKeys(mobileNumber);
		organizationLookUpIcon.click();
		switchToWindow(driver, "Accounts");
		OrganizationPage op = new OrganizationPage(driver);
		op.getSearchTextField().sendKeys(orgName);
		op.getSearchButton().click();
		driver.findElement(By.linkText(orgName)).click();
		switchToWindow(driver, "Contacts");
		supportFieldEndDate.clear();
		supportFieldEndDate.sendKeys(date);
		saveButton.click();	
	}

}