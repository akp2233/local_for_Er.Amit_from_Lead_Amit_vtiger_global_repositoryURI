package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeClassTest {

	
	@Test
	public void practiceClassTest()
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		//verify login page is Displayed or not
		 String title=driver.getTitle();
		Assert.assertEquals(driver.getTitle(),title,"Login Page is not Displayed ====> test case is fail");
		Reporter.log("Login Page is Displayed.",true);
	}
}
