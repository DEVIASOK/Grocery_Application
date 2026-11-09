package testScripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import main_Project_base.Grocery_Base;
import pages.AdminUsers_Page;
import pages.Home_Page;
import pages.Login_Page;
import pages.ManagePages_Page;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManagePages_Test extends Grocery_Base {
	
	@Test
	public  void verifyUserAbleToCreateNewPage() throws IOException {
		
		
		String user_name=ExcelUtility.readStringData(0, 0, "Login_Data");
		String password=ExcelUtility.readStringData(0, 1, "Login_Data");
		
		Login_Page login=new Login_Page(driver);
		login.enterUsername(user_name);
		login.enterPassword(password);
		login.ClickOnLoginBtn();
		
		Home_Page home=new Home_Page(driver);
		home.managePageMoreInfo();
		
		ManagePages_Page page= new ManagePages_Page(driver);
		page. newManagePagesButtonClick();
		
		String new_title=ExcelUtility.readStringData(1, 0, "ManagePages_Data");
		String new_description=ExcelUtility.readStringData(1, 1, "ManagePages_Data");
		String new_PageName=ExcelUtility.readStringData(1, 2, "ManagePages_Data");
	
		
		page. scroll_ManagePages_Page();
		page.newManagePagesTitleField(new_title);
		page.newManagePagesDescriptionField( new_description);
		page.newManagePageNameField( new_PageName);		
		page.newManageSaveButtonClick();
		String actual=driver.getCurrentUrl();
		String expected="https://groceryapp.uniqassosiates.com/admin/pages/add";
		Assert.assertEquals(actual, expected, Constant.MANAGE_PAGE_CREATION_ERROR);
	}
	@Test
	public  void verifyUserAbleToSearchNewPage() throws IOException {
		
		
		String user_name=ExcelUtility.readStringData(0, 0, "Login_Data");
		String password=ExcelUtility.readStringData(0, 1, "Login_Data");
		
		Login_Page login=new Login_Page(driver);
		login.enterUsername(user_name);
		login.enterPassword(password);
		login.ClickOnLoginBtn();
		
		Home_Page home=new Home_Page(driver);
		home.managePageMoreInfo();
		
		ManagePages_Page page= new ManagePages_Page(driver);
		page. searchManagePagesButtonClick();
		
		String new_title=ExcelUtility.readStringData(1, 0, "ManagePages_Data");
		page. new_Title_Field(new_title);
		page.searchManagePagesButtonClick2();
		String actual=page.getTitleFromTableManagePages();
		String expected=new_title;
		Assert.assertEquals(actual, expected,Constant.MANAGE_PAGE_SEARCH_ERROR);
	}

}
