package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class Login_Page {        //declares a class named loginpage
	
	public WebDriver driver;    //Declares a WebDriver variable. It stores the browser driver so the class can interact with the page.
	public Login_Page (WebDriver driver) //constructor- we r getting this driver from test class ,there we create obj for this class and pass the driver.
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);//this is a Selenium WebDriver method used in Page Object Model (POM) to initialize all the @FindBy annotated WebElement fields in a class.
	}
	WaitUtility wait=new WaitUtility();
	
	@FindBy(name="username")WebElement user;
	@FindBy(name="password")WebElement passwd;
	@FindBy(xpath="//label[@for='remember']")WebElement check_box;
	@FindBy(xpath="//button[@type='submit']")WebElement login;

	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement title;
	//@findby -provided by predefined class pagefactory
	
	public Login_Page enterUsername(String user_name)//instead of void add landing page name and return this-chaining
	{
	user.sendKeys(user_name);
	return this;
	}
	
	public Login_Page enterPassword(String password)
	{
	passwd.sendKeys(password);
	return this;
	
	}
	
	public Login_Page checkBox()
	{
		check_box.click();
		return this;
	}
	
	public Home_Page ClickOnLoginBtn()
	{
		wait.waitUntilElementToBeClickable(driver, login);
		login.click();
		return new Home_Page(driver);//landed in new page ie homepage
	}
	
	
	
public String verifyTitleisShownInLoginPage()
{
	return title.getText();
}
}
