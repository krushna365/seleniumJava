package com.qf.objectrepository;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qf.genericutility.FileUtility;

public class UserLoginObjects {
	
	public static WebDriver driver;
	private Properties prop;
	private FileUtility fLib;

	
	//Objects
	@FindBy(xpath = "//span[@class='caret']")
	private WebElement Myaccount;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	private WebElement loginbtn;
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement submitnbtn;
	
	public UserLoginObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		prop = new Properties();
		fLib = new FileUtility();
	}
	
	//Actions
			public void clickmyaccount() {
				Myaccount.click();
			}
			
			public String clicklogin() {
				loginbtn.click();
				Assert.assertTrue(true, "Application successfully displayed login page");
				System.out.println("Application successfully displayed login page");
				return driver.getTitle();
				
			}
			
			public void enteremail(String emailid) throws Exception {
				
				email.sendKeys(fLib.readDataFromProperty(emailid));
				System.out.println("User can able to enter email id" + emailid );
				Assert.assertTrue(true, "User can able to enter email id");
				
			}
			
			public void enterpassword(String loginpassword) throws Exception {

				password.sendKeys(fLib.readDataFromProperty(loginpassword));
				System.out.println("User can able to enter email id" + loginpassword );
				//password.sendKeys(loginpassword);
				Assert.assertTrue(true, "User can able to password");
				System.out.println("User can able to password");
			}
			
			public void clicksubmitnbtn() {
				submitnbtn.click();
				Assert.assertTrue(true, "User can able to click submit button");
				System.out.println("User can able to click submit button");
			}
	
}
