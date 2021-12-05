package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//a[@href=\"index.php?module=Home&action=index\"]")
	private WebElement homeIcon;

	@FindBy (linkText="Calendar")
	private WebElement calendarLink;

	@FindBy (linkText="Leads")
	private WebElement leadsLink;

	@FindBy (linkText="Organizations")
	private WebElement organizationsLink;
	
	@FindBy (linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy (linkText="Opportunities")
	private WebElement opportunitiesLink;

	@FindBy (linkText="Products")
	private WebElement productsLink;

	@FindBy (linkText="Documents")
	private WebElement documentsLink;

	@FindBy (linkText="Email")
	private WebElement emailLink;

	@FindBy (linkText="Trouble Tickets")
	private WebElement troubleTicketsLink;

	@FindBy (linkText="Dashboard")
	private WebElement dashboardLink;

	@FindBy (linkText="More")
	private WebElement moreLink;

	@FindBy (id = "qccombo")
	private WebElement quickCreateDropdown;

	@FindBy (xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement userIcon;

	@FindBy (id = "_my_preferences_")
	private WebElement mypreferencesLink;

	@FindBy (linkText="Sign Out")
	private WebElement signOutLink;

	@FindBy (xpath="//img[@src='themes/softed/images/info.PNG']")
	private WebElement infoIcon;

	@FindBy (linkText="Help")
	private WebElement helpLink;

	@FindBy (linkText="Feedback")
	private WebElement feedbackLink;

	@FindBy (xpath="//img[@src='themes/softed/images/mainSettings.PNG']")
	private WebElement setingsIcon;

	@FindBy (linkText="CRM Settings")
	private WebElement crm_SettingsLink;

	public WebElement getHomeIcon() {
		return homeIcon;
	}

	public WebElement getCalendarLink() {
		return calendarLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getDocumentsLink() {
		return documentsLink;
	}

	public WebElement getEmailLink() {
		return emailLink;
	}

	public WebElement getTroubleTicketsLink() {
		return troubleTicketsLink;
	}

	public WebElement getDashboardLink() {
		return dashboardLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getQuickCreateDropdown() {
		return quickCreateDropdown;
	}

	public WebElement getUserIcon() {
		return userIcon;
	}

	public WebElement getMypreferencesLink() {
		return mypreferencesLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getInfoIcon() {
		return infoIcon;
	}

	public WebElement getHelpLink() {
		return helpLink;
	}

	public WebElement getFeedbackLink() {
		return feedbackLink;
	}

	public WebElement getSetingsIcon() {
		return setingsIcon;
	}

	public WebElement getCrm_SettingsLink() {
		return crm_SettingsLink;
	}

	// Business Class

	public void signOut() {
		mouseOverOnElement(driver, userIcon);
		waitForElementToBeClickable(driver, signOutLink);
		signOutLink.click();
	}

}
