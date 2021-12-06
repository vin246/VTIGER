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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.LoginPage;

public class BaseClass {
	public static WebDriver sdriver;
	public  WebDriver driver;
	public JavaUtility jLib = new JavaUtility();
	public FileUtility fLib = new FileUtility();

	public WebDriverUtility wLib = new WebDriverUtility();

	//Read data from Property File
	//String BROWSER = fLib.readDataFromPropertyFile("browser");
	String URL = fLib.readDataFromPropertyFile("url");
	String USERNAME = fLib.readDataFromPropertyFile("username");
	String PASSWORD = fLib.readDataFromPropertyFile("password");

	@BeforeSuite(groups= {"smoke", "regression"})
	public void beforeSuiteConfig() {
		System.out.println("Before Suite Config :>>> Establishing DataBase Connection");
		System.out.println();
	}
	@BeforeTest(groups= {"smoke", "regression"})
	public void beforeTestConfig() {
		System.out.println("Before Test Config :>>> Related to Test Tag");
	}

	@Parameters("BROWSER")
	@BeforeClass(groups= {"smoke", "regression"})
	public void launchingTheBrowser(@Optional("chrome")  String BROWSER) {
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}else {
			System.out.println("Invalid Browser Argument");
		}
		sdriver = driver;
		driver.manage().window().maximize();	
		wLib.waitForPageToLoad(driver);	
	}

	@BeforeMethod(groups= {"smoke", "regression"})
	public void logintoApplication() {
		LoginPage lp =  new LoginPage(driver);
		lp.loginToApplication(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups= {"smoke", "regression"})
	public void logoutFromTheApplication() {
		HomePage hp = new HomePage(driver);
		hp.signOut();
	}

	@AfterClass(groups= {"smoke", "regression"})
	public void closingTheBroswer() {
		driver.quit();	
	}

	@AfterTest(groups= {"smoke", "regression"})
	public void afterTestConfig() {
		System.out.println("After Test Config :>>> Related to Test Tag");
	}

	@AfterSuite(groups= {"smoke", "regression"})
	public void afterSuiteConfig() {
		System.out.println("After Suite Config :>>> Closing DataBase Connection");
	}
}
