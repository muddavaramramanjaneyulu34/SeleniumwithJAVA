package ReuseComp.BaseTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;



public class CommonMethods{
	
	public String reportPath=System.getProperty("user.dir")+"/Reports/";
	 
//public WebDriver driver;
	//CommonObjects comObj=PageFactory.initElements(driver, CommonObjects.class);
	//CommonObjects comObj=PageFactory.initElements(driver, CommonObjects.class);
		public void verifyTheCookiePresence(WebElement cookieLocator, WebElement acceptLocator, List<WebElement> hcpLocator,String testName,ExtentTest childTestSite,WebDriver driver ) throws IOException 
		{
			List<WebElement> hcpTabbedDisclaimer=driver.findElements(By.xpath("//button[@class='hcp-tabbed-disclaimer__button button-animated button-animated--square js-hcp-tabbed-disclaimer-cta js-site-disclaimer-skip']"));
			List<WebElement> isCookiePresent=driver.findElements(By.xpath("//a[@class='cookie-disclaimer__accept js-site-disclaimer-skip button-animated button-animated--square']"));
			//boolean isCookiePresent=cookieLocator.isEnabled();
			int ishcpPresent=hcpLocator.size();
			
			if(isCookiePresent.size()>=1)
			{
				System.out.println("Cookie is present");
				
			childTestSite.log(Status.PASS, "Cookie is Present", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath(reportPath+testName+"_cookie.png",driver)).build());
				isCookiePresent.get(0).click();
				if(ishcpPresent>=1)
				{
					hcpLocator.get(0).click();
				}
				if(hcpTabbedDisclaimer.size()>=1)
				{
					hcpTabbedDisclaimer.get(0).click();
				}
				
			}
			else
			{
				if(ishcpPresent>=1)
				{
					hcpLocator.get(0).click();
				}
				if(hcpTabbedDisclaimer.size()>=1)
				{
					hcpTabbedDisclaimer.get(0).click();
				}
				System.out.println("Cookie is not present");
				//childTestSite.log(Status.FAIL, "Cookie is not Present", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath(reportPath+testName+"_cookie_fail.png",driver)).build());
			}
		}
		
//		public void verifyTheHcpDisclaimer(WebElement hcpDisclaimer, WebElement hcpHeadline, WebElement hcpOkLocator, WebElement hcpDescription,String testName,ExtentTest childTestSite,WebDriver driver ) throws IOException 
//		{
//			//List<WebElement> hcpTabbedDisclaimer=driver.findElements(By.xpath("//button[@class='hcp-tabbed-disclaimer__button button-animated button-animated--square js-hcp-tabbed-disclaimer-cta js-site-disclaimer-skip']"));
//			
//			boolean isHcpPresent=hcpDisclaimer.isEnabled();
//			boolean ishcpHeadlinePresent=hcpHeadline.isEnabled();
//			//int ishcpPresent=hcpLocator.size();
//			
//			if(isHcpPresent)
//			{
//				System.out.println("HCP Disclaimer is present");
//				
//				childTestSite.log(Status.PASS, "Hcp Disclaimer is Present", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath(reportPath+testName+"_cookie.png",driver)).build());
//				hcpOkLocator.click();
//				
//				
//			}
//			else
//			{
//				System.out.println("Cookie is not present");
//				childTestSite.log(Status.FAIL, "Cookie is not Present", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath(reportPath+testName+"_cookie_fail.png",driver)).build());
//			}
//		}
	public void handleSiteExitPopup(WebElement cancelElement)
	{
		boolean siteExitPopup=cancelElement.isEnabled();
		if(siteExitPopup)
		{
			System.out.println("Site Exit popup is present");
			cancelElement.click();
		}
		else
		{
			System.out.println("Site Exit popup is not present");
		}
	}
	
	public  String takeScreenshotReturnPath(String imagePath,WebDriver driver)
	{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return imagePath;
	}
}
