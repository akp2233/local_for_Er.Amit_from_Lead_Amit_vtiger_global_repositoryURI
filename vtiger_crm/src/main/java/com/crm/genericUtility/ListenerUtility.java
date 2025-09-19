package com.crm.genericUtility;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


/**
 * @author  dk
 * 
 * This class contains all listener implementation overridden methods at test and suite level.
 */
public class ListenerUtility extends BaseClass  implements ITestListener,ISuiteListener {

	public static ExtentReports report;
	
	public static ExtentTest test;
	
	/**
	 * @author  dk
	 * 
	 * This method contains all configurations before executing any suite file.
	 */
	@Override
	public void onStart(ISuite suite) {
		
//		System.out.println("Report Configuration");
		
		String time= LocalDateTime.now().toString().replace(":", "_");

		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/report_"+time+".html");
		
		spark.config().setDocumentTitle("CRM Test Suite Results");
		
		spark.config().setReportName("CRM report");
		
		spark.config().setTheme(Theme.DARK);
		
		//create ExtentReports object
		report=new ExtentReports();

		report.attachReporter(spark);
		
		report.setSystemInfo("OS", "Windows10");
		
		report.setSystemInfo("Browser", "Chrome");

		
	}

	/**
	 * @author dkp
	 * 
	 * This method contains all configurations after executing any suite file.
	 */
	@Override
	public void onFinish(ISuite suite) {
		
		report.flush();
	}

	/**
	 * @author dkp
	 * 
	 * This method contains all configurations before executing any test.
	 */
	@Override
	public void onTestStart(ITestResult result) {
		
		    String testName = result.getMethod().getMethodName();
		    
		    Reporter.log(testName+" >===START===>",true);
		    
		    test = report.createTest(testName);  // This initializes the ExtentTest
		    
		    UtilityClassObject.setTest(test);
		    
		    test.log(Status.INFO, testName+" is started.");
	}


	/**
	 * @author dkp
	 * 
	 * This method contains all configurations if any test case is getting passed.
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" is Passed =>");
	}

	
	/**
	 * @author dkp
	 * 
	 * This method contains all configurations if any test case is getting failed.
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		
        String testcaseName=result.getMethod().getMethodName();
		
		TakesScreenshot ts=(TakesScreenshot) sdriver;
		
		String temp=ts.getScreenshotAs(OutputType.BASE64);
		
//		File dest=new File("./screenshots/"+testcaseName+".png");
		
		String time= LocalDateTime.now().toString().replace(":", "_");
		
        test = UtilityClassObject.getTest();
		
		test.addScreenCaptureFromBase64String(temp, testcaseName+"_"+time);
		
		test.log(Status.FAIL, testcaseName+" is failed");
	}

	/**
	 * @author dkp
	 * 
	 * This method contains all configurations if any test case is getting skipped.
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" is Skipped =>");

	}

}
