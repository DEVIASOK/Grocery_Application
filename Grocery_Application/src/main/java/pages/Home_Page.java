package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {        //declares a class named Homepage
	
	public WebDriver driver;    //Declares a WebDriver variable. It stores the browser driver so the class can interact with the page.
	public Home_Page (WebDriver driver) //constructor- we r getting this driver from test class ,there we create obj for this class and pass the driver.
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);//this is a Selenium WebDriver method used in Page Object Model (POM) to initialize all the @FindBy annotated WebElement fields in a class.
	}
	@FindBy(linkText="Dashboard") WebElement dashboard;
	@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement clickProfile;
	@FindBy(xpath="//a[contains(@href,'logout') and @class='dropdown-item']") WebElement clickLogOut;
	// or (linkText="Logout")
	@FindBy(xpath="//a[contains(@href,'list-admin') and (@class='small-box-footer')]") WebElement adminMoreInfoBtn;
	@FindBy(xpath="//a[contains(@href,'list-deliveryboy')]")WebElement manageDeliveryBoy_Btn;
	@FindBy(xpath="//a[contains(@href,'list-page') and (@class='small-box-footer')]")  WebElement managePageMoreInfo;
	public boolean verifyUserinHomePage()
	{
		return  dashboard.isDisplayed();
		
	}
	
	
	public Home_Page ClickOnProfileAdmin()
	{
		clickProfile.click();
		return this;
	}
	
	
	public Login_Page clickOnLogOut()//landing page
	{
		clickLogOut.click();
		return new Login_Page(driver);
	}
	
	public AdminUsers_Page adminMoreInfo()
	{
		adminMoreInfoBtn.click();
		return new AdminUsers_Page(driver);
	}
	public ManageDeliveryBoy_Page  manageDeliveryBoy_MoreInfo()
	{
		manageDeliveryBoy_Btn.click();
		return new ManageDeliveryBoy_Page(driver);

	}
	public Home_Page managePageMoreInfo()
	{
		 managePageMoreInfo.click();
		 return this;
	}
}
	