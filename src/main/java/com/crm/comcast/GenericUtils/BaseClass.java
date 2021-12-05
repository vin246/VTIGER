package com.crm.comcast.GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public JavaUtility jLib = new JavaUtility();
	public FileUtility fLib = new FileUtility();
	
	public WebDriverUtility wLib = new WebDriverUtility();
	
	//Read data from Property File
	String BROWSER = fLib.readDataFromPropertyFile("browser");
	String URL = fLib.readDataFromPropertyFile("url");
	String USERNAME = fLib.readDataFromPropertyFile("username");
	String PASSWORD = fLib.readDataFromPropertyFile("password");
	
	@BeforeSuite
	public void beforeSuiteConfig() {
		System.out.println("Before Suite Config :>>> Establishing DataBase Connection");
		System.out.println();
	}
	@BeforeTest
	public void beforeTestConfig() {
		System.out.println("Before Test Config :>>> Related to Test Tag");
	}

	@BeforeClass
	public void launchingTheBrowser() {
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}else {
			System.out.println("Invalid Browser Argument");
		}
		driver.manage().window().maximize();	
		wLib.waitForPageToLoad(driver);	
	}
	
	@BeforeMethod
	public void logintoApplication() {
		LoginPage lp =  new LoginPage(driver);
		lp.loginToApplication(URL, USERNAME, PASSWORD);
	}
	
	@AfterMethod
	public void logoutFromTheApplication() {
		HomePage hp = new HomePage(driver);
		hp.signOut();
	}
	
	@AfterClass
	public void closingTheBroswer() {
		driver.quit();	
	}
	
	@AfterTest
	public void afterTestConfig() {
		System.out.println("After Test Config :>>> Related to Test Tag");
	}
	
	@AfterSuite
	public void afterSuiteConfig() {
		System.out.println("After Suite Config :>>> Closing DataBase Connection");
	}
}
