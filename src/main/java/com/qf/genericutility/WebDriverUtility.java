package com.qf.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebDriverUtility {
	static WebDriver driver;
	
	public void explicitwait(WebElement id3) {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.visibilityOf(id3));
	}
	

	static boolean scrolldown(WebElement id2){
	try {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,250)", id2);
	System.out.println("Application successfully scrolled down and find the element " + id2);}
	catch(Exception e)
	{
		System.out.println("failed to scrolldown " + id2);
	}
	return false;
	}

	public static boolean scrollup(WebElement id) {
	try {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", id);
		System.out.println("Application successfully scrolled up and find the element " + id);
	}
	catch(Exception e) {
		System.out.println("Application failed  to scroll up " + id);
	}
	return false;}

	static boolean  isElementpresent(WebElement id1) {
		try {
			if(id1.isDisplayed()) {
				System.out.println("Element is present " + id1);
			}
		}
		catch(Exception e) {
			System.out.println("Element is not present " + id1);
		}
		return false;
		}
	
	public static WebElement draganddrop(WebElement item1 ,WebElement item2) {
		//driver.switchTo().frame(identifier);
		WebElement source = item1;
		WebElement target = item2;
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
		return target;
	}
	
	public static WebElement doubleclick(WebElement DC) {
		
		Actions action = new Actions(driver);
		WebElement element= DC;
		//WebElement element=driver.findElement(By.linkText("TEST"));
		//Double click
		action.doubleClick(element).perform();

		return element;
	}
	
	public static WebElement mouseover(WebElement MO) {
		
		Actions action = new Actions(driver);
		WebElement element= MO;
		//WebElement element=driver.findElement(By.linkText("TEST"));
		//Mouse over
		action.moveToElement(element).perform();

		return element;
	}
	
	public static WebElement rightclick(WebElement RC) {
		
		Actions action = new Actions(driver);
		WebElement element= RC;
		//WebElement element=driver.findElement(By.linkText("TEST"));
		//Right Click
		action.contextClick(element).perform();
		return element;
	}
	
	public static WebElement Screenshot(WebElement ss) throws IOException {
		
		File screenshot = ss.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot, new File(System.getProperty("user.dir")+"\\screenshot.png"));
		
		return ss;
		
	}
	public static WebElement assertequals(WebElement element , String actual ) {
		
		try {
			Assert.assertEquals(element, actual);
			}
			catch(Exception e) {
				System.out.println("Exception - not able find value to assert");
			}
		return element;	
	}
	public static WebElement getWindowHandles()
	{
		Set<String> windowid = driver.getWindowHandles();
		Iterator<String>it = windowid.iterator();
		
		String parentid = it.next();
		String clientid = it.next();
		System.out.println(parentid);
		System.out.println(clientid);
		return null;
		
	}
	public static WebElement Dropdownselectbyvisibletext(WebElement DSVD, String visibletext) {
		/*WebElement DDid =  DSVD;
		Select objsel = new Select(DDid);
		objsel.selectByVisibleText(" ");
		return DSVD;*/
		WebElement DDid =  DSVD;
		Select objsel = new Select(DDid);
		List<WebElement> listelements = objsel.getOptions();
		
		for(WebElement option:listelements) {
			if(option.getText().equals("")) {
				option.click();
				break;
			}
		}
		return DDid;	
	}
	
	public static WebElement Alertaccept(WebElement accept) {
		
		WebElement acceptalert = accept;
		driver.switchTo().alert().accept();
		
		return accept;
	}
	public static WebElement Alertdismiss(WebElement dismiss) {
		
		WebElement dismissalert = dismiss;
		driver.switchTo().alert().accept();
		
		return dismiss;
	}

}
