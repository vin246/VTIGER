package com.crm.SDET25.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
/***
 * 
 * @author Vinay_Dasari
 *
 */
public class readingDataFromExcel1 {
	@Test
	public void readDataDFromExcel() throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./data/testData.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(2);
		Cell cell = row.getCell(0);
		String value = cell.getStringCellValue();
		System.out.println(value);
	}
}
