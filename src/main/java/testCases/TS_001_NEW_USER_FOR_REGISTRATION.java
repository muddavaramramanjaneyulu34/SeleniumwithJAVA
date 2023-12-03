package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import ReuseComp.TestUtils.Dynamic_Data_Generation_Methods;
import ReuseComp.TestUtils.Excel_Methods;
import ReuseComp.TestUtils.Launching_WebSite;
import ReuseComp.TestUtils.WebDriverMethods;

public class TS_001_NEW_USER_FOR_REGISTRATION {
	
	public static Launching_WebSite browserLaunching = new Launching_WebSite();
	public static Excel_Methods excelMethods=new Excel_Methods();
	public static WebDriverMethods webMethods=new WebDriverMethods();
	public static Dynamic_Data_Generation_Methods dynamicMethods = new Dynamic_Data_Generation_Methods();
	
	public static String proprtiesPath = System.getProperty("user.dir")+"/Config";
	public static String testDataFile = System.getProperty("user.dir")+"/TestData/TestData.xls";
	public static ExtentReports extent;
	public String testName = this.getClass().getSimpleName();


public static void TS_001_NEW_USER_FOR_REGISTRATION_METHOD(WebDriver driver, ExtentTest childTestSite,String testName)throws IOException, InterruptedException {
		
	/*	Properties prop = new Properties();
		FileInputStream inputFile = new FileInputStream(proprtiesPath+"/WebSiteURL.properties");
		prop.load(inputFile);
		String USERNAME =prop.getProperty("USERNAME");
		String PASSWORD = prop.getProperty("PASSWORD");
		System.out.println("USERNAME is: "+USERNAME);
		System.out.println("PASSWORD is: "+PASSWORD);
		
		*/
		try{
			String Url 		 = excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 1);
			
			driver = new ChromeDriver();
			driver.get(Url);
			driver.manage().window().maximize();
			webMethods.clickOnElement(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "EnterStart", 0), "Enter The Store", childTestSite, driver);
			webMethods.clickOnElement(excelMethods.getXpathFromSheet(testDataFile,"Registration_Xpaths","Signin", 0), "SignIn", childTestSite, driver);
			webMethods.clickOnElement(excelMethods.getXpathFromSheet(testDataFile,"Registration_Xpaths","RegisterNow", 0), "RegisterNew", childTestSite, driver);
			
			
			String FirstName = dynamicMethods.getDynamicDataForFirstName(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 2));
			String LastName  = dynamicMethods.getDynamicDataForLastName(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 3));
			//String Email     = dynamicMethods.getDynamicDataForRegEmailId(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 4));
			String Email=dynamicMethods.getDynamicDataForRegEmailId1(driver, childTestSite,testDataFile);
			System.out.println("emailId ="+Email);
			String[] Email_Username = Email.split("@");
			String[]  firstname= Email_Username[0].trim().split("\\.");
			
			String Phone     = dynamicMethods.getDynamicDataForTelephoneNumber(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 5));
			String AddLine1  = dynamicMethods.getDynamicDataForAddress(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 6));
			String AddLine2  = dynamicMethods.getDynamicDataForAddressNew(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 7));
			String City      = dynamicMethods.getDynamicDataForCity(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 8));
			String State     = dynamicMethods.getDynamicDataForState(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 9));
			String Zip       = dynamicMethods.getDynamicDataForZipcode(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 10));
			String Country   = excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 11);
			
			
			System.out.println("Before launching");
			//browserLaunching.launchSiteFromBrowserstack(driver);
			System.out.println("After launching");
			
			String originalWindow = driver.getWindowHandle();
			List<WebElement> FakemailConsent = driver.findElements(By.xpath("//*[@class='glyphicon form-control-feedback inputFeedback text-danger glyphicon-remove']"));
			System.out.println("FakemailConsent size="+FakemailConsent.size());
			while (FakemailConsent.size() == 1) {
				driver.findElement(By.xpath("//*[@name='emailInput']")).sendKeys(Keys.ENTER);
			   Thread.sleep(2000);
			   System.out.println("Inside while confirm button for fake mail");
			   FakemailConsent = driver.findElements(By.xpath("//*[@class='glyphicon form-control-feedback inputFeedback text-danger glyphicon-remove']"));
			}			

			//*****Verify the UserMail Entered Correctly*******
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
			webMethods.waitTillElementVisisble(driver, excelMethods.getXpathFromSheet(testDataFile, "Fakemail_Xpaths", "EnteredEmailAddress", 0));
			String EnteredEMail=webMethods.getText(excelMethods.getXpathFromSheet(testDataFile, "Fakemail_Xpaths", "EnteredEmailAddress", 0), driver);
			String[] EnteredFakeEMail = EnteredEMail.split("@");
			System.out.println("EnteredFakeEMail[0] ="+EnteredFakeEMail[0].trim());
			System.out.println("Email_Username[0]="+Email_Username[0]);
			while(!EnteredFakeEMail[0].trim().equalsIgnoreCase(Email_Username[0].trim())) {
				System.out.println("True");
				System.out.println("EnteredEMail ="+EnteredEMail);
				webMethods.waitTillElementVisisble(driver, excelMethods.getXpathFromSheet(testDataFile, "Fakemail_Xpaths", "ClickEditMailAddress", 0));
				webMethods.clickOnElement(excelMethods.getXpathFromSheet(testDataFile, "Fakemail_Xpaths", "ClickEditMailAddress", 0), "ClickEditMailAddress", childTestSite, driver);
				webMethods.waitTillElementVisisble(driver, excelMethods.getXpathFromSheet(testDataFile, "Fakemail_Xpaths", "EditEmailAddressEnter", 0));
				webMethods.sendTextToFiled(excelMethods.getXpathFromSheet(testDataFile, "Fakemail_Xpaths", "EditEmailAddressEnter", 0), Email_Username[0] ,"Email Address", childTestSite, driver);
				FakemailConsent = driver.findElements(By.xpath("//*[@class='glyphicon form-control-feedback inputFeedback text-danger glyphicon-remove']"));
				System.out.println("FakemailConsent size="+FakemailConsent.size());
				while (FakemailConsent.size() == 1) {
					driver.findElement(By.xpath("//*[@name='emailInput']")).sendKeys(Keys.ENTER);
				   Thread.sleep(2000);
				   System.out.println("Inside while confirm button for fake mail");
				   FakemailConsent = driver.findElements(By.xpath("//*[@class='glyphicon form-control-feedback inputFeedback text-danger glyphicon-remove']"));
				}			
				webMethods.waitTillElementVisisble(driver, excelMethods.getXpathFromSheet(testDataFile, "Fakemail_Xpaths", "EditConfirm", 0));
				webMethods.clickOnElement(excelMethods.getXpathFromSheet(testDataFile, "Fakemail_Xpaths", "EditConfirm", 0), "EditConfirm", childTestSite, driver);
				Thread.sleep(3000);
				driver.switchTo().window(originalWindow);
				Thread.sleep(1000);
				webMethods.waitTillElementVisisble(driver, excelMethods.getXpathFromSheet(testDataFile, "Fakemail_Xpaths", "EnteredEmailAddress", 0));
				EnteredEMail=webMethods.getText(excelMethods.getXpathFromSheet(testDataFile, "Fakemail_Xpaths", "EnteredEmailAddress", 0), driver);
				EnteredFakeEMail = EnteredEMail.split("@");
				System.out.println("EnteredFakeEMail[0] ="+EnteredFakeEMail[0].trim());
				System.out.println("Email_Username[0]="+Email_Username[0]);
				
			}
			
			//driver.switchTo().window(petStoreWindow);
			webMethods.switchLatestWindow(driver, originalWindow);
			System.out.println("After Switching window");
			
			webMethods.sendTextToFiled(excelMethods.getXpathFromSheet(testDataFile,"Registration_Xpaths","UserID", 0), Email, "USER_ID", childTestSite, driver);
			
			webMethods.sendTextToFiled(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "NewPassword", 0), "sahoo@123", "NewPassword", childTestSite, driver);
			webMethods.sendTextToFiled(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "repeatedPassword", 0), "sahoo@123", "repeatedPassword", childTestSite, driver);
			webMethods.sendTextToFiled(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "firstname", 0), FirstName, "FirsName", childTestSite, driver);
			webMethods.sendTextToFiled(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "lastname", 0), LastName, "LastName", childTestSite, driver);
			webMethods.sendTextToFiled(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "email", 0), Email, "Email", childTestSite, driver);
			webMethods.sendTextToFiled(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "phone", 0), Phone, "Phone", childTestSite, driver);
			webMethods.sendTextToFiled(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "addressLine1", 0), AddLine1, "Address Line1", childTestSite, driver);
			webMethods.sendTextToFiled(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "addressLine2", 0), AddLine2, "Address Line2", childTestSite, driver);
			webMethods.sendTextToFiled(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "city", 0), City, "City", childTestSite, driver);
			webMethods.sendTextToFiled(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "state", 0), State, "State", childTestSite, driver);
			webMethods.sendTextToFiled(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "zip", 0), Zip, "ZipCode", childTestSite, driver);
			webMethods.sendTextToFiled(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "country", 0), Country, "Country Code", childTestSite, driver);
			
			webMethods.selectValueFromDropdown(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "lanuagePreference", 0), "english", "Language", childTestSite, driver);
			webMethods.selectValueFromDropdown(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "favouriteCategory", 0), "DOGS", "Language", childTestSite, driver);
			webMethods.clickOnElement(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "myList", 0), "MyList CheckBox", childTestSite, driver);
			webMethods.clickOnElement(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "myBanner", 0), "MyBanner CheckBox", childTestSite, driver);
			webMethods.clickOnElement(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "saveAccount", 0), "Submit", childTestSite, driver);
			
			driver.switchTo().window(originalWindow);
			driver.navigate().refresh();
			Thread.sleep(5000);
			
			//driver.quit();
			
		}catch(Exception E) {
			E.printStackTrace();
		}
}
		
}
