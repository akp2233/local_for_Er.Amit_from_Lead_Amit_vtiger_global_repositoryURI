package com.crm.genericUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
	/**
	 * @author dk
	 * this class helps to share my static variable into multiple Thread during Parallel 
	* we declare WebDriver as static inside Base class and ExtentTest inside ListnereUtility 
	* we declare as static because we want same instance in all script 
	* if as a static variable we go for parallel execution is not happening thats why use 
	* ThreadLocal class create 
	 */
public static ThreadLocal<ExtentTest>test=new ThreadLocal<ExtentTest>();
public static ThreadLocal<WebDriver>driver=new ThreadLocal<WebDriver>();
 

public static ExtentTest getTest() {
	return test.get();
}
public static void setTest(ExtentTest actTest) {
	test.set(actTest);
}


public static WebDriver getDriver() {
	return driver.get();
}
public static void setDriver(WebDriver actDriver) {
	driver.set(actDriver);
}
}
