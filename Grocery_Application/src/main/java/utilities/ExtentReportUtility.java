package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	
	public static final ExtentReports extentReports = new ExtentReports();// static instance of extent reports that can
// be shared across the application.ExtentReports library class that manages test results and report data.

public synchronized static ExtentReports createExtentReports() 
{

	ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");//Reporter class that generates the HTML report.given project local path
	reporter.config().setReportName("7RMartSupermarketProject");//set report name
	extentReports.attachReporter(reporter);

	extentReports.setSystemInfo("Organization", "Obsqura");
	extentReports.setSystemInfo("Name", " Devi Asok"); 
	extentReports.setSystemInfo("Designation", "QA engineer");// provides context of the report
	return extentReports;
}

}


/*. Working of Extent Reports
---------------------------------
1. The ExtentReportUtility class creates and configures the report.
2. The Listeners class obtains the configured ExtentReports object.(abt listerners class)
3. When a test starts, onTestStart() creates an ExtentTest entry using the test method name.
4. When a test passes, onTestSuccess() logs the PASS status.
5. When a test fails, onTestFailure() logs the FAIL status and the associated exception or assertion error using getThrowable().
6. When a test is skipped, onTestSkipped() logs the SKIP status.
7. Finally, onFinish() calls extent.flush() to write the collected report information to the HTML report.
5. Exception Handling and WebDriver Retrieval
In onTestFailure(), Java Reflection is used to retrieve the WebDriver instance from the test class. Reflection allows us to access class fields at runtime.

The try-catch block handles exceptions that may occur while retrieving the driver. Retrieving the driver alone does not capture a screenshot; additional code is required to take and attach a screenshot to the report.
6. Important Methods
Method	Purpose
createExtentReports()	Creates and configures the report
attachReporter()	Attaches the reporter to ExtentReports
setReportName()	Sets the displayed report name
setSystemInfo()	Adds metadata to the report
createTest()	Creates an individual test entry---listeners class
log()	Adds a status and message to the test entry
getThrowable()	Retrieves the exception or error associated with the test result
flush()	Writes accumulated report information to the output*/

