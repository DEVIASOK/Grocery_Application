package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePages_Page {
	public WebDriver driver;    //Declares a WebDriver variable. It stores the browser driver so the class can interact with the page.
	public ManagePages_Page (WebDriver driver) //constructor- we r getting this driver from test class ,there we create obj for this class and pass the driver.
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);//this is a Selenium WebDriver method used in Page Object Model (POM) to initialize all the @FindBy annotated WebElement fields in a class.
	}
	
	@FindBy(xpath="//a[contains(text(),'New')]") WebElement newButton;
	@FindBy(id="title") WebElement newManagePagesTitle;
	@FindBy(xpath="//div[contains(@class,'note-editable card-block')]") WebElement newManagePagesDescription;
	@FindBy(id="page") WebElement newManagePageName;
	@FindBy(name="create") WebElement newManageSaveButton;
	@FindBy(xpath="//div[contains(.,'Page Created Successfully') and (@class='alert alert-success alert-dismissible')]")
	WebElement newManagePageCreated;
	
	@FindBy(xpath="//a[contains(.,'Search')]") WebElement searchManagePagesButton;
	@FindBy(name="un")WebElement new_Title_Field;
	@FindBy(name="Search") WebElement searchManagePagesButtonClick2;
	@FindBy(xpath="//table/tbody/tr/td[1]") WebElement searchTitleFromTable;
	
	public void newManagePagesButtonClick() {
		newButton.click();
		
	}
	public void newManagePagesTitleField(String new_title) {
		 
		 newManagePagesTitle. sendKeys(new_title);
		
	}
	public void newManagePagesDescriptionField(String new_description) {
	
		newManagePagesDescription.sendKeys(new_description);
		
	}
	public void newManagePageNameField(String new_PageName) {
		
		newManagePageName.sendKeys(new_PageName);
		
	}
	public void newManageSaveButtonClick() {
		JavascriptExecutor js =(JavascriptExecutor) driver;//its a predifined interface used for scroll down /up.Also if click is not working we can use this one.casting is happening here.
		js.executeScript("arguments[0].click();", 	newManageSaveButton);
	}
	public void scroll_ManagePages_Page() {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)","");
		
	}
	public String created_new_ManagePage() {
		
		 return newManagePageCreated.getText();
		 
	}
	public void searchManagePagesButtonClick() {
		
		
		searchManagePagesButton.click();
	}
	public String getTitleFromTableManagePages() {
		
		
		return searchTitleFromTable.getText();
	}
	public void new_Title_Field(String new_title) {
		
		new_Title_Field.sendKeys(new_title);
		
	}
	public void searchManagePagesButtonClick2() {
		
		 searchManagePagesButtonClick2.click();
		
	}

	
	
}
