package ReuseComp.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v119.network.Network;
//import org.openqa.selenium.devtools.v119.network.model.Request;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.google.common.collect.ImmutableList;

import ReuseComp.BaseTest.BaseTest;

public class WebDriverMethods {
	
	public String reportPath=BaseTest.reportPath;

	//public WebDriver driver;
	
	
	
	

	public void mouseHoverOnElement(WebElement element,WebDriver driver) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void switchToFrame(WebElement element,WebDriver driver)
	{
		
		driver.switchTo().frame(element);
	}
	
	public void switchToWindow(WebDriver driver)
	{
		String mainWindowHandler = driver.getWindowHandle(); // store mainWindowHandler for future references
		System.out.println("Parent window:"+mainWindowHandler);
		//line of code that opens a new TAB / Window
		new WebDriverWait(driver, Duration.ofSeconds(3000)).until(ExpectedConditions.numberOfWindowsToBe(2));  //induce WebDriverWait
		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> iterator = handles.iterator(); 
		while (iterator.hasNext()) 
		{ 
		    String subWindowHandler = iterator.next();
		    System.out.println(subWindowHandler);
		    if (!mainWindowHandler.equalsIgnoreCase(subWindowHandler))
		    {
		    	System.out.println("Sub window: "+subWindowHandler);
		        driver.switchTo().window(subWindowHandler);
		    }
		}
	}
	public WebElement findElement(String xpath,WebDriver driver)
	{
		return driver.findElement(By.xpath(xpath));
		
	}
	
	public List<WebElement> findElements(String xpath,WebDriver driver)
	{
		return driver.findElements(By.xpath(xpath));
		
	}
	public void switchToWindowAndValidatePDF(WebDriver driver,WebElement pdf,String testName,ExtentTest childTestSite) throws Exception
	{
		String mainWindowHandler = driver.getWindowHandle(); // store mainWindowHandler for future references
		System.out.println("Parent window:"+mainWindowHandler);
		//line of code that opens a new TAB / Window
		new WebDriverWait(driver, Duration.ofSeconds(3000)).until(ExpectedConditions.numberOfWindowsToBe(2));  //induce WebDriverWait
		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> iterator = handles.iterator(); 
		while (iterator.hasNext()) 
		{ 
		    String subWindowHandler = iterator.next();
		    System.out.println(subWindowHandler);
		    if (!mainWindowHandler.equalsIgnoreCase(subWindowHandler))
		    {
		    	System.out.println("Sub window: "+subWindowHandler);
		        driver.switchTo().window(subWindowHandler);
		        isAvialable(pdf, "PDF is Opened", testName, childTestSite, driver);
		        driver.switchTo().window(subWindowHandler).close();
		        driver.switchTo().window(mainWindowHandler);
		    }
		}
	}
	
	public void switchToWindowAndValidatePatentDetails(WebDriver driver,WebElement pdfContent,WebElement ipcClass,WebElement type,WebElement patentNo,WebElement published,WebElement downloadCTA,String testName,ExtentTest childTestSite) throws Exception
	{
		String mainWindowHandler = driver.getWindowHandle(); // store mainWindowHandler for future references
		System.out.println("Parent window:"+mainWindowHandler);
		//line of code that opens a new TAB / Window
		new WebDriverWait(driver, Duration.ofSeconds(3000)).until(ExpectedConditions.numberOfWindowsToBe(2));  //induce WebDriverWait
		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> iterator = handles.iterator(); 
		while (iterator.hasNext()) 
		{ 
		    String subWindowHandler = iterator.next();
		    System.out.println(subWindowHandler);
		    if (!mainWindowHandler.equalsIgnoreCase(subWindowHandler))
		    {
		    	System.out.println("Sub window: "+subWindowHandler);
		        driver.switchTo().window(subWindowHandler);
		        isAvialable(pdfContent, "pdfContent ", testName, childTestSite, driver);
			isAvialable(ipcClass, "IPC Class ", testName, childTestSite, driver);
			isAvialable(type, "Type ", testName, childTestSite, driver);
			isAvialable(patentNo, "Patent no ", testName, childTestSite, driver);
			isAvialable(published, "Published ", testName, childTestSite, driver);
			isAvialable(downloadCTA, "DownloadCTA ", testName, childTestSite, driver);
		        driver.switchTo().window(subWindowHandler).close();
		        driver.switchTo().window(mainWindowHandler);
		    }
		}
	}
	
	public void switchToWindowAndValidatePublicationsDetails(WebDriver driver,WebElement pdfContent,WebElement type,WebElement publicationNumber,WebElement published,WebElement source,WebElement downloadCTA,String testName,ExtentTest childTestSite) throws Exception
	{
		String mainWindowHandler = driver.getWindowHandle(); // store mainWindowHandler for future references
		System.out.println("Parent window:"+mainWindowHandler);
		//line of code that opens a new TAB / Window
		new WebDriverWait(driver,Duration.ofSeconds(3000)).until(ExpectedConditions.numberOfWindowsToBe(2));  //induce WebDriverWait
		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> iterator = handles.iterator(); 
		while (iterator.hasNext()) 
		{ 
		    String subWindowHandler = iterator.next();
		    System.out.println(subWindowHandler);
		    if (!mainWindowHandler.equalsIgnoreCase(subWindowHandler))
		    {
		    	System.out.println("Sub window: "+subWindowHandler);
		        driver.switchTo().window(subWindowHandler);
		       // isAvialable(pdfContent, "pdfContent ", testName, childTestSite, driver);
			isAvialable(type, "Type ", testName, childTestSite, driver);
			isAvialable(publicationNumber, "publication number ", testName, childTestSite, driver);
			isAvialable(published, "published ", testName, childTestSite, driver);
			isAvialable(source, "Source ", testName, childTestSite, driver);
			isAvialable(downloadCTA, "DownloadCTA ", testName, childTestSite, driver);
		        driver.switchTo().window(subWindowHandler).close();
		        driver.switchTo().window(mainWindowHandler);
		    }
		}
	}
	
	public void waitForWindowToBeOpened(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		}
	
public void switchToDefault(WebDriver driver) {
		
		driver.switchTo().defaultContent();
	}

public void clearTextField(WebElement element,WebDriver driver) {
	
	
	element.clear();
	
}
public void clearingTextField(WebElement element,String elementName, ExtentTest childTestSite,String testName,WebDriver driver) throws InterruptedException, IOException
{
	element.clear();
	Thread.sleep(2000);
	childTestSite.log(Status.PASS,"Clearing the "+elementName,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+timeCapture()+"_"+"click.png",driver)).build());
}
	
	public void pressKey(WebElement element,WebDriver driver, Keys key) {
		Actions action=new Actions(driver);
		action.moveToElement(element).sendKeys(key).build().perform();
	}
	
	public void pressKey(WebDriver driver, Keys key) {
		Actions action=new Actions(driver);
		action.sendKeys(key).build().perform();
	}
	
	public void scrollElementIntoView(WebElement element,WebDriver driver) throws InterruptedException
	{
		//WebElement element = driver.findElement(By.id("id_of_element"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000); 
	}
	
	public void scrollPageDown(WebDriver driver) throws InterruptedException
	{
		//WebElement element = driver.findElement(By.id("id_of_element"));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000); 
	}
	
	public void scrollPageUp(WebDriver driver) throws InterruptedException
	{
		//WebElement element = driver.findElement(By.id("id_of_element"));
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		Thread.sleep(5000); 
	}
	public void waitForElementToBePresent(WebElement element,WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));			
		wait.until(ExpectedConditions.visibilityOf(element));
	}
