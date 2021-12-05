package com.crm.SDET25.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.ExcelUtility;
/***
 * 
 * @author Vinay_Dasari
 *
 */
public class readingDataFromExcel2 {
	@Test
	public void readDataFromExcel() throws EncryptedDocumentException, IOException {
//		FileInputStream file = new FileInputStream("./data/testData.xlsx");
//		Workbook workbook = WorkbookFactory.create(file);
//		Sheet sheet = workbook.getSheet("Sheet1");
//		System.out.println(sheet.getRow(2).getCell(0).getStringCellValue());
//		System.out.println(sheet.getRow(2).getCell(1).getStringCellValue());
//		System.out.println(sheet.getRow(2).getCell(2).getStringCellValue());
//		System.out.println(sheet.getRow(2).getCell(3).getStringCellValue());
//		
//		System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());
//		System.out.println(sheet.getRow(1).getCell(3).getStringCellValue());
//		System.out.println(sheet.getRow(3).getCell(2).getStringCellValue());
//		System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
		
		ExcelUtility exc= new ExcelUtility();
		String puneet = exc.readStringDataFromExcel("Sheet1", 2, 2);
		System.out.println(puneet);
	}
}
