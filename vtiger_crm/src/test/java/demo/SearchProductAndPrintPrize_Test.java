package demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.flipkkart.genericUtility.ExcelUtility;

public class SearchProductAndPrintPrize_Test {
	ExcelUtility exutil = new ExcelUtility();
	WebDriver driver;

	@Test
	public void capturePrizeOfProductsTest() throws EncryptedDocumentException, IOException {
		
		//capture the data from Property file and Remove the HardCoding inside My test Script
		//fetch application url 
		FileInputStream fisf=new FileInputStream("./src/test/resources/testdata/flipkart.properties");
		Properties pro =new Properties();
		pro.load(fisf);
		String url = pro.getProperty("url");
		
		//read the data from excelFile
		FileInputStream fise=new FileInputStream("./src/test/resources/testdata/Book1.xlsx");
		Workbook wb1 = WorkbookFactory.create(fise);
		String product1 = wb1.getSheet("Flipkart").getRow(1).getCell(0).getStringCellValue();
		String product2 = wb1.getSheet("Flipkart").getRow(2).getCell(0).getStringCellValue();
		String product3 = wb1.getSheet("Flipkart").getRow(3).getCell(0).getStringCellValue();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		//write xpath for searchBox text field 
		WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
		
		//enter first Product and capture price
		searchBox.sendKeys(product1, Keys.ENTER);
		WebElement firstElement = driver.findElement(By.xpath("//div[contains(text(),'Apple iPhone')]/ancestor::div[@class='yKfJKb row']/descendant::div[@class='Nx9bqj _4b5DiR']"));
		String firstProductPrice = firstElement.getText();
		
		//enter second product and capture the price
		searchBox.clear();
		searchBox.sendKeys(product2,Keys.ENTER);
//		WebElement secondElement = driver.findElement(By.xpath("//a[@class='WKTcLC']/..//div[contains(text(),'₹')]"));
		//String secondProductPrice = secondElement.getText();
		
		//enter third product and capture the price
		searchBox.clear();
//		searchBox.sendKeys(product3,Keys.ENTER);
//		WebElement thirdElement = driver.findElement(By.xpath("//a[@class='wjcEIp']/..//div[contains(text(),'₹')]"));
		//String thirdProductPrice = thirdElement.getText();
		
		//write the data into excel
		Sheet sh = wb1.getSheet("Flipkart");
		Row row = sh.createRow( 1);
		Cell cell = row.createCell(0);
		cell.setCellValue(firstProductPrice);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/testdata/Book1.xlsx");
		wb1.write(fos);
		wb1.close();
		
		
//		//write xpath for product price
//		List<WebElement> priceList = driver
//				.findElements(By.xpath("//div[contains(text(),'Apple iPhone 16')]/../..//div[contains(text(),'₹')]"));
//		
//		for (int i = 0; i < 3; i++) {
//			String price = priceList.get(i).getText();
//			FileInputStream fis = new FileInputStream("./src/test/resources/testdata/Book1.xlsx");
//			Workbook wb = WorkbookFactory.create(fis);
//			Sheet sh = wb.getSheet("Flipkart");
//			Row row = sh.createRow(i + 1);
//			Cell cell = row.createCell(0);
//			cell.setCellValue(price);
//			FileOutputStream fos = new FileOutputStream("./src/test/resources/testdata/Book1.xlsx");
//			wb.write(fos);
//			wb.close();
	
		driver.close();
		}

	
	}