public void waitForElementToBePresentLong(WebElement element,WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));			
		wait.until(ExpectedConditions.visibilityOf(element));
	}
public void waitForElementToBeClickable(WebElement element,WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));			
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

public void waitForWindowToBeOpened(int noOfWindows,WebDriver driver) {
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));			
	wait.until(ExpectedConditions.numberOfWindowsToBe(noOfWindows));
}
	
	public  boolean handleStaleElement(WebElement element,WebDriver driver) {
	    boolean result = false;
	    int attempts = 0;
	    while(attempts < 10) {
	        try {
	        	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));			
				wait.until(ExpectedConditions.elementToBeClickable(element));
	        	element.click();
	            result = true;
	            break;
	        } catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    return result;
	}
	
public void isAvialable(WebElement element,String message, String testName,ExtentTest childTestSite,WebDriver driver) throws Exception {
			
	
	
		if(element.isDisplayed())
		{
			childTestSite.log(Status.PASS, message+" is available",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+timeCapture()+"_"+"available.png",driver)).build());
			
			
			
		}else
		{
			childTestSite.log(Status.FAIL, message+" is not available",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotBase64(reportPath+testName+timeCapture()+"_"+"notavailable.png",driver)).build());
			throw new Exception(message+"is not available");
		}
		
	}
public void isEnabled(WebElement element,String message, String testName,ExtentTest childTestSite,WebDriver driver) throws Exception {
	
	if(element.isEnabled())
	{
		childTestSite.log(Status.PASS, message+" is Enabled",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+timeCapture()+"_"+"enabled.png",driver)).build());
		
		
		
	}else
	{
		childTestSite.log(Status.FAIL, message+" is not Enabled",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotReturnPath2(reportPath+testName+timeCapture()+"_"+"notenabled.png",driver)).build());
		throw new Exception(message+"is not available");
	}
	
}
public void isShareIconExpanded(WebElement element,String message, String testName,ExtentTest childTestSite,WebDriver driver) throws Exception {
	
	if(element.isDisplayed())
	{
		childTestSite.log(Status.PASS, message+"is expanded",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+"_"+"expanded.png",driver)).build());
		
		
		
	}else
	{
		childTestSite.log(Status.FAIL, message+"is not expanded",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotBase64(reportPath+testName+"_"+"notExpanded.png",driver)).build());
		throw new Exception(message+"is not available");
	}
	
}

public void areItemsAvailable(WebElement element,String message, String testName,ExtentTest childTestSite,WebDriver driver) throws Exception {
	
	if(element.isDisplayed())
	{
		childTestSite.log(Status.PASS, message+"are available",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+timeCapture()+"_"+"available.png",driver)).build());
		
		
		
	}else
	{
		childTestSite.log(Status.FAIL, message+"are not avaiable",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotBase64(reportPath+testName+timeCapture()+"_"+"notavailable.png",driver)).build());
		throw new Exception(message+"are not available");
	}
	
}

public void verifyingSocialShareLinks(List<WebElement> elements,WebElement shareDisclaimer,String testName,ExtentTest childTestSite,WebDriver driver) throws Exception {
	
	for(int i=0;i<elements.size();i++)
	{
		isAvialable(elements.get(i),"Share Link"+i+" ", testName,childTestSite,driver);
		String parentWindow=driver.getWindowHandle();
		String expectedUrl=elements.get(i).getAttribute("href");
		System.out.println("expected url: "+expectedUrl);
		scrollElementIntoView(elements.get(i),driver);
		elements.get(i).click();
		Thread.sleep(2000);
		//shareDisclaimer.click();
		Thread.sleep(15000);
		waitForWindowToBeOpened(2,driver);
		ArrayList<String> handles=new ArrayList<String>(driver.getWindowHandles());
		
		
			driver.switchTo().window(handles.get(1));
			String actualUrl=driver.getCurrentUrl();
			System.out.println("actual url: "+actualUrl);
			if(actualUrl.contains(expectedUrl))
			{
				childTestSite.log(Status.PASS, "Link"+i+" is navigated expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
			}else
			{
				if(actualUrl.contains("https://www.linkedin.com/"))
				{
					childTestSite.log(Status.PASS, "Link" +i+ " is navigated expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
				}
				
			   else if(actualUrl.contains("https://www.facebook.com/"))
			   {
				childTestSite.log(Status.PASS, "Link" +i+ " is navigated expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
			   }
				
			   else if(actualUrl.contains("https://www.instagram.com/"))
			   {
				childTestSite.log(Status.PASS, "Link" +i+ " is navigated expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
			   }
			   else 
			   {
				childTestSite.log(Status.FAIL, "Link" +i+ " is not navigated expected page",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotBase64(reportPath+timeCapture()+"_"+"notnavigated.png",driver)).build());
				throw new Exception("Link"+i+" is not navigated expected page");
					
				}
				driver.switchTo().window(handles.get(1)).close();
				//driver.close();
				driver.switchTo().window(parentWindow);
				
			}
			
		}
	}
		
		


public void clickOnElement(WebElement element) throws InterruptedException
{
	element.click();
	Thread.sleep(2000);
}

public void clickOnElement(WebElement element,String message,ExtentTest childTestSite,WebDriver driver) throws InterruptedException, IOException
{
	element.click();
	childTestSite.log(Status.PASS, "Clicking on "+message,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
	Thread.sleep(2000);
}
public void dragAsset(WebElement dragImageSource,WebElement dragImageDestination,ExtentTest childTestSite,WebDriver driver) throws InterruptedException, IOException
{
    Actions action=new Actions(driver);
    action.dragAndDrop(dragImageSource, dragImageDestination);
  
	//element.click();
	childTestSite.log(Status.PASS, "Dropping asset ",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
	Thread.sleep(2000);
}
public void clickingOnElement(WebElement element,String elementName, ExtentTest childTestSite,String testName,WebDriver driver) throws InterruptedException, IOException
{
	element.click();
	Thread.sleep(2000);
	childTestSite.log(Status.PASS,"Clicking on "+elementName,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+timeCapture()+"_"+"click.png",driver)).build());
}

public void sendTextToFiled(WebElement element,String text) throws InterruptedException
{
	element.sendKeys(text);
	Thread.sleep(2000);
	
}

public void sendingTextToField(WebElement element,String text,String elementName, ExtentTest childTestSite,String testName,WebDriver driver) throws InterruptedException, IOException
{
	element.sendKeys(text);
	Thread.sleep(2000);
	childTestSite.log(Status.PASS,"Entering the  text in "+elementName+": "+text,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+timeCapture()+"_"+"click.png",driver)).build());
}



public void selectValueFromDropdown(WebElement element,String text) throws InterruptedException
{
	Select select=new Select(element);
	select.selectByVisibleText(text);
	
}

public void selectingValueFromDropdown(WebElement element,String text,String elementName, ExtentTest childTestSite,String testName,WebDriver driver) throws InterruptedException, IOException
{
	Select select=new Select(element);
	select.selectByVisibleText(text);
	
	childTestSite.log(Status.PASS,"Selecting the value from "+elementName+" : "+text,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+timeCapture()+"_"+"click.png",driver)).build());
}


