package reportGeneration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentReportUtility;

public class Listeners implements ITestListener { // interface-ITestListener---their methods are given below with green arrow
	
	ExtentTest test;
	ExtentReports extent = ExtentReportUtility.createExtentReports();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) { //executes before the test has run
	ITestListener.super.onTestStart(result);
	
	test = extent.createTest(result.getMethod().getMethodName());//fetch method name
	extentTest.set(test);
}

	public void onTestSuccess(ITestResult result) { //invoke when test is success- pass

	ITestListener.super.onTestSuccess(result);
	extentTest.get().log(Status.PASS, "Test Passed");

}

public void onTestFailure(ITestResult result) {//invoke when test is fail

	ITestListener.super.onTestFailure(result);

	extentTest.get().log(Status.FAIL, "Test Failed");
	extentTest.get().fail(result.getThrowable());

	WebDriver driver = null;

	String testMethodName = result.getMethod().getMethodName();

	try {

		driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
				.get(result.getInstance());//exception handling
	} catch (IllegalArgumentException e) {

		e.printStackTrace();//error and exception printing in report.
	} catch (IllegalAccessException e) {

		e.printStackTrace();
	} catch (NoSuchFieldException e) {

		e.printStackTrace();
	} catch (SecurityException e) {

		e.printStackTrace();
	}

	try {
		driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
				.get(result.getInstance());
	} catch (Exception e) {
	}
}

public void onTestSkipped(ITestResult result) {// if skipped

	ITestListener.super.onTestSkipped(result);
	extentTest.get().log(Status.SKIP, "Test Skipped");
	String testMethodName = result.getMethod().getMethodName();

}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {//some case ssuccess percent can be set that time this will invoke.

	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
}

public void onTestFailedWithTimeout(ITestResult result) {//invoke for timeout issue

	ITestListener.super.onTestFailedWithTimeout(result);
}

public void onStart(ITestContext context) { // executed before   onTestStart method IE 1.onstart, onteststart,then test

	ITestListener.super.onStart(context);
}

public void onFinish(ITestContext context) {//last executed-afyer all the methods

	ITestListener.super.onFinish(context);
	extent.flush();// used to log everything correctly in report
}

}
