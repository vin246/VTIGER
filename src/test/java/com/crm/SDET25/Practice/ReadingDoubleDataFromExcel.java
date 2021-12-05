package com.crm.SDET25.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
/***
 * 
 * @author Vinay_Dasari
 *
 */
public class ReadingDoubleDataFromExcel {
	@Test
	public void readingDoubleDataFromExcel() throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("./data/testData.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		double value = workbook.getSheet("Sheet1").getRow(4).getCell(2).getNumericCellValue();
		int val2 = (int) value;
		System.out.println(val2);
		
		//reading Boolean Data
		boolean booleanValue = workbook.getSheet("Sheet1").getRow(4).getCell(1).getBooleanCellValue();
		System.out.println(booleanValue);
	}
}
