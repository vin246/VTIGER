package com.crm.SDET25.Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadingMultipleData {
	@Test
	public void readMultipleDataFromExcel() throws Throwable {

		FileInputStream fis = new FileInputStream("./data/multipleData.xlsx");

		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");

		int rowCount = sheet.getLastRowNum();
		int rowC = sheet.getPhysicalNumberOfRows();

		int cellCount = sheet.getRow(0).getLastCellNum();
		int cellC = sheet.getRow(0).getPhysicalNumberOfCells();

		System.out.println(rowCount);
		System.out.println(rowC);
		System.out.println(cellCount);
		System.out.println(cellC);

		Object[][] objArr = new Object[rowCount][cellCount];
		for(int i=0; i<rowC; i++) {
			for(int j=0; j<cellC;j++ ) {
				//objArr[i][j]=sheet.(i).getCell(j);/*.toString();
				//System.out.println(sheet.getRow(i).getCell(j));
				objArr[i][j]= sheet.getRow(i).getCell(j);
			}
		}
		
		//		ExcelUtility ut = new ExcelUtility();
		//		Object[][] objArr = ut.readMultipleData("Sheet1");
		for(Object[] arr:objArr ) {
			for(Object val : arr) {
				System.out.println(val.toString());
			}
		}
	}
}
