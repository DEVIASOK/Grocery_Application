package testScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import main_Project_base.Grocery_Base;
import pages.Home_Page;
import pages.Login_Page;
import utilities.ExcelUtility;

public class Login_Test extends Grocery_Base {
	Home_Page home;// ref of homepage-here its used for chaining

	@Test(priority = 1, description = "user is trying to login with valid credentials")
	public void verifyUserLoginWithValidCredential() throws IOException {

		String user_name = ExcelUtility.readStringData(0, 0, "Login_Data");
		String password = ExcelUtility.readStringData(0, 1, "Login_Data");

		Login_Page login = new Login_Page(driver);
		login.enterUsername(user_name).enterPassword(password);//chaining - reduce repitetion()
		home=login.ClickOnLoginBtn();// chaining
		boolean value = home.verifyUserinHomePage();
		Assert.assertTrue(value, Constant.VALID_CREDENTIAL_ERROR);

	}

	@Test(priority = 2, description = "user is trying to login with invalid credentials", groups = "smoke", retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginWithINValidCredential() throws IOException {

		String user_name = ExcelUtility.readStringData(1, 0, "Login_Data");
		String password = ExcelUtility.readStringData(1, 1, "Login_Data");

		Login_Page login = new Login_Page(driver);
		login.enterUsername(user_name).enterPassword(password).ClickOnLoginBtn(); 

		String actual = login.verifyTitleisShownInLoginPage();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALID_CREDENTIAL_ERROR);

	}

	@Test(priority = 3, description = "User is trying to Login With INValid USERNAME")
	public void verifyUserLoginWithINValidUSERNAME() throws IOException {

		String user_name = ExcelUtility.readStringData(2, 0, "Login_Data");
		String password = ExcelUtility.readStringData(2, 1, "Login_Data");

		Login_Page login = new Login_Page(driver);
		login.enterUsername(user_name).enterPassword(password).ClickOnLoginBtn();

		String actual = login.verifyTitleisShownInLoginPage();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,  Constant.INVALID_USERNAME_ERROR);

	}

	@Test(priority = 4, description = "User is trying to Login With INValid password", groups = "smoke",dataProvider="loginData")
	public void verifyUserLoginWithINValidPassword(String user_name, String password) throws IOException {

	//	String user_name = ExcelUtility.readStringData(3, 0, "Login_Data");
	//	String password = ExcelUtility.readStringData(3, 1, "Login_Data");

		Login_Page login = new Login_Page(driver);
		login.enterUsername(user_name).enterPassword(password).ClickOnLoginBtn();

		String actual = login.verifyTitleisShownInLoginPage();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALID_PASSWORD_ERROR);
	}

	@DataProvider(name = "loginData")
	public Object[][] getDataFromDataProvider()
	{
		return new Object[][] {
			new Object[] { "admin", "admin123" }, 
			new Object[] { "admin", "adminpp90" } 
			};

	}
}
