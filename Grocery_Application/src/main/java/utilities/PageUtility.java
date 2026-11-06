package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	
	public void selectDropDownByValue(WebElement element, String value) { 

		Select object=new Select(element);

		object.selectByValue(value);

		}
	public void selectDropDownWithIndex(WebElement element, int value) {

		Select object=new Select(element);

		object.selectByIndex(value);

		}
	public void selectDropDownWithVisibleText(WebElement element, String value) {

		Select object=new Select(element);

		object.selectByVisibleText(value);

		}
	public void clickUsingJavaScriptExecutor(WebDriver driver,WebElement element) {
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
	
		js.executeScript("arguments[0].click();",  element);
		
		}
	public void scrollDownUsingJavaScriptExecutor(WebDriver driver) {
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
	
		js.executeScript("window.scrollBy(0,1000)","");
		
		}
	public void scrollUpUsingJavaScriptExecutor(WebDriver driver) {
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
	
		js.executeScript("window.scrollBy(0,-1000)","");
		
		}
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).build().perform();// for right click		
	}
	public void mouseHover(WebDriver driver,WebElement element)
	{			
		Actions a=new Actions(driver);//Actions class for mouse action.
		a.moveToElement(element).build().perform();//for mouse hover
	}
	public void doubleClick(WebDriver driver,WebElement element)
	{		
		Actions a=new Actions(driver);//Actions class for mouse action.
		a.doubleClick(element).build().perform();//for doubleClick
	}
	public void dragAndDrop(WebDriver driver,WebElement drag,WebElement drop)
	{	
		Actions a=new Actions(driver);//Actions class for mouse action.
		a.dragAndDrop(drag, drop).build().perform();
	}
	
	public void fileUpload(String file_name) throws AWTException
	
	{
		StringSelection s=new StringSelection(file_name);
			  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
			  Robot r = new Robot();
			  r.delay(2500);//ms
			  r.keyPress(KeyEvent.VK_CONTROL);
			  r.keyPress(KeyEvent.VK_V);
			  r.keyRelease(KeyEvent.VK_CONTROL);
			  r.keyRelease(KeyEvent.VK_V);
			  r.keyPress(KeyEvent.VK_ENTER);
			  r.keyRelease(KeyEvent.VK_ENTER);
	}


}
