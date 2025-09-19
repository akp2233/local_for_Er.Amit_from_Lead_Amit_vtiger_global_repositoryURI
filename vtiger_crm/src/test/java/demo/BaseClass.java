package demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
@BeforeSuite
public void configbs() {
	System.out.println("before suuite");
}
@BeforeTest
public void configbt() {
	System.out.println("before test");
}
@BeforeClass
public void configbc() {
	System.out.println("before class");
	
}
@BeforeMethod
public void conficbm() {
	System.out.println("before method");
}
@AfterMethod
public void configam() {
	System.out.println("after method");
}
@AfterClass
public void configac() {
	System.out.println("afetr mehtod");
}
@AfterTest
public void configat() {
	System.out.println("after test");
}
@AfterSuite
public void configas() {
	System.out.println("afetr suite");
}
}
