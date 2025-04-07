package com.qf.genericutility;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public static WebDriver driver;
	FileUtility fLib=new FileUtility();
	
	@BeforeClass
	public void openbrowser() throws InterruptedException, IOException {

		String browser = fLib.readDataFromProperty("BROWSER");
		String url = fLib.readDataFromProperty("URL");
		if (browser.equalsIgnoreCase("chrome")) {
			//open browser
			driver = new ChromeDriver();
			driver.manage().window().maximize();
//			String url = String.valueOf(fLib.readDataFromProperty("URL"));
			System.out.println("*********************" + url);
			driver.get(url);
			System.out.println("chrome launched successfully");
		}
		else if (browser.equalsIgnoreCase("lambda")) {
			// LambdaTest Credentials
			String username = fLib.readDataFromProperty("LT_USERNAME");
			String accessKey = fLib.readDataFromProperty("LT_ACCESS_KEY");

			// Desired Capabilities
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("browserName", "Chrome");
			caps.setCapability("browserVersion", "latest");

			Map<String, Object> ltOptions = new HashMap<>();
			ltOptions.put("platformName", "Windows 10");
			ltOptions.put("project", "LambdaTestDemo");
			ltOptions.put("build", "LambdaTest-Build");
			ltOptions.put("name", "LambdaTest-Run");
			ltOptions.put("network", true);
			ltOptions.put("video", true);
			ltOptions.put("visual", true);
			ltOptions.put("console", true);

			caps.setCapability("LT:Options", ltOptions);

			driver = new RemoteWebDriver(
					new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), caps);
			driver.get(url);
			System.out.println("LambdaTest browser launched successfully");
		} else {
			throw new IllegalArgumentException("Unsupported browser type: " + browser);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	
	@AfterClass
	public void closebrowser() {
		//close browser
		driver.close();
	}

}
