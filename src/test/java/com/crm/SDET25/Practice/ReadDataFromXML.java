package com.crm.SDET25.Practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXML {
	@Test
	public void readDataFromExcel(XmlTest xml) {
		System.out.println(xml.getParameter("browser"));
		System.out.println(xml.getParameter("username"));
		System.out.println(xml.getParameter("password"));	
	}
}