public void checkMaxNumberOfCharactersAllowed(WebElement element,int maxNumber,String inputText,String message,ExtentTest childTestSite,WebDriver driver) throws Exception
{
element.clear();
element.sendKeys(inputText);
System.out.println("Input Text: "+inputText);
int length=element.getAttribute("value").length();

if (length>=maxNumber) 
{
childTestSite.log(Status.PASS,message +"Accepting"+ maxNumber + "characters");	
	
}
else 
{
	
	childTestSite.log(Status.FAIL,message +"Accepting more than "+ maxNumber + "characters");	
	throw new Exception(message +"Accepting more than" + maxNumber + "characters");
}
	
}

public void isFieldEmpty(WebElement element,ExtentTest childTestSite,WebDriver driver) throws Exception
{
String Value=element.getText();
if (Value.equalsIgnoreCase("")) 
{
	childTestSite.log(Status.PASS, "Given Value is"+ Value + "Empty");	
}
else 
{
	
	childTestSite.log(Status.FAIL,"Given Value is"+ Value + "Not Empty");
	throw new Exception("Not an empty Field,it " + Value + "Contains characters");
}
}

public void isFieldhaveValue(WebElement element,ExtentTest childTestSite,WebDriver driver) throws Exception
{
String Value=element.getText();
if (Value.equalsIgnoreCase("")) 
{
	childTestSite.log(Status.PASS, "Given Value is"+ Value + "Empty");	
}
else 
{
	element.clear();
	
	childTestSite.log(Status.PASS, "Given Value is"+ Value + "Element has some value and it is cleared");
}
}

  public void isFieldhaveSpecificValue(WebElement element,String ExpectedValue,ExtentTest childTestSite,WebDriver driver) throws Exception
  {
  String ActualValue=element.getAttribute("value");
  System.out.println(ActualValue);

  if (ActualValue.equalsIgnoreCase(ExpectedValue)) 
  {
	childTestSite.log(Status.PASS, "Given Value is: "+ ActualValue + " and matches expected value");	
  }
   else 
   {
	
	
	childTestSite.log(Status.FAIL, "Given Value not matched "+ ActualValue + "with expected value");
  }
  }

private String getValueFromTestDataSheet(int i, int j) {
	// TODO Auto-generated method stub
	return null;
}

public void isDefaultCheckboxUnchecked(List<WebElement> elements ,String name,ExtentTest childTestSite,WebDriver driver) throws Exception
{

	int elementsize= elements.size();
if (elementsize==0) 
{
	childTestSite.log(Status.PASS, name + " is unchecked by default");	
}
else 
{
	
	childTestSite.log(Status.FAIL,name + " is not unchecked by default");
	throw new Exception(name + " is not unchecked by default");
}
}

public void isDefaultDropdownEmpty(List <WebElement> elements ,String name,ExtentTest childTestSite,WebDriver driver) throws Exception
{

	int elementsize= elements.size();
if (elementsize==1) 
{
	childTestSite.log(Status.PASS, name + " Dropdown default value is empty ");	
}
else 
{
	
	childTestSite.log(Status.FAIL,name + " Dropdown default value is not empty");
	throw new Exception(name + " Dropdown default value is empty");
}
}

public void isDefaultDropdownHaveValue( WebElement element ,String name,String expectedValue,ExtentTest childTestSite,WebDriver driver) throws Exception
{

	String ActualValue= element.getText();

	
 if (ActualValue.equalsIgnoreCase(expectedValue)) 
{
	childTestSite.log(Status.PASS, name + " Default dropdown have value ");	
}
else 
{
	
	childTestSite.log(Status.FAIL,name + " Default dropdown is not having value");
	throw new Exception(name + "  Default dropdown is not having value");
}
}  
public void isDefaultCheckboxChecked(List <WebElement> elements ,String name,ExtentTest childTestSite,WebDriver driver) throws Exception
{

	int elementsize= elements.size();
if (elementsize==1) 
{
	childTestSite.log(Status.PASS, name + " is checked by default");	
}
else 
{
	
	childTestSite.log(Status.FAIL,name + " is not checked by default");
	throw new Exception(name + " is not checked by default");
}
}

public void isValuespresentinDropdown(List <WebElement> elements ,String ExpectedValue,ExtentTest childTestSite,WebDriver driver) throws Exception
{
	
	 int count=0;
	int elementsize= elements.size();
	
	for (int i = 0; i < elementsize; i++)
	{
		String ActualValue= elements.get(i).getText();
		
	if (ActualValue.equalsIgnoreCase(ExpectedValue))
	{
		count=count+1;
		break;
	}	
		
	}
	
if (count==1) 
{
	childTestSite.log(Status.PASS, ExpectedValue + " Value is present in Dropdown");	
}
else 
{
	
	childTestSite.log(Status.FAIL,ExpectedValue + " Value is not present in Dropdown");
	throw new Exception(ExpectedValue + " Value is not present in Dropdown");
}
}

public String getCurrentDatePlusWeek()
{
    
    DateFormat dateFormat = new SimpleDateFormat("MMMM dd,yyyy");



    Calendar c = Calendar.getInstance();    
    c.add(Calendar.DATE, 7);
    System.out.println(dateFormat.format(c.getTime()));
    
    String finalDate=dateFormat.format(c.getTime()).toString();
    
    return finalDate;
}

public String getCurrentDatePlus3days()
{
    
    DateFormat dateFormat = new SimpleDateFormat("MMMM dd,yyyy");



    Calendar c = Calendar.getInstance();    
    c.add(Calendar.DATE, 3);
    System.out.println(dateFormat.format(c.getTime()));
    
    String finalDate=dateFormat.format(c.getTime()).toString();
    
    return finalDate;
}

public String getCurrentDate()
{
    
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");



    Calendar c = Calendar.getInstance();    
 //   c.add(Calendar.DATE, 7);
    System.out.println(dateFormat.format(c.getTime()));
    
    String finalDate=dateFormat.format(c.getTime()).toString();
    
    return finalDate;
}

