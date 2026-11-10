package testScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import constant.Constant;
import main_Project_base.Grocery_Base;
import pages.AdminUsers_Page;
import pages.Home_Page;
import pages.Login_Page;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsers_Test extends Grocery_Base
{   Home_Page home;
	AdminUsers_Page admin;
	RandomDataUtility r=new RandomDataUtility();
	String new_user_name=r.genrateRandomUsername();
	String new_user_password=r.genrateRandomPassword();
	@Test(priority=1,description = "verify User Able To Create NewAdmin")
	public  void verifyUserAbleToCreateNewAdmin() throws IOException {
	
	
	String user_name=ExcelUtility.readStringData(0, 0, "Login_Data");
	String password=ExcelUtility.readStringData(0, 1, "Login_Data");
	
	Login_Page login=new Login_Page(driver);
	login.enterUsername(user_name).enterPassword(password);
	home=login.ClickOnLoginBtn();		
	admin=home.adminMoreInfo();	
	
	
	//String new_user_name=ExcelUtility.readStringData(0, 0, "Admin_Data");
	//String new_user_password=ExcelUtility.readStringData(0, 1, "Admin_Data");
	
	//RandomDataUtility r=new RandomDataUtility();
	//String new_user_name=r.genrateRandomUsername();
    //String new_user_password=r.genrateRandomPassword(); 
	admin. newAdminButtonClick().enterUsername(new_user_name).enterPassword(new_user_password).userTypeDropDOwn().saveButtoncClick();
	boolean value=admin.UserCreatedMessage(); 
	Assert.assertTrue(value, Constant.USER_CREATION_ERROR);
}
@Test(priority=2,description ="verify User Able To Search New User" )
public  void verifyUserAbleToSearchNewUser() throws IOException, Exception
{
	String user_name=ExcelUtility.readStringData(0, 0, "Login_Data");
	String password=ExcelUtility.readStringData(0, 1, "Login_Data");
	
	Login_Page login=new Login_Page(driver);
	login.enterUsername(user_name).enterPassword(password);
	home=login.ClickOnLoginBtn();
	admin=home.adminMoreInfo();
	
//	String new_user_name=ExcelUtility.readStringData(0, 0, "Admin_Data");
	admin.click_searchNewUser().enter_existing_username(new_user_name).enter_existing_userType().click_Search();
	
	String actual =admin.get_user_name();
	Assert.assertTrue(actual.contains(new_user_name), Constant.USER_SEARCH_ERROR);
	System.out.println(actual);
	
	
}


}