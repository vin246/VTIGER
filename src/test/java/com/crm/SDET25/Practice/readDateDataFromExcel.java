package com.crm.SDET25.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
/***
 * 
 * @author Vinay_Dasari
 *
 */
public class readDateDataFromExcel {
	@Test
	public void readingDateDataFromExcelSheet() throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./data/testData.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Date value = workbook.getSheet("Sheet1").getRow(4).getCell(0).getDateCellValue();
		System.out.println(value);
		
		int val1 = workbook.getActiveSheetIndex();
		System.out.println(val1);
		Date val2 = workbook.getSheetAt(0).getRow(4).getCell(0).getDateCellValue();
		System.out.println(val2);
		int dt = val2.getDate();
		System.out.println(dt);
		LocalDateTime date = workbook.getSheet("Sheet1").getRow(4).getCell(0).getLocalDateTimeCellValue();
		System.out.println(date);
	}
}
