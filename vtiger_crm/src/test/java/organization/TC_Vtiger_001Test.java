package organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.genericUtility.WebDriverUtility;
import com.crm.objectRepository.LoginPage;

public class TC_Vtiger_001Test {
	WebDriver driver=null;
	@Test
	public void loginToVtigerapplicationTest() {
		
		//capture the input data in run time via cmd line and use this data in script
		String browser = System.getProperty("browser");
		String url = System.getProperty("url");
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		
		//choosing browser from user site 
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}else {
			driver=new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		//give implicit time using reusable method because hardcoding is not allow in automation
		WebDriverUtility wu=new WebDriverUtility();
		wu.waitForPageToLoad(driver);
		
		//create object of login page because we want a element which are present in login page 
		//user text field,password test field,login button here we are using pom design technique
		//to store the current address of webElement and avoid StaleElementRefrenceException
		LoginPage lp=new LoginPage(driver);
		lp.getusernametextfield().clear();
		lp.getusernametextfield().sendKeys(username);//give by the user in runtime using cmd line
		
		lp.getpasswordtextfield().clear();
		lp.getpasswordtextfield().sendKeys(password);//give by the user in run time
		lp.getloginbutton().click();
		
		
		
	}

}
