package com.test.TestUI.UI.uiPageClass;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static final Logger log = Logger.getLogger(LoginPage.class.getName());
	

	
	@FindBy(xpath="//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[1]/input")
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[2]/input")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"loginfrm\"]/button")
	WebElement btn;
	
	@FindBy(xpath="//*[@id=\"loginfrm\"]/div[1]/div[2]/div")
	WebElement message;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String login(String emailId,String pass,int scenarioNumber) {
		
		String text="";
		log.info("Email");
	    email.sendKeys(emailId); 
	    log.info("Entered Email Id");
	    
	    log.info("Enter Password");
	    password.sendKeys(pass);
	    
	    btn.click();
	    log.info("Clicked on Login Button");
	    
	    if(scenarioNumber<4 && scenarioNumber>0)
	    {
	    text=message.getText();
	    return text;
	    }
	    else 
	    	return "Success";
	    
	}
	
}
	
	