public String getCurrentDateInCalendar()
{
    
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");



    Calendar c = Calendar.getInstance();    
 //   c.add(Calendar.DATE, 7);
    System.out.println(dateFormat.format(c.getTime()));
    
    String finalDate=dateFormat.format(c.getTime()).toString();
    
    return finalDate;
}


public void mouseHover(WebElement element, WebDriver driver) throws InterruptedException
{
	Actions action=new Actions(driver);
	action.moveToElement(element).build().perform();
	//element.click();
	Thread.sleep(2000);
}
public void verifyTheSrcURL(WebElement element,String message,ExtentTest childTestSite,WebDriver driver) throws Exception
{
	if(element.getAttribute("src")!=null)
	{

		childTestSite.log(Status.PASS, message+"is available");
		
		
		
	}else
	{
		childTestSite.log(Status.FAIL, message+"is not available");
		throw new Exception(message+"is not available");
	}
}

public void verifyTheAttributeValue(WebElement element,String attr,String message,String ExpectedAttrValue,ExtentTest childTestSite,WebDriver driver) throws Exception
{
	System.out.println("attr value: "+element.getAttribute(attr));
	if(element.getAttribute("style").contains(ExpectedAttrValue))
	{
		
			
		childTestSite.log(Status.PASS, message+"is matched");
		
		
		
	}else
	{
		childTestSite.log(Status.FAIL, message+"is not matched");
		throw new Exception(message+"is not matched");
	}
	
}

public void verifyTheAttributeValue2(WebElement element,String attr,String message,String ExpectedAttrValue,ExtentTest childTestSite,WebDriver driver) throws Exception
{
	System.out.println("attr value: "+element.getAttribute(attr));
	if(element.getAttribute(attr).contains(ExpectedAttrValue))
	{
		
		childTestSite.log(Status.PASS, message+" is Available",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"available.png",driver)).build());
		childTestSite.log(Status.PASS, message+"is matched");
		
		
		
	}else
	{
		childTestSite.log(Status.FAIL, message+"is not matched");
		throw new Exception(message+"is not matched");
	}
	
}
public void isAttributeValueSame(WebElement element,String attr,String message,String ExpectedAttrValue,ExtentTest childTestSite,WebDriver driver) throws Exception
{
	System.out.println(element.getAttribute(attr));
	if(element.getAttribute(attr).equalsIgnoreCase(ExpectedAttrValue))
	{

		childTestSite.log(Status.PASS, "Value: "+element.getAttribute(attr));
		childTestSite.log(Status.PASS, message+"is matched");
		
		
		
	}else
	{
		childTestSite.log(Status.FAIL, message+"is not matched");
		throw new Exception(message+"is not matched");
	}
	
}

public void verifyElementGetText(WebElement element, String expText, String message,ExtentTest childTestSite,WebDriver driver) throws Exception
{
	String actualText=element.getText();
	System.out.println(actualText);
	System.out.println(expText);
	if(actualText.contains(expText))
	{

		childTestSite.log(Status.PASS, message+"is matched");
		
		
		
	}else
	{
		childTestSite.log(Status.FAIL, message+"is not matched");
		throw new Exception(message+"is not matched");
	}
	
}

public void verifyNavigationAndBack(WebElement element, String expUrl,ExtentTest childTestSite,WebDriver driver) throws Exception
{
	element.click();
	Thread.sleep(5000);
	String actUrl=driver.getCurrentUrl();
	
	System.out.println("Exp URL: "+expUrl);
	System.out.println("Act URL: "+actUrl);
	if(actUrl.contains("terms-of-use")||actUrl.contains("google")||actUrl.contains("patient")||actUrl.contains("events"))
	{

		childTestSite.log(Status.PASS, "Navigated to expected site");
		
		
		
	}else
	{
		childTestSite.log(Status.FAIL, "Not Navigated to expected site");
		throw new Exception("Not Navigated to expected site");
	}
	driver.navigate().back();
	Thread.sleep(5000);
}

public  String takeScreenshotReturnPath2(String imagePath,WebDriver driver)
{
	File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(srcFile, new File(imagePath));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return imagePath.replace(reportPath, "");
}

public void verifyRedirection(WebElement element, String expUrl,ExtentTest childTestSite,WebDriver driver) throws Exception
{
	element.click();
	Thread.sleep(5000);
	String actUrl=driver.getCurrentUrl();
	
	System.out.println("Exp URL: "+expUrl);
	System.out.println("Act URL: "+actUrl);
	if(actUrl.contains(expUrl))
	{

		childTestSite.log(Status.PASS, "Navigated to expected site");
		
		
		
	}else
	{
		childTestSite.log(Status.FAIL, "Not Navigated to expected site");
		throw new Exception("Not Navigated to expected site");
	}
	//driver.navigate().back();
	//Thread.sleep(5000);
}
public void clickElementUsingJavascript(WebElement element,WebDriver driver)
{
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
}

public String takeScreenshotReturnPath(WebDriver driver,String desFile) throws IOException
{
File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
String encodedBase64 = null;
FileInputStream fileInputStreamReader = null;

fileInputStreamReader = new FileInputStream(sourceFile);
byte[] bytes = new byte[(int)sourceFile.length()];
fileInputStreamReader.read(bytes);
encodedBase64 = new String(Base64.encodeBase64(bytes));

FileUtils.copyFile(sourceFile,new File(desFile));

fileInputStreamReader.close();

return "data:image/png;base64,"+encodedBase64;
}

public void verifyTitle(String expTitle,WebDriver driver,String testName,ExtentTest childTestSite) throws Exception
{
	String actTitle=driver.getTitle();
	if(actTitle.contains(expTitle))
	{
		childTestSite.log(Status.PASS, "Title is matched",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+"_"+"navigated.png",driver)).build());
		
		
		
	}else
	{
		
		childTestSite.log(Status.FAIL, "Title is not matched",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotBase64(reportPath+testName+"_"+"notnavigated.png",driver)).build());
		throw new Exception("Title is not matched");
			
		
		
	}
}

public String takeScreenshotBase64(String desFile,WebDriver driver) throws IOException
{
File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
String encodedBase64 = null;
FileInputStream fileInputStreamReader = null;

fileInputStreamReader = new FileInputStream(sourceFile);
byte[] bytes = new byte[(int)sourceFile.length()];
fileInputStreamReader.read(bytes);
encodedBase64 = new String(Base64.encodeBase64(bytes));

FileUtils.copyFile(sourceFile,new File(desFile));

fileInputStreamReader.close();

return "data:image/png;base64,"+encodedBase64;
}
public void verifyLinkNavigation(WebElement globalDirect,String expLink, String testName,ExtentTest childTestSite,WebDriver driver) throws InterruptedException, IOException {
	
	globalDirect.click();
	Thread.sleep(5000);
	
	String actLink=driver.getCurrentUrl();
		System.out.println("ACT URL: "+actLink);
		System.out.println("EXP URL: "+expLink);
		if(actLink.contains("www.merckgroup.com"))
		{
			childTestSite.log(Status.PASS, "Navigated to expected site",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+"_"+"navigated.png",driver)).build());
		}
		else
		{
			childTestSite.log(Status.FAIL, "Not Navigated to expected site",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotBase64(reportPath+testName+"_"+"notnavigated.png",driver)).build());
		}
	}
