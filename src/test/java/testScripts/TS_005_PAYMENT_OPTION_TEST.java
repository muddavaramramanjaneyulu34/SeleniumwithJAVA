package testScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;

import ReuseComp.TestUtils.Dynamic_Data_Generation_Methods;
import ReuseComp.TestUtils.Excel_Methods;
import ReuseComp.TestUtils.Launching_WebSite;
import ReuseComp.TestUtils.WebDriverMethods;
import testCases.TS_002_LOGIN_LOGOUT;
import testCases.TS_003_SEARCH_PETS_IN_SEARCH_BAR;
import testCases.TS_004_ADD_TO_CART;
import testCases.TS_005_PAYMENT_OPTION;

public class TS_005_PAYMENT_OPTION_TEST {

		Dynamic_Data_Generation_Methods dynamicMethods = new Dynamic_Data_Generation_Methods();
		
	//	public static String proprtiesPath = System.getProperty("user.dir")+"/Config";
		//public static String testDataFile = System.getProperty("user.dir")+"/TestData/TestData.xls";
		public static ExtentReports extent;
		public String testName = this.getClass().getSimpleName();
		    @BeforeSuite
		    public void setUp() {
		        extent = new ExtentReports();
		        // Additional configuration for ExtentReports if needed
		    }

		    // Your test methods go here

			
			  @AfterSuite 
			  public void tearDown() { 
				  extent.flush(); 
				  }
			 
		
		
		@Test	
		
		public void testCase() throws IOException, InterruptedException {
			
		     dynamicMethods.randomDataGenerator = new Faker();
		     WebDriver driver=null;
			 ExtentTest childTestSite = testScripts.TS_005_PAYMENT_OPTION_TEST.extent.createTest("Your Test Name");
			 childTestSite.log(Status.PASS, "Test passed");
			 TS_005_PAYMENT_OPTION payment_Options = new TS_005_PAYMENT_OPTION();
			 payment_Options.TS_005_PAYMENT_OPTION_METHOD(driver, childTestSite, testName);
		}	 
		}
	