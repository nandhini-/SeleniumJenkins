package com.test.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class test_base {
	public static WebDriver driver;
	  public static Properties prop;
	  public static ExtentReports extent;
	  public static ExtentTest extentTest;
	  
	  public test_base() {
		  FileInputStream input=null;
		  try{
			  prop=new  Properties();
			  input=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//test//config//config//config.properties");
			  prop.load(input);
		  }catch(FileNotFoundException e){
			  System.out.println("");
		  }catch (IOException e) {
			// TODO: handle exception
		  }finally{
			  
		  }
		// TODO Auto-generated constructor stub
		  
	}
	   @BeforeTest
	  public void setExtent(){
			extent = new ExtentReports(System.getProperty("user.dir")+"//test-output//ExtentReport.html", true);
			
			
		}
		
	  @BeforeMethod
	  public void setup() {
		  
		 
		  
//		  System.setProperty("webdriver.chrome.driver","//scratch//aime/tools//chromedriver//chromedriver");
//		  System.setProperty("webdriver.chrome.driver","//C://Users//nandhnag//workspace//chromedriver.exe");
		  //System.setProperty("webdriver.chrome.driver","//usr//bin//firefox");
//		  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driver\\geckodriver.exe");
		  System.setProperty("webdriver.firefox.marionette", "c://");
		  Reporter.log("=============Browser Session Started========",true);
//		  ChromeOptions chromeOptions = new ChromeOptions();
//		  chromeOptions.addArguments("window-size=1400,800"); 			
//		  chromeOptions.addArguments("headless");
//		  driver=new ChromeDriver(chromeOptions);
//		  System.setProperty("webdriver.gecko.driver", "//usr//bin/firefox");
		  driver=new FirefoxDriver();
		  driver.manage().window().maximize();
//		  driver.manage().window().setSize(new Dimension(1366, 768));
		  driver.manage().timeouts().pageLoadTimeout(180,TimeUnit.SECONDS);
		  driver.get("https://rgbu-vbe-rpasee-idm.oracleindustry.com/identity");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    
	  
		    
	  }
	  
	   @AfterMethod
	  public void closeApplication(ITestResult result){
//		  System.out.println("IN close method");
		  
		  if(result.getStatus()==ITestResult.FAILURE){
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
				
//				String screenshotPath = FreeCRMTest.getScreenshot(driver, result.getName());
//				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
				//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
			}
			else if(result.getStatus()==ITestResult.SKIP){
				extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
			}
			else if(result.getStatus()==ITestResult.SUCCESS){
				extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

			}
			
			
			extent.endTest(extentTest);
		  driver.quit();
		  Reporter.log("=============Browser Session Ended========",true);  
	  }
	  
	  @AfterTest
		public void endReport(){
			extent.flush();
			extent.close();
		}
}