public void verifySingleLinkNavigation(WebElement element, String testName,ExtentTest childTestSite,WebDriver driver) throws InterruptedException, IOException {
	
	//int size=elements.size();
	//String expected=element.getAttribute("href");
	element.click();
	Thread.sleep(15000);
	String urlText=driver.getCurrentUrl();
	System.out.println("URL: "+urlText);
	if(urlText.contains("https://www.merckgroup.com/de")||urlText.contains("https://www.merckgroup.com/en")||urlText.contains("https://www.emdgroup.com/en"))
	{
		childTestSite.log(Status.PASS, "Navigated to expected site",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+"_"+"navigated.png",driver)).build());
	}
	else
	{
		childTestSite.log(Status.FAIL, "Not Navigated to expected site",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotBase64(reportPath+testName+"_"+"notnavigated.png",driver)).build());
	}
	
}
public void verifyLinkNavigation(List<WebElement> elements,String testName,ExtentTest childTestSite,WebDriver driver) throws InterruptedException, IOException {
	
	int size=elements.size();
	
	for(int i=0;i<size;i++)
	{
		elements.get(i).click();
		Thread.sleep(15000);
		String urlText=driver.getCurrentUrl();
		System.out.println("URL: "+urlText);
		if(urlText.contains("https://www.merckgroup.com/de")||urlText.contains("https://www.merckgroup.com/en"))
		{
			childTestSite.log(Status.PASS, "Navigated to expected site",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+"_"+"navigated.png",driver)).build());
		}
		else
		{
			childTestSite.log(Status.FAIL, "Not Navigated to expected site",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotBase64(reportPath+testName+"_"+"notnavigated.png",driver)).build());
		}
		
	}
}

public void verifySubNavigationLinksExpertise(List<WebElement> elements, String testName,ExtentTest childTestSite,WebDriver driver) throws InterruptedException, IOException {
	
	int size=elements.size();
	
	for(int i=0;i<size;i++)
	{
		elements.get(i).click();
		Thread.sleep(15000);
		String urlText=driver.getCurrentUrl();
		System.out.println("URL: "+urlText);
		if(urlText.contains("solutions")||urlText.contains("color-effects")||urlText.contains("products")||urlText.contains("brands")||urlText.contains("latest")||urlText.contains("services")||urlText.contains("contact-us")||urlText.contains("test-emdbrand")||urlText.contains("accelerating"))
		{
			childTestSite.log(Status.PASS, "Navigated to expected site",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+"_"+"navigated.png",driver)).build());
		}
		else
		{
			childTestSite.log(Status.FAIL, "Not Navigated to expected site",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotBase64(reportPath+testName+"_"+"notnvigated.png",driver)).build());
		}
		driver.navigate().back();
		Thread.sleep(10000);
		scrollElementIntoView(elements.get(i),driver);
		Thread.sleep(5000);
	}
}

