package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import ReuseComp.TestUtils.Dynamic_Data_Generation_Methods;
import ReuseComp.TestUtils.Excel_Methods;
import ReuseComp.TestUtils.Launching_WebSite;
import ReuseComp.TestUtils.WebDriverMethods;

public class TS_003_SEARCH_PETS_IN_SEARCH_BAR {
	public static Launching_WebSite browserLaunching = new Launching_WebSite();
	public static Excel_Methods excelMethods=new Excel_Methods();
	public static WebDriverMethods webMethods=new WebDriverMethods();
	public static Dynamic_Data_Generation_Methods dynamicMethods = new Dynamic_Data_Generation_Methods();
	
	public static String proprtiesPath = System.getProperty("user.dir")+"/Config";
	public static String testDataFile = System.getProperty("user.dir")+"/TestData/TestData.xls";
	public static ExtentReports extent;
	public String testName = this.getClass().getSimpleName();

	public static void TS_003_SEARCH_PETS_IN_SEARCH_BAR_METHOD(WebDriver driver, ExtentTest childTestSite,String testName)throws IOException, InterruptedException {
		
		try{
						
			String FirstName = dynamicMethods.getDynamicDataForFirstName(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 2));
			String LastName  = dynamicMethods.getDynamicDataForLastName(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 3));
			String Email     = dynamicMethods.getDynamicDataForRegEmailId(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 4));
			String Phone     = dynamicMethods.getDynamicDataForTelephoneNumber(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 5));
			String AddLine1  = dynamicMethods.getDynamicDataForAddress(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 6));
			String AddLine2  = dynamicMethods.getDynamicDataForAddressNew(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 7));
			String City      = dynamicMethods.getDynamicDataForCity(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 8));
			String State     = dynamicMethods.getDynamicDataForState(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 9));
			String Zip       = dynamicMethods.getDynamicDataForZipcode(excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 10));
			String Country   = excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 11);
			String PetName   = excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 12);
			String Url 		 = excelMethods.getDataFromTestDataSheet(testDataFile, "TestCases", testName, 1);
			
			driver = new ChromeDriver();
			driver.get(Url);
			//driver.get("https://petstore.octoperf.com/actions/Catalog.action");
			driver.manage().window().maximize();
			
			webMethods.clickOnElement(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "EnterStart", 0), "Enter The Store", childTestSite, driver);
			webMethods.clickOnElement(excelMethods.getXpathFromSheet(testDataFile,"Registration_Xpaths","Signin", 0), "SignIn", childTestSite, driver);
			webMethods.clickOnElement(excelMethods.getXpathFromSheet(testDataFile,"Registration_Xpaths","RegisterNow", 0), "RegisterNew", childTestSite, driver);
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
			
			
			webMethods.clickOnElement(excelMethods.getXpathFromSheet(testDataFile,"Registration_Xpaths","Signin", 0), "SignIn", childTestSite, driver);
			webMethods.clearTextField(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "NewPassword", 0), "sahoo@123", childTestSite, driver);
			webMethods.sendTextToFiled(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "NewPassword", 0), "sahoo@123", "NewPassword", childTestSite, driver);
			webMethods.clickOnElement(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "login", 0), "LogIn", childTestSite, driver);
			Thread.sleep(3000);
			webMethods.sendTextToFiled(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "SearchBar", 0), PetName, "Searching Pet", childTestSite, driver);
			webMethods.clickOnElement(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "SearchButton", 0), "SearchButton", childTestSite, driver);
			Thread.sleep(3000);
			webMethods.clickOnElement(excelMethods.getXpathFromSheet(testDataFile, "Registration_Xpaths", "ProductID", 0), "ProductID", childTestSite, driver);
			
			
			
			Thread.sleep(6000);
			driver.quit();
		
		}catch(NullPointerException e){
			e.printStackTrace();
		}  
		}	

}
