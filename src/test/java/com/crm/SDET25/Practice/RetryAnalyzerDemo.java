package com.crm.SDET25.Practice;

import org.testng.annotations.Test;

public class RetryAnalyzerDemo {
	@Test(retryAnalyzer=com.crm.comcast.GenericUtils.IRetryAnalyzerImplementation.class)
	public void Demo1() {
		System.out.println("Hii");
		System.out.println("Hlo");
		int i=1/0;
		System.out.println("Bye");
	}
	@Test(retryAnalyzer=com.crm.comcast.GenericUtils.IRetryAnalyzerImplementation.class)
	public void Demo2() {
		System.out.println("Kishore");
		int i=1/0;
		System.out.println("Pramod");
		int j=i+1;
		System.out.println("Harsha");
		System.out.println("Vinay");
	}
}
