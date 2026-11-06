package main_Project_Grocery;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.Home_Page;
import pages.Login_Page;
import utilities.ExcelUtility;

public class Home_Test extends Grocery_Base{
	Home_Page home;
@Test(priority=1,description ="User is able to Logout Successfully")
public  void verifyUserLogoutSuccess() throws IOException {
	
	
	String user_name=ExcelUtility.readStringData(0, 0, "Login_Data");
	String password=ExcelUtility.readStringData(0, 1, "Login_Data");
	
	Login_Page login=new Login_Page(driver);
	login.enterUsername(user_name).enterPassword(password);
	home=login.ClickOnLoginBtn();
	
	//Home_Page home=new Home_Page(driver);
	home.ClickOnProfileAdmin();
	login=home.clickOnLogOut();//landing page
	
	String actual=login.verifyTitleisShownInLoginPage();
	String expected="7rmart supermarket";
	Assert.assertEquals(actual,  expected,Constant.LOGOUT_ERROR);
	
}


}