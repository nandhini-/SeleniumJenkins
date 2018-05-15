package com.test.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class login_page {
WebDriver driver;
	
	public login_page(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(id="username") WebElement username;
	@FindBy(how=How.ID,using="password") WebElement password;
	@FindBy(how=How.XPATH,using=".//span//input[@class='formButton']") WebElement loginButton;
	@FindBy(xpath=".//a[@href='/identity/faces/home']") WebElement loginlink;
	@FindBy(xpath=".//u[contains(text(),'Track User Registration')]") WebElement trackUserLink;
	@FindBy(xpath=".//u[contains(text(),'Register New Account')]") WebElement regUserLink;
	@FindBy(xpath=".//div[contains(text(),'Self registration is not allowed. Please call System Administrator.')]") WebElement usrRegisterMsg;
	@FindBy(xpath=".//h2[contains(text(),'Basic Information')]") WebElement BasicInfo;
	public void login_idm(String usernm,String passwd) throws InterruptedException{
		
		username.sendKeys(usernm);
		password.sendKeys(passwd);
		Thread.sleep(2000);
		loginButton.click();
		Thread.sleep(3000);
	}
	
	
	
	public void clkLoginLink(){
		loginlink.click();
	}
	
	public boolean trackUserLink(){
		try{
			trackUserLink.isDisplayed();
			return true;
		}
		catch(NoSuchElementException e){
		return false;
		}
	}
	
	public String userRegistration() throws InterruptedException{
		String val= null;
		try{
			if(regUserLink.isDisplayed())
			{
				regUserLink.click();
				Thread.sleep(3000);
				if(BasicInfo.isDisplayed());{
					val="Register New Account Failed";
				}
			}
			else
				val="Register New Account Link does not exist";
		}
		catch(NoSuchElementException e)
		{
			val="Register New Account Passed";
			return val;
		}
		
		return val;
	
	}
}
