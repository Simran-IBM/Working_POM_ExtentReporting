package com.test.TestUI.UI;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.test.TestUI.UI.excelReader.ExcelReader;
import com.test.TestUI.UI.screenshot.ScreenShot;
import com.test.TestUI.UI.testBase.TestBase;
import com.test.TestUI.UI.uiPageClass.LoginPage;

public class TC004_LoginTest4_LoginSuccess extends TestBase {
	
	public static final Logger log = Logger.getLogger(TC004_LoginTest4_LoginSuccess.class.getName());
	
	LoginPage loginpage;
    int i;
    ExcelReader excel;
    String filepath=System.getProperty("user.dir") + "\\src\\\\main\\java\\com\\test\\TestUI\\UI\\data\\";
    ScreenShot ss;
    ArrayList<String> login_cred = new ArrayList<String>();
    String email_id="";
    String password="";
    
	@BeforeTest
	public void setUp() {
		
		init(); //Browser and URL setup    
	}
	
	
	@Test
	public void loginTest4_LoginSuccess() {
	     
		loginpage = new LoginPage(driver); //Page Class
	
		
		ss = new ScreenShot(driver); //ScreenShot Class
		
		excel = new ExcelReader(driver); //Excel_Reader Class
	
		
		
		login_cred=excel.getCellData(filepath,"loginData.xlsx", "login",4);
		
			email_id=login_cred.get(0);
			log.info(email_id);
			password=login_cred.get(1);
			log.info(password);
			
		
			String text=loginpage.login(email_id, password,4);
	
		    Assert.assertEquals("Success",text);
		 
		 ss.CaptureScreenShot(driver,"TC004-LoginTest4_LoginSuccess"); // Capturing Screen Shot	 
	}

    @AfterTest
    public void endTest() {
    	
    	driver.close();
    	
    }


}



