package ReuseComp.TestUtils;

import java.io.IOException;
import java.util.Locale;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;

import ReuseComp.BaseTest.BaseTest;

import java.util.Locale;

public class Dynamic_Data_Generation_Methods {
	
	public static String domain;
	public static WebDriverMethods webMethods=new WebDriverMethods();
	public static Excel_Methods excelMethods=new Excel_Methods();
	public static Faker randomDataGenerator;

	public static String getDynamicDataForFirstName(String data)
	{
		if(data.equalsIgnoreCase("DD"))
		{
			System.out.println(randomDataGenerator.name().firstName());
			return randomDataGenerator.name().firstName();
		}else
		{
			return data;
		}
		
	}
	
	

	public static String getDynamicDataForLastName(String data)
	{
		if(data.equalsIgnoreCase("DD"))
		{
		return randomDataGenerator.name().lastName();
		}else
		{
			return data;
		}
	}

	
	
	public String getDynamicDataForRegEmailId(String email)
	{	
		
		String firstName=randomDataGenerator.name().firstName()+"."+randomDataGenerator.number().digits(2);
		//String lastName= randomDataGenerator.name().lastName();		
		//return firstName+"@forkshape.com".replaceAll("'", "");
		  email =firstName=firstName+"12"+"@yopmail.com";
		  return email;
	}
	public String getDynamicDataForRegEmailId1(WebDriver driver, ExtentTest childTestSite, String testDataPath) throws InterruptedException, IOException
	{	
		
			System.out.println("Before going to launch Website Fakemail");
			//JavascriptExecutor jse = (JavascriptExecutor)driver;
			driver.switchTo().newWindow(WindowType.TAB);
			//jse.executeScript("window.open()");
	        driver.get("https://www.fakemail.net/");
	        driver.manage().window().maximize();
	        Thread.sleep(3000);
	        webMethods.clickOnElement(excelMethods.getXpathFromSheet(testDataPath, "Fakemail_Xpaths", "Fakemail_Consent", 0), "Fakemail_Consent", childTestSite, driver);

	        JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
	        WebElement domainElement = driver.findElement(By.xpath("//span[@class='animace']"));	       
	        String domainName = domainElement.getText();
	        String[] parts = domainName.split("@");
	        System.out.println("Out side of the Doamin"+parts);
	        if (parts.length == 2) {
	         domain = parts[1];
	 
	            System.out.println("Domain name is:"+'@'+domain);     
	            childTestSite.log(Status.PASS, "EMail Domain is: "+domain+"and it has taken");
	        } 
	        else {
	        	System.out.println("EMail Domain Doesnt taken");
	        	childTestSite.log(Status.FAIL, "EMail Domain is: "+domain+"and Domain doesn't taken");
	        }
	        //driver.close();
			
		String firstName=randomDataGenerator.name().firstName()+"."+randomDataGenerator.number().digits(2);
		
		System.out.println("Before Switching the Window");
	
		System.out.println("After Switching the Window");
		//driver.switchTo().window(originalWindow1);
		System.out.println("After switching the Second window");
		return firstName+'@'+domain.replaceAll("'", "");
	}
	
	public String getDynamicDataForEmailId(String data)
	{
		if(data.equalsIgnoreCase("DD"))
		{
		String firstName=randomDataGenerator.name().firstName();
		String lastName= randomDataGenerator.name().lastName();
		
		return firstName+lastName+"@doitups.com".replaceAll("'", "");
		}else
		{
		return data;
		}
	}
	
	public static String getDynamicDataForCity(String data)
	{
		if(data.equalsIgnoreCase("DD"))
		{
		return randomDataGenerator.address().city();
		}
		else
		{
		return data;
		}
	}
	
	public static String getDynamicDataForState(String data)
	{
		if(data.equalsIgnoreCase("DD"))
		{
		return randomDataGenerator.address().state();
		}
		else
		{
		return data;
		}
	}
	public static String getDynamicDataForAddress(String data)
	{
		if(data.equalsIgnoreCase("DD"))
		{
			
			int maxLength = 10;
			String randomAddress = randomDataGenerator.address().fullAddress();
			randomAddress = randomAddress.substring(0, Math.min(randomAddress.length(), maxLength));
		return randomAddress;
		}
		else
		{
		return data;
		}
	}
	
	public static String getDynamicDataForAddressNew(String AddressNew1)
	{
		int maxLength = 10;
		AddressNew1=randomDataGenerator.address().fullAddress();
		String randomAddress1 = AddressNew1.substring(0, Math.min(AddressNew1.length(), maxLength));
		return randomAddress1;
	}
	
	
	public static String getDynamicDataForZipcode(String data)
	{
	
		if(data.equalsIgnoreCase("DD"))
		{
			return randomDataGenerator.address().zipCode();
		}else
		{
		return data;
		}
	}
	
	public static  String getDynamicDataForTelephoneNumber(String data)
	{
		
		if(data.equalsIgnoreCase("DD"))
		{
			
			//System.out.println(randomDataGenerator.phoneNumber().phoneNumber());
			return randomDataGenerator.phoneNumber().phoneNumber();
		}else
		{
		return data;
		}
	}
	
	public static  String getDynamicDataForProffessionalNumber(String data)
	{
		
		if(data.equalsIgnoreCase("DD"))
		{
			
			//System.out.println(randomDataGenerator.phoneNumber().phoneNumber());
			return randomDataGenerator.number().digits(5);
		}else
		{
		return data;
		}
	}
	
	
}
