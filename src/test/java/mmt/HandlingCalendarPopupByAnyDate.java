package mmt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
/***
 *  This class is used to select the calendar using any Date.
 * @author Vinay_Dasari
 *
 */
public class HandlingCalendarPopupByAnyDate {
	@Test
	public void handlingCalendarPopupUsingAnyDate() throws InterruptedException {
		String monthDayYear ="Jan 30 2022";  // give like this Nov 30 2021
		System.out.println(monthDayYear);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		Actions actions = new Actions(driver);
		actions.click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();

		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

		String path ="//div[contains(@aria-label, '"+monthDayYear+"')]";
		for(;;) {
			try {
				driver.findElement(By.xpath(path)).click();
				break;
			}
			catch(Exception e) {    //Exception is handled using Generalised Exception
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		Thread.sleep(4000);
		driver.quit();
	}
}
