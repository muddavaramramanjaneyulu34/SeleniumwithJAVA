package ReuseComp.TestUtils;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

public class MoaktMail_Methods {

	public WebDriverMethods webMethods=new WebDriverMethods();
	//public Excel_Methods excelMethods=new Excel_Methods();
	
	public void login_Into_MoaktMail(WebDriver driver,String url,String xpathForEnterMail,String domain,String mailId,String xpathForCreateButton,ExtentTest childTestSite) throws InterruptedException, IOException
	{
		driver.navigate().to(url);
		Thread.sleep(5000);
		webMethods.sendTextToFiled(xpathForEnterMail, mailId, "Mail ID",childTestSite,driver);
		Thread.sleep(2000);
		//webMethods.selectValueFromDropdown(domain, "tmpeml.com", "Domain", childTestSite, driver);
		driver.findElement(By.xpath(xpathForCreateButton)).click();
		Thread.sleep(10000);
	}
	
	public void verify_Subscription_Mail(WebDriver driver,String subscriptionMail,String backToMail,String refresh,ExtentTest childTestSite) throws InterruptedException, IOException
	{
		webMethods.clickOnElement(refresh,"Refresh Button ",childTestSite, driver);
		webMethods.waitForElementToBePresent(subscriptionMail, driver);
		webMethods.clickOnElement(subscriptionMail,"Subscription Email",childTestSite, driver);
		webMethods.clickOnElement(backToMail,"Back To Mail Button ",childTestSite, driver);
	
	}
	
	public void verify_Registration_Confirmation_Mail(WebDriver driver,String confirmationMail,String linkInMail,String frameXpath,String backToMail,String refresh,ExtentTest childTestSite) throws InterruptedException, IOException
	{
		webMethods.clickOnElement(refresh,"Refresh Button ",childTestSite, driver);	
		List<WebElement> elements=driver.findElements(By.xpath(confirmationMail));
		if(elements.size()==0)
		{
			Thread.sleep(20000);
			webMethods.clickOnElement(refresh,"Refresh Button ",childTestSite, driver);	
		}
		webMethods.waitForElementToBePresent(confirmationMail, driver);
		webMethods.clickOnElement(confirmationMail, "Confirmation Email",childTestSite,driver);
		driver.switchTo().frame(0);
		//webMethods.waitForElementToBePresent(linkInMail,driver);
		//webMethods.scrollElementIntoView(linkInMail, childTestSite,driver);
		driver.switchTo().defaultContent();
		webMethods.clickOnElement(backToMail,"Back To Mail Button ",childTestSite, driver);
		
	}
	
	public void verify_Registration_Verification_Mail(WebDriver driver,String verificationMail,String frameXpath,String verificationMailLink,String backToMail,String refresh,ExtentTest childTestSite) throws InterruptedException, IOException
	{
		webMethods.clickOnElement(refresh,"Refresh Button ",childTestSite, driver);	
		webMethods.waitForElementToBePresent(verificationMail, driver);
		webMethods.clickOnElement(verificationMail, "Verification Email",childTestSite,driver);
		
		driver.switchTo().frame(0);
		webMethods.waitForElementToBePresent(verificationMailLink, driver);
		webMethods.scrollElementIntoView(verificationMailLink,childTestSite, driver);
		String verificationURL=driver.findElement(By.xpath(verificationMailLink)).getText();
		//webMethods.clickOnElement(verificationMailLink, "Verification Mail Link",childTestSite,driver);
		System.out.println("verificationURL"+verificationURL);
		driver.switchTo().defaultContent();
		//webMethods.clickOnElement(backToMail,"Back To Mail Button ",childTestSite, driver);
		driver.get(verificationURL);
		Thread.sleep(5000);
	}
	
	public void verify_Registration_Rejection_Mail(WebDriver driver,String rejectionMail,ExtentTest childTestSite) throws InterruptedException, IOException
	{
		webMethods.waitForElementToBePresent(rejectionMail, driver);
		webMethods.clickOnElement(rejectionMail,"Rejection Email",childTestSite, driver);
		
	}
	
	public void click_On_Verification_Mail(WebDriver driver,String verificationMail,String verificationMailLink,ExtentTest childTestSite) throws InterruptedException, IOException
	{
	
		
		
		webMethods.clickOnElement(verificationMailLink, "Verification Mail Link",childTestSite,driver);
		driver.switchTo().defaultContent();
		
	}
}
