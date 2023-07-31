package Com.healthcare.Utilities;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Com.healthcare.Baseclass.BaseClass_OpenMRS;


public class Listeners extends  BaseClass_OpenMRS implements ITestListener {

	ExtentTest test;	
	ExtentReports extent = ExtentReportsNG.getReportObject();
	
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		//Extent Report  //10
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		//Extent Report   //pass6
		extentTest.get().log(Status.PASS, "Test Passed");
	}	
	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable());
		
		String testmethodname=result.getMethod().getMethodName();
		
	try {
			
		driver= (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		
	} catch (Exception e) {
			e.printStackTrace();	
		}
		try {
			extentTest.get().addScreenCaptureFromPath(GenericUtils.getScreenshotAs(testmethodname, driver),result.getMethod().getMethodName());
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}


}
