package mmt;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
/***
 *  This class is used to select the calendar using always Tomorrow's Date.
 * @author Vinay_Dasari
 *
 */
public class HandlingCalendarPopupByTomorrowsDate {
	@Test
	public void hanlingCalendarPopupUsingTomorrowsDate() throws InterruptedException {
		LocalDateTime ldt = LocalDateTime.now().plusDays(1);
		int day = ldt.getDayOfMonth();
		String month = ldt.getMonth().name();
		int year = ldt.getYear();
		
		String monthDayYear = month.substring(0, 1)+month.substring(1, 3).toLowerCase()+" "+day+" "+year;
		
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
		driver.findElement(By.xpath(path)).click();
		
		Thread.sleep(4000);
		driver.quit();
	}
}