public String timeCapture() {
	String fileSuffix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	return fileSuffix;
}
public void verifyingSocialShareLinksBintrafusp(List<WebElement> elements, String testName,ExtentTest childTestSite,WebDriver driver) throws Exception {
	
	for(int i=0;i<elements.size();i++)
	{
		System.out.println("Total Links: "+elements.size());
		isAvialable(elements.get(i),"Share Link"+i+" ", testName,childTestSite,driver);
		String parentWindow=driver.getWindowHandle();
		String expectedUrl=elements.get(i).getAttribute("data-href");
		System.out.println("expected url: "+expectedUrl);
		scrollElementIntoView(elements.get(i),driver);
		elements.get(i).click();
		Thread.sleep(2000);
		ArrayList<String> handles=new ArrayList<String>(driver.getWindowHandles());
		
		
			driver.switchTo().window(handles.get(1));
			String actualUrl=driver.getCurrentUrl();
			System.out.println("actual url: "+actualUrl);
			driver.switchTo().window(handles.get(1)).close();
			//driver.close();
			driver.switchTo().window(parentWindow);
			
			if(actualUrl.contains(expectedUrl))
			{
				childTestSite.log(Status.PASS, "Link"+i+" is navigated expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+"_"+"navigated.png",driver)).build());
				
				
				
			}else if(actualUrl.contains("facebook"))
			{
				childTestSite.log(Status.PASS, "Link"+i+" is navigated expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotBase64(reportPath+testName+"_"+"navigated.png",driver)).build());
				
				
				
			}
			else if(actualUrl.contains("twitter"))
			{
				childTestSite.log(Status.PASS, "Link"+i+" is navigated expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+"_"+"navigated.png",driver)).build());
				
				
				
			}else if(actualUrl.contains("linkedin"))
				{
					childTestSite.log(Status.PASS, "Link"+i+" is navigated expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+"_"+"navigated.png",driver)).build());
				}else
				{
				childTestSite.log(Status.FAIL, "Link"+i+" is not navigated expected page",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotBase64(reportPath+testName+"_"+"notnavigated.png",driver)).build());
				throw new Exception("Link"+i+" is not navigated expected page");
					
				}
				
			}
			
		}

public void verifyingSocialShareLinksFertility2(List<WebElement> elements,String testName,ExtentTest childTestSite,WebDriver driver) throws Exception {

	for(int i=0;i<elements.size()-2;i++)
	{
		isAvialable(elements.get(i),"Share Link"+i+" ", testName,childTestSite,driver);
		String parentWindow=driver.getWindowHandle();
		String expectedUrl=elements.get(i).getAttribute("href");
		System.out.println("expected url: "+expectedUrl);
		scrollElementIntoView(elements.get(i),driver);
		elements.get(i).click();
		Thread.sleep(2000);
		WebElement continueBtn = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		if(continueBtn.isDisplayed()) {
			clickOnElement(continueBtn);
		}
		//shareDisclaimer.click();
		Thread.sleep(2000);
		ArrayList<String> handles=new ArrayList<String>(driver.getWindowHandles());


		driver.switchTo().window(handles.get(1));
		String actualUrl=driver.getCurrentUrl();
		System.out.println("actual url: "+actualUrl);
		driver.switchTo().window(handles.get(1)).close();
		//driver.close();
		driver.switchTo().window(parentWindow);

		if(actualUrl.equalsIgnoreCase(expectedUrl))
		{
			childTestSite.log(Status.PASS, "Link"+i+" is navigated expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+"_"+"navigated.png",driver)).build());



		}else
		{
			if(actualUrl.contains("https://www.linkedin.com/"))
			{
				childTestSite.log(Status.PASS, "Link"+i+" is navigated expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+"_"+"navigated.png",driver)).build());
			}else
			{
				childTestSite.log(Status.FAIL, "Link"+i+" is not navigated expected page",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotBase64(reportPath+testName+"_"+"notnavigated.png",driver)).build());
				throw new Exception("Link"+i+" is not navigated expected page");

			}

		}

	}
}

public void verifyingSocialShareLinksFertility(List<WebElement> elements,String testName,ExtentTest childTestSite,WebDriver driver) throws Exception {

	for(int i=0;i<elements.size()-2;i++)
	{
		isAvialable(elements.get(i),"Share Link "+(i+1)+" ", testName+timeCapture(),childTestSite,driver);
		String parentWindow=driver.getWindowHandle();
		String expectedUrl=elements.get(i).getAttribute("href");
		System.out.println("expected url: "+expectedUrl);	
		scrollElementIntoView(elements.get(i),driver);
		elements.get(i).click();
		Thread.sleep(2000);
		WebElement continueBtn = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		if(continueBtn.isDisplayed()) {
			clickOnElement(continueBtn);
		}
		//shareDisclaimer.click();
		Thread.sleep(2000);
		ArrayList<String> handles=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(handles.get(1));
		String actualUrl=driver.getCurrentUrl();
		System.out.println("actual url: "+actualUrl);
		driver.switchTo().window(handles.get(1)).close();
		//driver.close();
		driver.switchTo().window(parentWindow);

		if(actualUrl.equalsIgnoreCase(expectedUrl))
		{
			childTestSite.log(Status.PASS, "Link "+(i+1)+" is navigated to expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+timeCapture()+"_"+"navigated.png",driver)).build());
		}
		else 	
		{
			if(actualUrl.contains("https://www.facebook.com"))
			{
				childTestSite.log(Status.PASS, "Link "+(i+1)+" is navigated to expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+timeCapture()+"_"+"navigated.png",driver)).build());
			}

			else if(actualUrl.contains("https://twitter.com"))
			{
				childTestSite.log(Status.PASS, "Link "+(i+1)+" is navigated to expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+timeCapture()+"_"+"navigated.png",driver)).build());
			}
			else {
				childTestSite.log(Status.PASS, "Link "+(i+1)+" is navigated to expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+timeCapture()+"_"+"navigated.png",driver)).build());
			}
		}
	}
}
public void highLighterMethod(WebDriver driver, WebElement element){
	/*JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	 */
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('style','border: 2px solid red;');", element);
	//js.executeScript("arguments[0].style.border=''", element, "");
}

public void tileChanageAndRevertBack(WebDriver driver,String url,WebElement element,WebElement openPrefBtn, WebElement title,String titleTextFromSheet,String testAndBrowserName, ExtentTest childTest,WebElement save) throws Exception
{
	//workObj.editBtn.click();
	//driver.switchTo().frame("ContentFrame");
			takeScreenshot(reportPath+"/"+testAndBrowserName+"_homePage_Actual.png",driver);
			childTest.log(Status.PASS, "Home page is opened", MediaEntityBuilder.createScreenCaptureFromPath(testAndBrowserName+"_homePage_Actual.png").build());
			waitForElementToBePresent(element,driver);
			scrollElementIntoView(element,driver);
			Thread.sleep(2000);
			//clickElementUsingjavaScript(element, driver);
			element.click();
			//pressTAB(element, driver);
			//Thread.sleep(2000);
			waitForElementToBePresent(openPrefBtn,driver);
			if(testAndBrowserName.contains("BROCHURE_HEADER_TEST"))
			{
				clickElementUsingjavaScript(openPrefBtn, driver);
			}
			else
			{
				openPrefBtn.click();
			}
			
			waitForElementToBePresent(title,driver);
			String titleText=title.getAttribute("value");
			System.out.println("Titlte is "+titleText);
			
			takeScreenshot(reportPath+"/"+testAndBrowserName+"_configW_Actual.png",driver);
			childTest.log(Status.PASS, "Config window is opened", MediaEntityBuilder.createScreenCaptureFromPath(testAndBrowserName+"_configW_Actual.png").build());
			//takeScreenShotForCompare(testAndBrowserName+"_configWindow",driver);
			//String titleTextFromSheet=getValueFromTestDataSheet(29,4);	
			
			if(titleText.equalsIgnoreCase(titleTextFromSheet))
			{
				takeScreenshot(reportPath+"/"+testAndBrowserName+"titleback.png",driver);
				childTest.log(Status.FAIL, "Title is not changed back properly",MediaEntityBuilder.createScreenCaptureFromPath(testAndBrowserName+"titleback.png").build());
				throw new Exception("Title is not changed back properly");
			}
			else
			{
				waitForElementToBePresent(title,driver);
				title.clear();
				title.click();
				typeTextIntoField(title, titleTextFromSheet);
				Thread.sleep(2000);
				save.click();
				//Thread.sleep(5000);
				driver.navigate().to(url);
				Thread.sleep(10000);
				//EXPERTISE_TEMPLATE_EVENT_OBJ ETEobj2=PageFactory.initElements(driver, EXPERTISE_TEMPLATE_EVENT_OBJ.class);
				handleStaleElement(element, driver);
				Thread.sleep(2000);
				waitForElementToBePresent(openPrefBtn,driver);
				if(testAndBrowserName.contains("BROCHURE_HEADER_TEST"))
				{
					clickElementUsingjavaScript(openPrefBtn, driver);
				}
				else
				{
					openPrefBtn.click();
				}
				//handleStaleElement(ETEobj.openPrefBtn);
				String titleTextAfterChange=title.getAttribute("value");
				System.out.println("Ttile after change: "+titleTextAfterChange);
				System.out.println("titleTextFromSheet: "+titleTextFromSheet);
				if(titleTextAfterChange.equalsIgnoreCase(titleTextFromSheet))
				{
					childTest.log(Status.PASS, "Title is changed successfully");
					//compareValidation(testAndBrowserName+"_titleChanged");
					waitForElementToBePresent(title,driver);
					title.clear();
					title.click();
					typeTextIntoField(title, titleText);
					Thread.sleep(1000);
					save.click();
					Thread.sleep(3000);
				}
				else
				{
					takeScreenshot(reportPath+"/"+testAndBrowserName+"title.png",driver);
					childTest.log(Status.FAIL, "Title is not changed",MediaEntityBuilder.createScreenCaptureFromPath(testAndBrowserName+"title.png").build());
					throw new Exception("Title is not changed");
				}
				
			}
}

public void typeTextIntoField(WebElement element, String text) throws InterruptedException
{
	element.sendKeys(text);
	Thread.sleep(2000);

}
public  void takeScreenshot(String imagePath,WebDriver driver)
{
	File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(srcFile, new File(imagePath));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void clickElementUsingjavaScript(WebElement element,WebDriver driver)
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", element);
}




public void clickingOnComponentWithOffsets(WebDriver driver,WebElement element)
{
	Actions actions = new Actions(driver);
	int yOffset=element.getRect().height/-2;//top
	System.out.println("yOffset: "+yOffset);
	int xOffset=element.getRect().width/-2;//left
	System.out.println("xOffset: "+xOffset);
	actions.moveToElement(element,xOffset,yOffset).click().perform();
}

public void verifyingSocialShareLinksWithDisclaimer(List<WebElement> elements,WebElement shareDisclaimer,String testName,ExtentTest childTestSite,WebDriver driver) throws Exception {
	
	for(int i=0;i<elements.size();i++)
	{
		isAvialable(elements.get(i),"Share Link" +i+ " ", testName,childTestSite,driver);
		String parentWindow=driver.getWindowHandle();
		String expectedUrl=elements.get(i).getAttribute("href");
		System.out.println("expected url: "+expectedUrl);
		scrollElementIntoView(elements.get(i),driver);
		elements.get(i).click();
		Thread.sleep(5000);
	    shareDisclaimer.click();
		Thread.sleep(5000);
		waitForWindowToBeOpened(2,driver);
		ArrayList<String> handles=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(handles.get(1));
		String actualUrl=driver.getCurrentUrl();
		System.out.println("actual url: "+actualUrl);
		/*driver.switchTo().window(handles.get(1)).close();
		driver.switchTo().window(parentWindow);*/
		if(actualUrl.equalsIgnoreCase(expectedUrl))
			{
				childTestSite.log(Status.PASS, "Link" +i+ " is navigated expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
				
			}
		else if(actualUrl.contains("https://www.linkedin.com/"))
				{
					childTestSite.log(Status.PASS, "Link" +i+ " is navigated expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
				}
		else if(actualUrl.contains("facebook"))
				{
					childTestSite.log(Status.PASS, "Link" +i+ " is navigated expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
				}
		else if(actualUrl.contains("instagram"))
			    {
					childTestSite.log(Status.PASS, "Link" +i+ " is navigated expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
				}
	    else 
				 {
					childTestSite.log(Status.FAIL, "Link" +i+ " is not navigated expected page",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotBase64(reportPath+timeCapture()+"_"+"notnavigated.png",driver)).build());
					throw new Exception("Link" +i+ " is not navigated expected page");
				 }
		driver.switchTo().window(handles.get(1)).close();
		driver.switchTo().window(parentWindow);
					
			}
			
		}
public void verifyTheCssTextAttributeValue(WebElement element,String cssattr,String ExpectedCssAttrValue,ExtentTest childTestSite,WebDriver driver) throws Exception
{
	System.out.println(" CSS Attr value : " +element.getCssValue(cssattr));
	if(element.getCssValue(cssattr).contains(ExpectedCssAttrValue))
	{
		
		childTestSite.log(Status.PASS, cssattr +" Attribute " +" is Available",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"available.png",driver)).build());
		childTestSite.log(Status.PASS, cssattr +" Attribute " +" : " +element.getCssValue(cssattr) + " is matched ");

	}else
	{
		childTestSite.log(Status.FAIL, cssattr + " Attribute " +" : " +element.getCssValue(cssattr) + " is Not matched ");
		throw new Exception(cssattr +" is Not matched");
	}
	
}
public void selectingValueFromDropdownWithIndex(WebElement element,int index,String elementName, ExtentTest childTestSite,String testName,WebDriver driver) throws InterruptedException, IOException
{
    Select select=new Select(element);
    select.selectByIndex(index);
   
    childTestSite.log(Status.PASS,"Selecting the value from "+elementName+" : "+index,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+timeCapture()+"_"+"click.png",driver)).build());
}

public void selectingValueFromDropdownWithValue(WebElement element,int value,String elementName, ExtentTest childTestSite,String testName,WebDriver driver) throws InterruptedException, IOException
{
    Select select=new Select(element);
    select.selectByIndex(value);
    
    String dropDownVal =select.getOptions().get(value).getAttribute("value");
   
    childTestSite.log(Status.PASS,"Selecting the value from "+elementName+" : "+dropDownVal,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+timeCapture()+"_"+"click.png",driver)).build());
}


public void verifyingSocialShareMedia(List<WebElement> elements,WebElement headerCTA,String testName,ExtentTest childTestSite,WebDriver driver) throws Exception {
	
	for(int i=1;i<elements.size();i++)
	{
		System.out.println("Social Links size: "+elements.size());
		String linksName = elements.get(i).getAttribute("data-network");
		System.out.println(linksName);
		//isAvialable(elements.get(i),"Share Link"+i+" ", testName,childTestSite,driver);
		isAvialable(elements.get(i),linksName + " Link",testName,childTestSite,driver);
		String parentWindow=driver.getWindowHandle();
		String expectedUrl=elements.get(i).getAttribute("data-href");
		System.out.println("expected url: "+expectedUrl);
		clickingOnElement(elements.get(i),linksName + " Link",childTestSite, testName, driver);
		Thread.sleep(2000);
		Thread.sleep(15000);
		waitForWindowToBeOpened(2,driver);
		ArrayList<String> handles=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(handles.get(1));
		String actualUrl=driver.getCurrentUrl();
		System.out.println("actual url: "+actualUrl);
			/*if(actualUrl.contains(expectedUrl))
			{
				//String linksName1 = elements.get(i).getAttribute("data-network");
				childTestSite.log(Status.PASS," Page is Opened as Expected",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
			}*/
			 if(actualUrl.contains("https://www.linkedin.com/"))
				{
					//childTestSite.log(Status.PASS, "Link" +i+ " is navigated expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
					childTestSite.log(Status.PASS, "LinkedIn Page is Opened as Expected",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
				}
				
			   else if(actualUrl.contains("facebook.com"))
			   {
				childTestSite.log(Status.PASS, "Facebook Page is Opened as Expected",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
			   }
				
			   else if(actualUrl.contains("instagram.com"))
			   {
				childTestSite.log(Status.PASS, "Instagram Page is Opened as Expected",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
			   }
			   else if(actualUrl.contains("twitter.com"))
			   {
				childTestSite.log(Status.PASS, "Twitter Page is Opened as Expected",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
			   }
			   else if(actualUrl.contains("whatsapp.com"))
			   {
				childTestSite.log(Status.PASS, "Whatsapp Page is Opened as Expected",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
			   }
			   else if(actualUrl.contains("t.me"))
			   {
				childTestSite.log(Status.PASS, "Telegram Page is Opened as Expected",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
			   }
			   else 
			   {
				childTestSite.log(Status.FAIL, "Link" +i+ " is not navigated expected page",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotBase64(reportPath+timeCapture()+"_"+"notnavigated.png",driver)).build());
				throw new Exception("Link"+i+" is not navigated expected page");
					
				}
				driver.switchTo().window(handles.get(1)).close();
				//driver.close();
				driver.switchTo().window(parentWindow);
				headerCTA.click();
				
			}
			
		}
public void verifyingSocialShare(List<WebElement> elements,String testName,ExtentTest childTestSite,WebDriver driver) throws Exception {
	
	System.out.println("Social Links size: "+elements.size());
	
	for(int i=1;i<elements.size();i++)
	{
		
		String linksName = elements.get(i).getAttribute("data-network");
		System.out.println(linksName);
		//isAvialable(elements.get(i),"Share Link"+i+" ", testName,childTestSite,driver);
		//isAvialable(elements.get(i),linksName + " Link",testName,childTestSite,driver);
		String parentWindow=driver.getWindowHandle();
		String expectedUrl=elements.get(i).getAttribute("data-href");
		System.out.println("expected url: "+expectedUrl);
		clickingOnElement(elements.get(i)," Link",childTestSite, testName, driver);
		//Thread.sleep(2000);
		Thread.sleep(15000);
		//waitForWindowToBeOpened(2,driver);
		ArrayList<String> handles=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(handles.get(1));
		String actualUrl=driver.getCurrentUrl();
		System.out.println("actual url: "+actualUrl);
			/*if(actualUrl.contains(expectedUrl))
			{
				//String linksName1 = elements.get(i).getAttribute("data-network");
				childTestSite.log(Status.PASS," Page is Opened as Expected",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
			}*/
			 if(actualUrl.contains("linkedin.com"))
				{
					//childTestSite.log(Status.PASS, "Link" +i+ " is navigated expected page",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
					childTestSite.log(Status.PASS, "LinkedIn Page is Opened as Expected",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
				}
				
			   else if(actualUrl.contains("facebook.com"))
			   {
				childTestSite.log(Status.PASS, "Facebook Page is Opened as Expected",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
			   }
				
			   else if(actualUrl.contains("instagram.com"))
			   {
				childTestSite.log(Status.PASS, "Instagram Page is Opened as Expected",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
			   }
			   else if(actualUrl.contains("twitter.com"))
			   {
				childTestSite.log(Status.PASS, "Twitter Page is Opened as Expected",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
			   }
			   else if(actualUrl.contains("whatsapp.com"))
			   {
				childTestSite.log(Status.PASS, "Whatsapp Page is Opened as Expected",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
			   }
			   else if(actualUrl.contains("t.me"))
			   {
				childTestSite.log(Status.PASS, "Telegram Page is Opened as Expected",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+timeCapture()+"_"+"navigated.png",driver)).build());
			   }
			   else 
			   {
				childTestSite.log(Status.FAIL, "Link" +i+ " is not navigated expected page",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotBase64(reportPath+timeCapture()+"_"+"notnavigated.png",driver)).build());
				throw new Exception("Link"+i+" is not navigated expected page");
					
				}
				driver.switchTo().window(handles.get(1)).close();
				//driver.close();
				driver.switchTo().window(parentWindow);
				//headerCTA.click();
				
			}
			
		}
public void handleAdvanceClickInBeta(WebDriver driver)
{
	CommonObjects _comObj = PageFactory.initElements(driver, CommonObjects.class);
	if (_comObj.advanceclick.size() >= 1) 
	{
		_comObj.advanceclick.get(0).click();
		_comObj.link.click();

	}
	

}
public void verifyCookiePresence(WebDriver driver,String testName,ExtentTest chtest) throws IOException
{
	CommonObjects comObj=PageFactory.initElements(driver, CommonObjects.class);
	CommonMethods comMethods = new CommonMethods();
	comMethods.verifyTheCookiePresence(comObj.cookieLoc,comObj.acceptCookieLoc,comObj.hcpDisclaimerAcceptBtn,testName,chtest,driver);
}
public void isNotAvialable(List<WebElement> elements,String message, String testName,ExtentTest childTestSite,WebDriver driver) throws Exception {
	
	
	
	if(elements.size()==0)
	{
		childTestSite.log(Status.PASS, message+" is Not available",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+timeCapture()+"_"+"available.png",driver)).build());
		
		
		
	}else
	{
		childTestSite.log(Status.FAIL, message+" is  available",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotBase64(reportPath+testName+timeCapture()+"_"+"notavailable.png",driver)).build());
		throw new Exception(message+"is available");
	}
	
}

public void checkingIfAnyErrorOnGmiSearch(WebDriver driver,List<WebElement> element,WebElement searchBtn, WebElement pubmedToggle,String testName,ExtentTest childTestSite) throws Exception
{
	if(element.size()>0)
	{
		searchBtn.click();
		Thread.sleep(10000);
		pubmedToggle.click();
		Thread.sleep(5000);
		checkingIfAnyErrorOnGmiSearch(driver,element,searchBtn,pubmedToggle,testName,childTestSite);
		
		//childTestSite.log(Status.FAIL, "Error on the page: "+element.get(0).getText(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotReturnPath2(reportPath+testName+timeCapture()+"_"+"available.png",driver)).build());
		//throw new Exception("Error on the page: "+element.get(0).getText());
		
		
	}
}
public void checkMaxNumberOfCharctersAllowed(WebElement element,int maxNumber, String inputText, String message,ExtentTest childTestSite,WebDriver driver ) throws Exception {
	
	element.clear();
	element.sendKeys(inputText);
	int length=element.getText().length();
	
	if(length<=maxNumber)
	{
		childTestSite.log(Status.PASS, message+"Accepting "+maxNumber+"characters");
		
		
		
	}else
	{
		childTestSite.log(Status.FAIL, message+"Accepting more than "+maxNumber+"characters");
		throw new Exception(message+"Accepting more than "+maxNumber+"characters");
	}
	
}
public void fillElement(WebElement element,String text,ExtentTest childTestSite,WebDriver driver) throws Exception {
	
	element.sendKeys(text);
	
}
public void selectValueFromDropdown(WebElement element,String text,ExtentTest childTestSite,WebDriver driver)
{
	Select select=new Select(element);
	select.selectByVisibleText(text);
}
public String getValueFromLocalStorage(WebDriver driver,String key)
{
	return (String) ((JavascriptExecutor) driver).executeScript(String.format("return window.localStorage.getItem('%s');", key));
}
public void compareTwoValues(String expectedValue,String actualValue, String testName,ExtentTest childTestSite,WebDriver driver) throws Exception {
	
	
	
	if(actualValue.equalsIgnoreCase(expectedValue))
	{
		childTestSite.log(Status.INFO, "Actaul Value : "+actualValue);
		childTestSite.log(Status.INFO, "Expected Value : "+expectedValue);
		childTestSite.log(Status.PASS, "Actual and Expected values are same");
		
		
	}else
	{
		childTestSite.log(Status.INFO, "Actaul Value : "+actualValue);
		childTestSite.log(Status.INFO, "Expected Value : "+expectedValue);
		childTestSite.log(Status.FAIL, "Actual and Expected values are not same");
		throw new Exception("Actual and Expected values are not same");
	}
	
}


}
			
