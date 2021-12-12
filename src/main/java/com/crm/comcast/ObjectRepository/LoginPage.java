package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy (name="user_name")
	private WebElement usernameTextField;
	
	@FindBy (name="user_password")
	private WebElement passwordTextField;
	
	@FindBy (id="submitButton")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this); //this is used to represent current class
	}

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}


	public WebElement getPasswordTextField() {
		return passwordTextField;
	}


	public WebElement getLoginButton() {
		return loginButton;
	}


	//Business Logic
	/**
	 * function to Login to Application sing default credentials
	 */
	public void loginToApplication() {
		//driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		usernameTextField.sendKeys("admin");
		passwordTextField.sendKeys("admin");
		loginButton.click();	
	}
	/**
	 * This function is used to Login to the Application by using Url Username and Password Details
	 * @param url
	 * @param username
	 * @param password
	 */
	public void loginToApplication(String url, String username, String password) {
		driver.get(url);
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();	
	}	
	}
