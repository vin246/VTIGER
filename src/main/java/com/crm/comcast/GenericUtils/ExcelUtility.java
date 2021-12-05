package com.crm.comcast.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/***
 * This class is used to get the data from Excel
 * @author Vinay_Dasari
 *
 */
public class ExcelUtility {
	/**
	 * This method is used to fetch the data from Excel in the form of String.
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readStringDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(file);
		String value = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
	/**
	 * This method is used to fetch the data from Excel in the form of Numeric Value.
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public double readNumericDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(file);
		double value = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
		return value;
	}
	/**
	 * This method is used to fetch the data from Excel in the form of Date.
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Date readDateDataFromExcel(String sheetName, int rowNum, int cellNum ) throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(file);
		Date value = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getDateCellValue();
		return value;
	}
	/**
	 * This method is used to fetch the data from Excel in the form of boolean.
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public boolean readBooleanDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(file);
		boolean value = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getBooleanCellValue();
		return value;
	}
	/**
	 * This method is used to write data to Excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataToExcel(String sheetName, int rowNum, int cellNum, String value) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(file);
		workbook.getSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(value);

		FileOutputStream file2 = new FileOutputStream(IPathConstants.EXCEL_PATH);
		workbook.write(file2);
	}
	/**
	 * This method is used to fetch multiple data from Excel Sheet and return the 2D Object Array
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException  {
		FileInputStream fis = new FileInputStream(IPathConstants.EXCEL_PATH_MULTIPLE_DATA);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] oArr = new Object[rowCount][cellCount];
		for(int i=0; i<rowCount; i++) {
			for(int j=0; j<cellCount; j++) {
				//oArr[i][j]=sheet.getRow(i).getCell(j);
				oArr[i][j]=sheet.getRow(i).getCell(j).toString();  //we can also perform toString() and store the values
			}
		}
		workbook.close();
		return oArr;
	}

	/**
	 * This method is used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		workbook.close();
		return sheet.getLastRowNum();
	}
}