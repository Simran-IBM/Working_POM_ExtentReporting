package com.test.TestUI.UI.screenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ScreenShot {

	public ScreenShot(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void CaptureScreenShot(WebDriver driver,String scenario_name){
		
		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			SimpleDateFormat s=new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
			
			String d = s.format(new Date());
			
			FileUtils.copyFile(source, new File("ScreenShots/"+d+"-"+scenario_name+".png"));
			
			Reporter.log("Screen Shot Taken",true);
		}  
		
		catch (Exception e) {
			
			Reporter.log(e.getMessage(),true);
		}
		
	}
}

