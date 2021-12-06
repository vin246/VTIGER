package com.crm.comcast.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

/***
 * 
 * @author Vinay_Dasari
 *
 */
public class JavaUtility {
	/**
	 * This method is used to get the Random Number
	 * @return  (It will return the Random Number)
	 */
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(10000);
		return randomNumber;
	}
	/**
	 * This method is used to get the System Date and Time Object
	 * @return
	 */
	public Date getSystemDateAndTime() {
		Date dateObj = new Date();
		return dateObj;
	}
	/**
	 * This is used to get the System Date in YYYY-MM-DD format
	 * @return
	 */
	public String getSystemDateWithFormat() {
		Date dateObj = new Date();
		int day = dateObj.getDate();
		int month = dateObj.getMonth()+1;
		String year = dateObj.toString().split(" ")[5];
		String yyyymmdd = year+"-"+month+"-"+day;
		return yyyymmdd;
	}
	
	public void pressVirtualEnterKey() throws AWTException{
		Robot robot =  new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
