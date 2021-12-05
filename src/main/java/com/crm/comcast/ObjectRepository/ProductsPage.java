package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//img[@title='Create Product...'']")
		private WebElement createProduct;

	public WebElement getCreateProduct() {
		return createProduct;
	}
	
	@FindBy(name="productname")
	private WebElement productName;

	public WebElement getProductName() {
		return productName;
	}
	
	
	
}
