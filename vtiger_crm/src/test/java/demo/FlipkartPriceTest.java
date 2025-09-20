package demo;



import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.genericUtility.ExcelUtility;

public class FlipkartPriceTest {
	
//	ExcelUtility eutil=new ExcelUtility();

	@Test(dataProvider = "getData")
	public void flipkartPriceTest(String productname,String brandname,int rowIndex) throws IOException
	{
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(brandname,Keys.ENTER);
		
		String price=driver.findElement(By.xpath("//div[text()='"+productname+"']/ancestor::div[@class='yKfJKb row']/descendant::div[contains(text(),'₹')]")).getText();
		//String price = driver.findElement(By.xpath("//div[text()='"+productname+"']/../..//div[contains(text(),'₹')]")).getText();
		System.out.println(brandname+"  price : "+price);
		
		ExcelUtility eutil=new ExcelUtility();

		eutil.setDataIntoExcel("Flipkart",rowIndex,2, price);
		
		driver.close();
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		ExcelUtility eutil=new ExcelUtility();

		int rowCount=eutil.getRowCount("Flipkart");
		
		Object[][] obj=new Object[rowCount][3];
		
		for(int i=0;i<rowCount;i++)
		{
			obj[i][0]=eutil.getDataFromExcelFile("Flipkart", i+1,0);
			
			obj[i][1]=eutil.getDataFromExcelFile("Flipkart", i+1,1);
			
			obj[i][2]=i+1;
		}
	
		return obj;
	}
}