package com.crm.SDET25.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.ExcelUtility;

public class ReadMultipleDataFromExcelUsingDataProvider {
	@DataProvider(name="data")
	public Object[][] getMultipleDataFromExcel() throws EncryptedDocumentException, IOException {
		ExcelUtility eUtil = new ExcelUtility();
		return eUtil.readMultipleData("Sheet1");
	}
	@Test(dataProvider="data")
	public void readMultipleDataFromExcel(String s1, String s2) {
		System.out.println(s1+"        "+s2);
	}
}
