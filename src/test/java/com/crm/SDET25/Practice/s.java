package com.crm.SDET25.Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.crm.comcast.GenericUtils.ITestListenerImplementation.class)
public class s {
@Test
public void s1() {
	System.out.println("hiii");
	//Assert.assertEquals(true, false);
	System.out.println(1/0);
	System.out.println("Hlo");
}
}
