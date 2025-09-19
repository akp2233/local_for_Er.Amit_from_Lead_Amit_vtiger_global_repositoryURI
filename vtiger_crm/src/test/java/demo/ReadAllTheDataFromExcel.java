package demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadAllTheDataFromExcel {
@Test
public void readDataFromExcel() throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./src/test/resources/testdata/scriptMultipleData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("contacts");
	int rowcount = sheet.getLastRowNum();
	
	for(int i=0;i<=rowcount;i++) {
		Row row = sheet.getRow(i);
		int cellcount = row.getLastCellNum();
		for(int j=0;j<cellcount;j++) {
			String cell = row.getCell(j).toString();
			if(cell.equals(CellType.BLANK)) {
				System.out.println("null");
			}else {
				System.out.println(cell+"\t");
			}
		}
		System.out.println();
	}
}
}
