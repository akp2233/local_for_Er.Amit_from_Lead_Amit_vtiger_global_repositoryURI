package com.crm.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

public class BaseClass {
 public DataBaseUtility dblib=new DataBaseUtility();
 public FileUtility flib=new FileUtility();
 public WebDriver driver=null;
 public static WebDriver sdriver;//here we declare WebDriver is static because we want same reference in the script


@BeforeSuite
public void configBS() {
	System.out.println("===connect to DataBase===");
	dblib.getDBConection("htpp://localhost:8888", "Admin", "root");
}

@BeforeClass
public void configBC() throws IOException {
	System.out.println("===Launch the Browser===");
	String browser=flib.getDataFromPropertyFile("browser");
	if(browser.equals("chrome")) {
		driver=new ChromeDriver();
	}else if(browser.equals("firefox")) {
		driver=new FirefoxDriver();
	}else if(browser.equals("edge")) {
		driver=new EdgeDriver();
	}else {
		driver=new FirefoxDriver();
	}	
	sdriver=driver;//store actual driver into static driver we can use driver as same reference
	UtilityClassObject.setDriver(sdriver);
}

@BeforeMethod
public void configBM() throws IOException {
	System.out.println("===login===");
	String url=flib.getDataFromPropertyFile("url");
	String username=flib.getDataFromPropertyFile("username");
	String password=flib.getDataFromPropertyFile("password");
	LoginPage lp=new LoginPage(driver);
	lp.logintoApp(url, username, password);
	
}

@AfterMethod
public void configAM() {
	System.out.println("===Logout===");
	HomePage hp=new HomePage(driver);
	hp.signout();
}

@AfterClass
public void configAC() {
	System.out.println("===close the browser===");
	driver.quit();
}

@AfterSuite
public void configAS() {
	System.out.println("===close DataBase connection");
	dblib.closeDBConnection();
}
}
