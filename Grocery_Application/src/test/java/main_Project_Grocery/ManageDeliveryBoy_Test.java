package main_Project_Grocery;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsers_Page;
import pages.Home_Page;
import pages.Login_Page;
import pages.ManageDeliveryBoy_Page;
import utilities.ExcelUtility;


public class ManageDeliveryBoy_Test extends Grocery_Base{
	
	@Test(priority=1)
	public  void verifyuserisabletoaddNewdeliveryboy() throws IOException {
		
		
		String user_name=ExcelUtility.readStringData(0, 0, "Login_Data");
		String password=ExcelUtility.readStringData(0, 1, "Login_Data");
		
		Login_Page login=new Login_Page(driver);
		login.enterUsername(user_name);
		login.enterPassword(password);
		login.ClickOnLoginBtn();
		
		Home_Page home=new Home_Page(driver);
		home.manageDeliveryBoy_MoreInfo();
		
		ManageDeliveryBoy_Page delivery= new 	ManageDeliveryBoy_Page(driver);
		delivery.new_DeliveryBoyBTN();
		
		String deli_name=ExcelUtility.readStringData(0, 0, "DeliveryBoy_Data");
		String deli_email=ExcelUtility.readStringData(0, 1, "DeliveryBoy_Data");
		String deli_phone=ExcelUtility.readIntegerData(0, 2, "DeliveryBoy_Data");
		String deli_address=ExcelUtility.readStringData(0, 3, "DeliveryBoy_Data");
		String deli_user_name=ExcelUtility.readStringData(0, 4, "DeliveryBoy_Data");
		String deli_password=ExcelUtility.readStringData(0, 5, "DeliveryBoy_Data");
		
		
		delivery.new_DeliveryBoy_name(deli_name);
		delivery.scroll_DeliveryBoyPage();
		delivery.new_DeliveryBoy_email(deli_email);
		delivery.new_DeliveryBoy_phonenum(deli_phone);
		delivery.new_DeliveryBoyAddress(deli_address);
		delivery.new_DeliveryBoy_username(deli_user_name);
		delivery.new_DeliveryBoy_psswd(deli_password);
	
		delivery.save_bttn();
		
		boolean actual=delivery.newDeliveryBoyCreatedMessage();
		Assert.assertTrue(actual, Constant.DELIVERY_BOY_CREATION_ERROR);
	
		
	}
	@Test(priority=2)
	public  void verifyUserIsAbleToSearchDeliveryBoy() throws IOException, Exception
	{
		String user_name=ExcelUtility.readStringData(0, 0, "Login_Data");
		String password=ExcelUtility.readStringData(0, 1, "Login_Data");
		
		Login_Page login=new Login_Page(driver);
		login.enterUsername(user_name);
		login.enterPassword(password);
		login.ClickOnLoginBtn();
		
		Home_Page home=new Home_Page(driver);
		home.manageDeliveryBoy_MoreInfo();
		ManageDeliveryBoy_Page delivery= new 	ManageDeliveryBoy_Page(driver);
		delivery.clickOnSearch();
		
		String deli_name=ExcelUtility.readStringData(0, 0, "DeliveryBoy_Data");
		String deli_email=ExcelUtility.readStringData(0, 1, "DeliveryBoy_Data");
		String deli_phone=ExcelUtility.readIntegerData(0, 2, "DeliveryBoy_Data");
		
		delivery.deli_username_search(deli_name);
		delivery.deli_email_search(deli_email);
		delivery.deli_phone_search(deli_phone);
		delivery.existing_deli_search_button();
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)","");
		String actual=delivery.deliveryBoyNameAfterSearch();
		String expected=deli_name;
		Assert.assertEquals(actual, expected,Constant.DELIVERY_BOY_SEARCH_ERROR);
		
		
	}

	
	
	
	
	

}
