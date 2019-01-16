package com.test.TestUI.UI.testBase;


import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.TestUI.UI.excelReader.ExcelReader;

public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver driver;
	String url="https://www.phptravels.net/login";
	String browser="chrome";
	ExcelReader excel;
	
	public void init() {
		selectBrowser(browser);
		getUrl(url);
	    String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
	}


	public void selectBrowser(String browser) {
	if (browser.equalsIgnoreCase("Chrome")){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\\\main\\resources\\drivers\\chromedriver.exe\\");
		driver=new ChromeDriver();
		log.info("Creating Object of:"+browser);
	}
		
 }
	public void getUrl(String url) {
		log.info("Navigating to:"+url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
}
