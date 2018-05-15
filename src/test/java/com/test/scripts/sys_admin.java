package com.test.scripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.test.testbase.*;
import com.test.pageobjects.*;

public class sys_admin extends test_base {
	@Test
	public void test_sysadminUrl(){
		extentTest = extent.startTest("Sysadmin URL test");
		sysadmin sys = PageFactory.initElements(driver,sysadmin.class);
		String val = null;
		try {
			assertEquals(driver.getTitle(),"403 Forbidden");
			val=sys.forbidden();
			System.out.println(val);
			assertEquals(val,"Forbidden");
			val=sys.auth();
			System.out.println(val);
			assertEquals(val,"You are not authorized to access the requested resource.");
		}
		 catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
