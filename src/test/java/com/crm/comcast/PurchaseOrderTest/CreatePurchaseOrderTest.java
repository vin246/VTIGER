package com.crm.comcast.PurchaseOrderTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.ExcelUtility;
import com.crm.comcast.GenericUtils.FileUtility;
import com.crm.comcast.GenericUtils.WebDriverUtility;
import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.LoginPage;

public class CreatePurchaseOrderTest {
	@Test
	public void createPurchaseOrder() throws IOException {

		//read data from Property File
		FileUtility fLib = new FileUtility();
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		
		//read data from Excel
		ExcelUtility eLib = new ExcelUtility();
		String subject = eLib.readStringDataFromExcel("PO", 1, 0);
		String mobileNumber = eLib.readStringDataFromExcel("PO", 1, 1);
		String productName = eLib.readStringDataFromExcel("PO", 1, 3);

		WebDriverUtility wLib = new WebDriverUtility();
		
		//creating Global Object for driver
		WebDriver driver = null;
		
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		//Launching the browser
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}else {
			System.out.println("Invalid Browser Argument");
		}

		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);
		
		//login to Application
		lp.loginToApplication(URL, USERNAME, PASSWORD);
		
		
		//create a Product
		hp.getProductsLink().click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productName);
		
		driver.findElement(By.name("button")).click();
		
		/*WebElement moreElement = driver.findElement(By.linkText("More"));
		wLib.mouseOverOnElemnet(driver, moreElement);
		driver.findElement(By.name("Purchase Order")).click();
		
		//create new Purchase Order
		driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();
		driver.findElement(By.name("subject")).sendKeys(subject);
		*/
	}
}
