package com.crm.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;

public class ExcelUtility {
	/**
	 * @author dk
	 * this method is used to fetch the data from excel file take sheetname,rownum ,cellnum from user 
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return String ,because it return a data from to excel
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcelFile(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata/scriptMultipleData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
	}
	/**
	 * @author dk
	 * this method is used to find the number of row which are used 
	 * @param sheetname
	 * @return type is int because its return how many rows we are used in excel
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata/scriptMultipleData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		int lastrowcount = sheet.getLastRowNum();
		return lastrowcount;
		
	}
	/**
	 * @author dk
	 * this method is used to fetch the number of used /column ,cell in specific row 
	 * @param sheetname
	 * @param rowcount
	 * @return type is int because its return used number of column in particular row index
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getcellCount(String sheetname,int rowcount) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata/scriptMultipleData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		Row row = sheet.getRow(rowcount);
		int cellcount = row.getLastCellNum();
		return cellcount;
	}
	public List<String> getMultipleDataFromExcel(String sheetname) throws EncryptedDocumentException, IOException {
		List<String>alldata=new ArrayList<>();
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata/scriptMultipleData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		for(int i=1;i<=rowcount;i++) {//this loop use for row 
			Row row = sheet.getRow(i);
			int cellcount = row.getLastCellNum();
			for(int j=0;j<cellcount;j++) {
				String data = row.getCell(j).toString();
				alldata.add(data);
			}
		}
		return alldata;
		
	}
	@SuppressWarnings("deprecation")
	public void setDataIntoExcel(String sheetname,int rownum,int cellnum,String price) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata/scriptMultipleData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetname).getRow(rownum).createCell(cellnum);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(price);
		 FileOutputStream fos=new FileOutputStream("./src/test/resources/testdata/scriptMultipleData.xlsx");
		 wb.write(fos);
		 wb.close();
	
	}
}
