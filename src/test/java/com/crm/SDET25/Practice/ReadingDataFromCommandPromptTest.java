package com.crm.SDET25.Practice;

import org.testng.annotations.Test;

public class ReadingDataFromCommandPromptTest {
	@Test
	public void readDataFromCommandPrompt() {
		String url = System.getProperty("url");
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}
}
