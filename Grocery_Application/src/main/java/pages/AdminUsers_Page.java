package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsers_Page {        //declares a class named Homepage
	
	public WebDriver driver;    //Declares a WebDriver variable. It stores the browser driver so the class can interact with the page.
	public AdminUsers_Page (WebDriver driver) //constructor- we r getting this driver from test class ,there we create obj for this class and pass the driver.
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);//this is a Selenium WebDriver method used in Page Object Model (POM) to initialize all the @FindBy annotated WebElement fields in a class.
	}
	PageUtility page_utility=new PageUtility();
	@FindBy(linkText="New") WebElement newAdminButton;
	@FindBy(name="username")WebElement user;
	@FindBy(name="password")WebElement passwd;
	@FindBy(id="user_type")WebElement userType;
	@FindBy(name="Create")WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement User_Created_Successfully;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement User_AlreadyExist;
	@FindBy(xpath="//a[contains(text(),' Search')]") WebElement search_newuser_top;
	
	@FindBy(id="un") WebElement existing_username;
	@FindBy(id="ut") WebElement existing_userType;
	 
	@FindBy(xpath="//button[@name='Search']") WebElement search_button_2;
	@FindBy(xpath="//table/tbody/tr/td[1]") WebElement user_in_table;
	
public AdminUsers_Page newAdminButtonClick()//instead of void add landing page name and return this-chaining
{
	newAdminButton.click();
	return this;
}

public AdminUsers_Page enterUsername(String user_name)
{
	user.sendKeys(user_name);
	return this;
}

public AdminUsers_Page enterPassword(String password)
{
	passwd.sendKeys(password);
	return this;
}
public AdminUsers_Page userTypeDropDOwn()
{
	page_utility.selectDropDownWithVisibleText(userType, "Staff");
//	Select s= new Select(userType);
//	s.selectByVisibleText("Staff");
	return this;
}
public AdminUsers_Page  saveButtoncClick()
{
	saveButton.click();
	return this;
}
public boolean  UserCreatedMessage()
{
	
	if(!driver.findElements(By.xpath("//div[contains(@class,'alert-success')]")).isEmpty()) 
	{
		System.out.println(User_Created_Successfully.getText());
		return true;
		
	}
	else if(!driver.findElements(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isEmpty())
	{
		System.out.println(User_AlreadyExist.getText());
		return false;
	}
	
	return false;
	
}

public AdminUsers_Page click_searchNewUser() {

	search_newuser_top.click();
	return this;
	
}
public AdminUsers_Page enter_existing_username(String  new_user_name) {

	existing_username.sendKeys(new_user_name);
	return this;
	
}
public AdminUsers_Page enter_existing_userType() {
	
	page_utility.selectDropDownWithVisibleText(existing_userType, "Staff");
//or Select s= new Select(existing_userType);
//	 s.selectByVisibleText("Staff");
	return this;
	
}

public  AdminUsers_Page click_Search()
{
	search_button_2.click();
	return this;
}

public String  get_user_name()
{	  page_utility.scrollDownUsingJavaScriptExecutor(driver);
	  return user_in_table.getText();
}



}