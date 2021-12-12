package com.crm.SDET25.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DebuggingTest1 {
	
@Test
public void Debug1(){
	String data = "Kishore";
	WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.findElement(By.id("q")).sendKeys(data, Keys.ENTER);
}
}
