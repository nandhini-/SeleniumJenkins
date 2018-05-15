package com.test.scripts;

import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.test.pageobjects.*;
import com.test.testbase.*;

public class trackUser extends test_base{
	 @Test
		public void trackUser_reg() throws Exception
		{
			extentTest = extent.startTest("IDM-32- Verify Track User Registration and Create New User Link");
			
			login_page login_page = PageFactory.initElements(driver,login_page.class);
		
			try {
				

				boolean flag = login_page.trackUserLink();
				if(flag){
					System.out.println("Link is visible");
				}
				else{
					System.out.println("Track User Not Visible");
				}
				
				String msg = login_page.userRegistration();
				System.out.println(msg);
				assertNotEquals("Register New Account Failed", msg);
				
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
}
