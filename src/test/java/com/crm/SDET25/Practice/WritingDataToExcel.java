package com.crm.SDET25.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
public class WritingDataToExcel {
	@Test
	public void writingDataToExcel() throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./data/testData.xlsx");

		Workbook workbook = WorkbookFactory.create(file);

		/*Sheet sheet = workbook.getSheet("Sheet1");

		Row row = sheet.getRow(5);

		Cell cell = row.createCell(0);

		cell.setCellValue("HII");

		FileOutputStream file2 = new FileOutputStream("./data/testData.xlsx");
		workbook.write(file2);
		workbook.close();*/
		workbook.getSheet("Sheet1").createRow(5).createCell(2).setCellValue("Vinay");
		FileOutputStream file2 = new FileOutputStream("./data/testData.xlsx");
		workbook.write(file2);
		workbook.close();
	}

}
