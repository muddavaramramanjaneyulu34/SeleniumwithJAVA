package ReuseComp.TestUtils;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

public class Yop_Mail_Methods {

	public WebDriverMethods webMethods=new WebDriverMethods();
	//public Excel_Methods excelMethods=new Excel_Methods();
	
	public void login_Into_YopMail(WebDriver driver,String url,String xpath,String mailId,ExtentTest childTestSite) throws InterruptedException, IOException
	{
		driver.navigate().to(url);
		List<WebElement> elements=driver.findElements(By.xpath("//button[@id='accept']"));
		if(elements.size()>0)
		{
			boolean isDisplayed=elements.get(0).isDisplayed();
			if(isDisplayed)
			webMethods.clickOnElement("//button[@id='accept']", "Cookie Accept ", childTestSite, driver);
		}
		
		webMethods.sendTextToFiled(xpath, mailId, "Mail ID",childTestSite,driver);
		driver.findElement(By.xpath(xpath)).submit();
		Thread.sleep(10000);
	}
	
	public void verify_Subscription_Mail(WebDriver driver,String subscriptionMail,ExtentTest childTestSite) throws InterruptedException, IOException
	{
		//webMethods.waitForElementToBePresent(inboxFrame, driver);
		driver.switchTo().frame("ifinbox");
		
		webMethods.waitForElementToBePresent(subscriptionMail, driver);
		
		webMethods.clickOnElement(subscriptionMail,"Subscription Email",childTestSite, driver);
		driver.switchTo().defaultContent();
	
	}
	
	public void verify_Registration_Confirmation_Mail(WebDriver driver,String confirmationMail,String linkInMail,ExtentTest childTestSite) throws InterruptedException, IOException
	{
		
		driver.switchTo().frame("ifinbox");
		
		webMethods.waitForElementToBePresent(confirmationMail, driver);
		
		webMethods.clickOnElement(confirmationMail, "Confirmation Email",childTestSite,driver);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("ifmail");
		webMethods.waitForElementToBePresent(linkInMail, driver);
		driver.switchTo().defaultContent();
		
	}
	
	public void verify_Registration_Verification_Mail(WebDriver driver,String verificationMail,String verificationMailLink,ExtentTest childTestSite) throws InterruptedException, IOException
	{
		driver.switchTo().frame("ifinbox");
		
		webMethods.waitForElementToBePresent(verificationMail, driver);
		
		webMethods.clickOnElement(verificationMail, "Verification Email",childTestSite,driver);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("ifmail");
		webMethods.waitForElementToBePresent(verificationMailLink, driver);
		
	}
	
	public void verify_Registration_Rejection_Mail(WebDriver driver,String rejectionMail,ExtentTest childTestSite) throws InterruptedException, IOException
	{
		driver.switchTo().frame("ifinbox");
		
		webMethods.waitForElementToBePresent(rejectionMail, driver);
		
		webMethods.clickOnElement(rejectionMail,"Rejection Email",childTestSite, driver);
		driver.switchTo().defaultContent();
		
	}
	
	public void click_On_Verification_Mail(WebDriver driver,String verificationMail,String verificationMailLink,ExtentTest childTestSite) throws InterruptedException, IOException
	{
	
		
		
		webMethods.clickOnElement(verificationMailLink, "Verification Mail Link",childTestSite,driver);
		driver.switchTo().defaultContent();
		
	}
}
