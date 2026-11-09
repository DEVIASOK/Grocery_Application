package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoy_Page {

	public WebDriver driver;    
	public ManageDeliveryBoy_Page (WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[contains(text(),'New')]") WebElement new_DeliveryBoy;
	@FindBy(id="name")WebElement new_DeliveryBoy_name;
	@FindBy(id="email")WebElement new_DeliveryBoy_email;
	@FindBy(id="phone")WebElement  new_DeliveryBoy_phonenum ;
	@FindBy(id="address")WebElement new_Address;
	@FindBy(id="username")WebElement new_DeliveryBoy_username;
	@FindBy(id="password")WebElement new_DeliveryBoy_psswd;
	@FindBy(name="create")WebElement save_butn;
	@FindBy(xpath="//a[contains(text(),'Search')]") WebElement searchDeliveryBoy;
	@FindBy(id="un") WebElement deli_username_search;
	@FindBy(id="ut") WebElement deli_email_search;
	@FindBy(id="ph") WebElement deli_phone_search;
	@FindBy(name="Search") WebElement existing_deli_search;
	@FindBy(xpath="//table/tbody/tr/td") WebElement deliveryBoyNameAfterSearch;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement newDeliveryBoyCreatedMessage;
	 public ManageDeliveryBoy_Page   new_DeliveryBoyBTN()
	 {
		 new_DeliveryBoy.click();
		 return this;
		 
	 }
	 public ManageDeliveryBoy_Page    new_DeliveryBoy_name(String  deli_name)
	 {
		 new_DeliveryBoy_name.sendKeys( deli_name);
		 return this;
		 
	 }
	 public ManageDeliveryBoy_Page    new_DeliveryBoy_email( String deli_email)
	 {
		 new_DeliveryBoy_email.sendKeys(deli_email);
		 return this;
		 
	 }
	 public ManageDeliveryBoy_Page    new_DeliveryBoy_phonenum(String deli_phone)
	 {
		 new_DeliveryBoy_phonenum.sendKeys(deli_phone);
		 return  this;
		 
	 }
	 public ManageDeliveryBoy_Page    new_DeliveryBoyAddress(String deli_address)
	 {
		 new_Address.sendKeys(deli_address);
		 return  this;	 
	 }
	 
	 public ManageDeliveryBoy_Page    new_DeliveryBoy_username(String deli_user_name)
	 {
		 new_DeliveryBoy_username.sendKeys(deli_user_name);
		 return this;		 
	 }
	 public ManageDeliveryBoy_Page   new_DeliveryBoy_psswd(String deli_password)
	 {
		 new_DeliveryBoy_psswd.sendKeys(deli_password);
		 return this;
		 
	 }
	 public ManageDeliveryBoy_Page   save_bttn()
	 {
		 save_butn. click();
		 return this; 
		 
		 
	 }
	 public ManageDeliveryBoy_Page clickOnSearch() {
		searchDeliveryBoy.click();
		return this;
		
	 }
	 public void deli_username_search(String deli_name) {
		 deli_username_search.sendKeys(deli_name);
		
	 }
	 public void deli_email_search(String deli_email) {
		 deli_email_search.sendKeys(deli_email);
		
	 }
	 public void deli_phone_search(String deli_phone) {
		 deli_phone_search.sendKeys(deli_phone);
		
	 }
	 public void existing_deli_search_button(){
		 existing_deli_search.click();
	 }
	 public String deliveryBoyNameAfterSearch() {
		 return  deliveryBoyNameAfterSearch.getText();
		
	 }
	 public boolean newDeliveryBoyCreatedMessage() {
		try { 
		String s= newDeliveryBoyCreatedMessage.getText();
		if(s.contains("Delivery Boy Details Created Successfully"))
		{			
			return true;
		}	
		}
		catch(Exception e) {
			System.out.println("Already Exist");
		}
		return false;
		
	 }
	 public ManageDeliveryBoy_Page scroll_DeliveryBoyPage() {
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)","");
			return this;
		
	 }
	
	 
}
