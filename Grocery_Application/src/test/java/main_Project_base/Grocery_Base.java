package main_Project_base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenShotUtility;

public class Grocery_Base {

public WebDriver driver;//predefined interface used to launch browser
	
	Properties p;// used to use
	FileInputStream f;

	@BeforeMethod(alwaysRun=true)//grouping will run only afrer giving alwaysrun true
	@Parameters("browsers")
	public void initializeBrowser(String browsers) throws IOException
	{	
		p= new Properties();
		f= new FileInputStream(Constant.CONFIG_FILE);// read url from constant class
		p.load(f);//method from properties -predifined class
		if(browsers.equalsIgnoreCase("Chrome"))	
			{
			driver =new ChromeDriver();
			}
		else if(browsers.equalsIgnoreCase("Firefox"))	
			{
			driver =new FirefoxDriver();
			}
		else if(browsers.equalsIgnoreCase("Edge"))	
			{
			driver =new EdgeDriver();
			}	
		driver.get(p.getProperty("url")); //"https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}

	 
	@AfterMethod
	public void closeBrowser(ITestResult itestresult) throws IOException{//ITestResult-interface..provides status like pass /fail/skip
		if(itestresult.getStatus()==ITestResult.FAILURE) {
			ScreenShotUtility screenshotutility=new ScreenShotUtility();
			screenshotutility.getScreenshot(driver, itestresult.getName());//failed method name
		}
		 // driver.close();
		//driver.quit();
	}

}
