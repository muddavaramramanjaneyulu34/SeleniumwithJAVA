package ReuseComp.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.imageio.ImageIO;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import ReuseComp.BaseTest.BaseTest;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;





public class WebDriverMethods {
	
	public static String reportPath=BaseTest.reportPath;
	public static  String date1;
	
	
	
	public void Getproperties() {
		
	}
	public void mouseHoverOnElement1(String elementxpath,String Signout,String elementname,WebDriver driver,ExtentTest childTestSite) throws IOException, InterruptedException {
		Actions action=new Actions(driver);
		WebElement element=driver.findElement(By.xpath(elementxpath));
		//action.moveToElement(element).perform();
		action.moveToElement(element);
		Thread.sleep(500);
		WebElement element1=driver.findElement(By.xpath(Signout));
		action.moveToElement(element1);
		action.click().build().perform();
		
		//childTestSite.log(Status.PASS,"Hovering on "+elementname,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotAsBase64(reportPath+timeCapture()+"_"+"Hover.png",driver)).build());
		//childTestSite.log(Status.PASS,"Hovering on "+elementname,MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64(reportPath+timeCapture()+"_"+"Hover.png",driver)).build());

	}
	public void mouseHoverOnElement(String elementxpath,String elementname,WebDriver driver,ExtentTest childTestSite) throws IOException, InterruptedException {
		Actions action=new Actions(driver);
		WebElement element=driver.findElement(By.xpath(elementxpath));
		action.moveToElement(element).perform();
		Thread.sleep(2000);
		
		childTestSite.log(Status.PASS,"Hovering on "+elementname,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotAsBase64(reportPath+timeCapture()+"_"+"Hover.png",driver)).build());
		
	}

	public void pressSubmit(String xpath,WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath(xpath)).click();
		Thread.sleep(2000);
	}
	
	public void pressTABKey(String xpath,WebDriver driver) throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath(xpath));
		ele.sendKeys(Keys.TAB);
		Thread.sleep(500);
	}
	
	public void pressKey(WebElement element,WebDriver driver, Keys key) {
		Actions action=new Actions(driver);
		action.moveToElement(element).sendKeys(key).build().perform();
	}
	
	public static void scrollElementIntoView(String xpath,ExtentTest childTestSite,WebDriver driver) throws InterruptedException, IOException
	{
		WebElement element = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000); 
		//childTestSite.log(Status.PASS,"Scrolled Element into View ",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotUsingAshot(reportPath+timeCapture()+"_"+"scroll.png",driver)).build());
	//	childTestSite.log(Status.PASS,"Clicking on "+element+": "+"********",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64(reportPath+timeCapture()+"_"+"scrollele.png",driver)).build());
		
	}
	public static void clickElementUsingJavaScript(String xpath,String elementName,ExtentTest childTestSite,WebDriver driver) throws InterruptedException, IOException
	{
		List<WebElement> elements=driver.findElements(By.xpath(xpath));
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir")+"/LocaleValue.properties"));
		String Localename=prop.getProperty("LocaleName");
		System.out.println("Locale name from the Property File="+Localename);
		
		if(Localename.equals("CZ") || Localename.equals("RO") || Localename.equals("SK")) {
			
				List<WebElement> CZClass=driver.findElements(By.xpath("//div[@class='container responsivegrid header-container-cover open-overlay aem-GridColumn aem-GridColumn--default--12']"));
				 if(CZClass.size()>0)
			   {
					 ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName(\"container responsivegrid header-container-cover open-overlay aem-GridColumn aem-GridColumn--default--12\")[0].style.position='absolute';");
			   }
		}
	     if(elements.size()>0)
	     {
	    	 
	    	 if(elements.get(0).isDisplayed())
	    	 {

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elements.get(0));
		Thread.sleep(8000); 
		childTestSite.log(Status.PASS,"Clicking on "+elementName,MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64(reportPath+timeCapture()+"_"+"sendText.png",driver)).build());

		//childTestSite.log(Status.PASS,"Clicking on "+elementName,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotUsingAshot(reportPath+timeCapture()+"_"+"click.png",driver)).build());
	    	 }
	     }
	    	 }
	    	 
	public static void clickElementUsingJavaScript1(String xpath,String elementName,ExtentTest childTestSite,WebDriver driver) throws InterruptedException, IOException
	{
		List<WebElement> elements=driver.findElements(By.xpath(xpath));
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir")+"/LocaleValue.properties"));
		String Localename=prop.getProperty("LocaleName");
		System.out.println("Locale name from the Property File="+Localename);
		
		if(Localename.equals("CZ") || Localename.equals("RO") || Localename.equals("SK")) {
			
				List<WebElement> CZClass=driver.findElements(By.xpath("//div[@class='container responsivegrid header-container-cover open-overlay aem-GridColumn aem-GridColumn--default--12']"));
				 if(CZClass.size()>0)
			   {
					 ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName(\"container responsivegrid header-container-cover open-overlay aem-GridColumn aem-GridColumn--default--12\")[0].style.position='absolute';");
			   }
		}
	     if(elements.size()>0)
	     {
	    	 
	    	 if(elements.get(0).isDisplayed())
	    	 {

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elements.get(0));
		Thread.sleep(8000); 
		childTestSite.log(Status.PASS,"Clicking on "+elementName);
	//	childTestSite.log(Status.PASS,"Clicking on "+elementName+": "+"********",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotAsBase64(reportPath+timeCapture()+"_"+"sendText.png",driver)).build());

		//childTestSite.log(Status.PASS,"Clicking on "+elementName,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotUsingAshot(reportPath+timeCapture()+"_"+"click.png",driver)).build());
	    	 }
	     }
	    	 }
	
	
	
	
	
	
	
	
	public static void waitForElementToBePresent(String xpath,WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(xpath));
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
	
	public  boolean handleStaleElement(String Locator,WebDriver driver) {
	    boolean result = false;
	    int attempts = 0;
	    while(attempts < 10) {
	        try {
	        	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));			
				WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locator)));
	        	element.click();
	            result = true;
	            break;
	        } catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    return result;
	}
	
	public static void clickOnElementStaleEle(String xpath, String elementName, ExtentTest childTestSite, WebDriver driver) throws InterruptedException {
	    boolean clicked = false;
	    while (!clicked) {
	        try {
	            List<WebElement> elements = driver.findElements(By.xpath(xpath));
	            if (elements.size() > 0) {
	                if (elements.get(0).isDisplayed()) {
	                    elements.get(0).click();
	                    Thread.sleep(2000);
	                    //childTestSite.log(Status.PASS, "Clicking on " + elementName, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotUsingAshot(reportPath + timeCapture() + "_" + "click.png", driver)).build());
	                    clicked = true;
	                }
	            }
	        } catch (StaleElementReferenceException e) {
	            // Handle the stale element exception by retrying
	            System.out.println("Stale Element Reference Exception, retrying...");
	            Thread.sleep(1000); // You can adjust the sleep duration as needed
	        }
	    }
	}

	

public static void clickOnElement12(String xpath,String elementName,ExtentTest childTestSite,WebDriver driver) throws InterruptedException, IOException
{   
	System.out.println(xpath);
	List<WebElement> elements=driver.findElements(By.xpath(xpath));

     if(elements.size()>0)
     {
    	
    	 if(elements.get(0).isDisplayed())
    	 {
    		 elements.get(0).click();
    		 Thread.sleep(2000);
    		 //childTestSite.log(Status.PASS,"Clicking on "+elementName,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotUsingAshot(reportPath+timeCapture()+"_"+"click.png",driver)).build());
    		 
    	 }    
	
     }
}
public static void clickOnElement(String xpath,String elementName,ExtentTest childTestSite,WebDriver driver) throws InterruptedException, IOException
{   
	System.out.println(xpath);
	List<WebElement> elements=driver.findElements(By.xpath(xpath));

     if(elements.size()>0)
     {
    	 childTestSite.log(Status.PASS, "Clicking on "+elementName);
    	 if(elements.get(0).isDisplayed())
    	 {
    		 elements.get(0).click();
    		 Thread.sleep(2000);
    		 System.out.println("Before Extent Method");
    		 childTestSite.log(Status.PASS, "Clicking on "+elementName);
    		 System.out.println("After Extent Method");
    		 childTestSite.log(Status.PASS,"All fields are Entered ",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotUsingAshotForBase64(reportPath+timeCapture()+"_"+"TextBoxFilled.png",driver)).build());
    		 
    	 }    
	
     }
}

public static void clickOnElement1(String xpath,String elementName,ExtentTest childTestSite,WebDriver driver) throws InterruptedException, IOException
{   
	System.out.println(xpath);
	List<WebElement> elements=driver.findElements(By.xpath(xpath));

     if(elements.size()>0)
     {
    	
    	 if(elements.get(0).isDisplayed())
    	 {
    		 elements.get(0).click();
    		 Thread.sleep(2000);
    		 childTestSite.log(Status.PASS,"Clicking on "+elementName,MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotUsingAshotForBase64(reportPath+timeCapture()+"_"+"click.png",driver)).build());
    		 
    	 }    
	
     }
}
public static void GetTextValue(String xpath,String elementName,ExtentTest childTestSite,WebDriver driver) throws InterruptedException, IOException
{   
	System.out.println(xpath);
	List<WebElement> elements=driver.findElements(By.xpath(xpath));

     if(elements.size()>0)
     {
    	
    	 if(elements.get(0).isDisplayed())
    	 {
    		 elements.get(0).getText();
    		 Thread.sleep(2000);
    			//childTestSite.log(Status.PASS,"Clicking on "+elementName,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotUsingAshot(reportPath+timeCapture()+"_"+"click.png",driver)).build());
    		 
    	 }    
	
     }
}
public void clearTextField(String xpath,String elementName,ExtentTest childTestSite,WebDriver driver) throws InterruptedException, IOException
{   
	List<WebElement> elements=driver.findElements(By.xpath(xpath));

     if(elements.size()>0)
     {
    	
    	 if(elements.get(0).isDisplayed())
    	 {
    		 elements.get(0).clear();
    		 Thread.sleep(2000);
    			childTestSite.log(Status.PASS,"Clearing "+elementName,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotUsingAshot(reportPath+timeCapture()+"_"+"click.png",driver)).build());
    	 }    
	
     }
}
public String getText(String xpath,WebDriver driver) throws InterruptedException, IOException
{

	return driver.findElement(By.xpath(xpath)).getText();
}

public String getAttributeValue(String xpath,WebDriver driver) throws InterruptedException, IOException
{

	return driver.findElement(By.xpath(xpath)).getAttribute("Value");
}
	


public void sendTextToFiled(String xpath,String text,String elementName,ExtentTest childTestSite,WebDriver driver) throws InterruptedException, IOException
{
	System.out.println("Element Name ="+elementName);
	List<WebElement> isDisplayed=driver.findElements(By.xpath(xpath));
	
	if(isDisplayed.size()>0)
	{
		driver.findElement(By.xpath(xpath)).sendKeys(text);
		childTestSite.log(Status.PASS,"All fields are Entered ",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotUsingAshotForBase64(reportPath+timeCapture()+"_"+"All Fields are Filled.png",driver)).build());
	}
}
public void sendTextToFiled1(String xpath,String text,String elementName,ExtentTest childTestSite,WebDriver driver) throws InterruptedException, IOException
{
	System.out.println("Element Name ="+elementName);
	List<WebElement> isDisplayed=driver.findElements(By.xpath(xpath));
	
	if(isDisplayed.size()>0)
	{
		driver.findElement(By.xpath(xpath)).sendKeys(text);
		childTestSite.log(Status.PASS,"Entering the  text in "+elementName+": "+text);
			//Thread.sleep(7000);
	}
}

public void sendTextToFiled2(String xpath,String text,String elementName,ExtentTest childTestSite,WebDriver driver) throws InterruptedException, IOException
{
	System.out.println("Element Name ="+elementName);
	List<WebElement> isDisplayed=driver.findElements(By.xpath(xpath));
	Properties prop = new Properties();
	prop.load(new FileInputStream(System.getProperty("user.dir")+"/LocaleValue.properties"));
	String Localename=prop.getProperty("LocaleName");
	
	System.out.println("Locale name from the Property File="+Localename);
	
	if(Localename.equals("CZ") || Localename.equals("RO") || Localename.equals("SK")) {
		
			List<WebElement> CZClass=driver.findElements(By.xpath("//div[@class='container responsivegrid header-container-cover open-overlay aem-GridColumn aem-GridColumn--default--12']"));
			 if(CZClass.size()>0)
		   {
				 ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName(\"container responsivegrid header-container-cover open-overlay aem-GridColumn aem-GridColumn--default--12\")[0].style.position='absolute';");
		   }
	}
	if(isDisplayed.size()>0)
	{
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	
		if(elementName.contains("Password"))
		{
			childTestSite.log(Status.PASS,"All fields are Entered ",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotUsingAshotForBase64(reportPath+timeCapture()+"_"+"All Fields are Filled.png",driver)).build());
			//childTestSite.log(Status.PASS,"Entering the  text in "+elementName+": "+"********",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotUsingAshot(reportPath+timeCapture()+"_"+"sendText.png",driver)).build());

		}
		else
		{
		childTestSite.log(Status.PASS,"All fields are Entered ",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotUsingAshotForBase64(reportPath+timeCapture()+"_"+"All Fields are Filled.png",driver)).build());
		}
		//Thread.sleep(7000);
	}
}

public void selectValueFromDropdown(String xpath,String text,String elementName,ExtentTest childTestSite, WebDriver driver) throws InterruptedException, IOException
{
	System.out.println("xpath: "+xpath);
	System.out.println("value: "+text);
	
	List<WebElement> isDisplayed=driver.findElements(By.xpath(xpath));
	if(isDisplayed.size()>0)
	{
		
	     Select select=new Select(driver.findElement(By.xpath(xpath)));
	     Thread.sleep(1000);
	     select.selectByVisibleText(text);
	     childTestSite.log(Status.PASS,"Selecting the value from "+elementName+" : "+text,MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotUsingAshotForBase64(reportPath+timeCapture()+"_"+"selctValueFromDropdown.png",driver)).build());
	     
	     }	 
}

public void selectValueFromDropdown1(String xpath,String text,String elementName,ExtentTest childTestSite, WebDriver driver) throws InterruptedException, IOException
{
	System.out.println("xpath: "+xpath);
	System.out.println("value: "+text);
	Properties prop = new Properties();
	prop.load(new FileInputStream(System.getProperty("user.dir")+"/LocaleValue.properties"));
	String Localename=prop.getProperty("LocaleName");
	System.out.println("Locale name from the Property File="+Localename);
	
	if(Localename.equals("CZ") || Localename.equals("RO") || Localename.equals("SK")) {		
			List<WebElement> CZClass=driver.findElements(By.xpath("//div[@class='container responsivegrid header-container-cover open-overlay aem-GridColumn aem-GridColumn--default--12']"));
			 if(CZClass.size()>0)
		   {
				 ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName(\"container responsivegrid header-container-cover open-overlay aem-GridColumn aem-GridColumn--default--12\")[0].style.position='absolute';");
		   }
	}
	List<WebElement> isDisplayed=driver.findElements(By.xpath(xpath));
	if(isDisplayed.size()>0)
	{
		
	     Select select=new Select(driver.findElement(By.xpath(xpath)));
	     Thread.sleep(1000);
	     select.selectByVisibleText(text);
	     childTestSite.log(Status.PASS,"Selecting the value from "+elementName+" : "+text);
	     
	     }	 
}

public void selectValueFromDropdown12(String xpath,String text,String elementName,ExtentTest childTestSite, WebDriver driver) throws InterruptedException, IOException
{
	System.out.println("xpath: "+xpath);
	System.out.println("value: "+text);
	Properties prop = new Properties();
	prop.load(new FileInputStream(System.getProperty("user.dir")+"/LocaleValue.properties"));
	String Localename=prop.getProperty("LocaleName");
	System.out.println("Locale name from the Property File="+Localename);
	
	if(Localename.equals("CZ") || Localename.equals("RO") || Localename.equals("SK")) {		
			List<WebElement> CZClass=driver.findElements(By.xpath("//div[@class='container responsivegrid header-container-cover open-overlay aem-GridColumn aem-GridColumn--default--12']"));
			 if(CZClass.size()>0)
		   {
				 ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName(\"container responsivegrid header-container-cover open-overlay aem-GridColumn aem-GridColumn--default--12\")[0].style.position='absolute';");
		   }
	}
	List<WebElement> isDisplayed=driver.findElements(By.xpath(xpath));
	if(isDisplayed.size()>0)
	{
		
	     Select select=new Select(driver.findElement(By.xpath(xpath)));
	     Thread.sleep(1000);
	     select.selectByVisibleText(text);
	     childTestSite.log(Status.PASS,"All Required Values are Filled in Registration Second page",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotUsingAshotForBase64(reportPath+timeCapture()+"_"+"Reg Second Page.png",driver)).build());
	     
	     }	 
}
public void selectValueFromDropdown13(String xpath,String text,String elementName,ExtentTest childTestSite, WebDriver driver) throws InterruptedException, IOException
{
	System.out.println("xpath: "+xpath);
	System.out.println("value: "+text);
	Properties prop = new Properties();
	prop.load(new FileInputStream(System.getProperty("user.dir")+"/LocaleValue.properties"));
	String Localename=prop.getProperty("LocaleName");
	System.out.println("Locale name from the Property File="+Localename);
	
	if(Localename.equals("CZ") || Localename.equals("RO") || Localename.equals("SK")) {		
			List<WebElement> CZClass=driver.findElements(By.xpath("//div[@class='container responsivegrid header-container-cover open-overlay aem-GridColumn aem-GridColumn--default--12']"));
			 if(CZClass.size()>0)
		   {
				 ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName(\"container responsivegrid header-container-cover open-overlay aem-GridColumn aem-GridColumn--default--12\")[0].style.position='absolute';");
		   }
	}
	List<WebElement> isDisplayed=driver.findElements(By.xpath(xpath));
	if(isDisplayed.size()>0)
	{
		
	     Select select=new Select(driver.findElement(By.xpath(xpath)));
	     Thread.sleep(1000);
	     select.selectByVisibleText(text);
	     childTestSite.log(Status.PASS,"All Required Values are Filled in Registration First page",MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshotUsingAshotForBase64(reportPath+timeCapture()+"_"+"RegFirstPage.png",driver)).build());
	     
	     }	 
}



public void waitForWindowToBeOpened(WebDriver driver) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));			
	wait.until(ExpectedConditions.numberOfWindowsToBe(3));
	
	ArrayList<String> handles=new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(handles.get(3));
}

public void switchToWindowByIndex(WebDriver driver, int index) {
    Set<String> windowHandles = driver.getWindowHandles();
    ArrayList<String> handles = new ArrayList<String>(windowHandles);
    System.out.println("Number of windows"+handles.size());
    
    // Check if the provided index is valid
    if (index >= 0 && index < handles.size()) {
        driver.switchTo().window(handles.get(index));
    } else {
        throw new IllegalArgumentException("Invalid window index: " + index);
    }
}
public void waitForWindowToBeOpened2(WebDriver driver) {
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));			
	wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	
	ArrayList<String> handles=new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(handles.get(2));
	
	
}
public void switchToWindowIndex(int index) {
    WebDriver driver = null;
	Set<String> windowHandles = driver.getWindowHandles();
    List<String> windowStrings = new ArrayList<String>(windowHandles);
    String reqWindow = windowStrings.get(2);
    driver.switchTo().window(reqWindow);
    System.out.println("Switched to " + driver.getTitle());
}


public static String timeCapture() {
	String fileSuffix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	return fileSuffix;
}

public static  String takeScreenshotUsingAshot(String imagePath,WebDriver driver) throws IOException
{
	Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
	
	ImageIO.write(screenshot.getImage(),"PNG",new File(imagePath));
	
	return imagePath.replace(reportPath, "");
}

public void compare_Front_End_Data_With_CIAM_And_CRM_Data(String frontData,String ciamData,String crmData,ExtentTest childTestSite) throws Exception
{
	
	if(frontData.equalsIgnoreCase(ciamData)&&frontData.equalsIgnoreCase(crmData))
	{
		
		childTestSite.log(Status.INFO, "Frontend Data: "+frontData);
		childTestSite.log(Status.INFO, "CIAM Data: "+ciamData);
		childTestSite.log(Status.INFO, "CRM Data: "+crmData);
		
		childTestSite.log(Status.PASS, "Data is matched");
		
		
		
	}else
	{

		childTestSite.log(Status.INFO, "Frontend Data: "+frontData);
		childTestSite.log(Status.INFO, "CIAM Data: "+ciamData);
		childTestSite.log(Status.INFO, "CRM Data: "+crmData);
		childTestSite.log(Status.FAIL, "Data is not matched");
		throw new Exception("Front End data is not matched with CIAM or CRM data");
	}
}


/*public String takeScreenshotAsBase64(String desFile,WebDriver driver) throws IOException
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
}*/

public static String takeScreenshotAsBase64(String desFile, WebDriver driver) throws IOException {
	   File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	   String encodedBase64 = null;
	   FileInputStream fileInputStreamReader = null;

	   try {
	       fileInputStreamReader = new FileInputStream(sourceFile);
	       byte[] bytes = new byte[(int) sourceFile.length()];
	       fileInputStreamReader.read(bytes);
	       encodedBase64 = new String(Base64.encodeBase64(bytes));

	       FileUtils.copyFile(sourceFile, new File(desFile));
	   } finally {
	       if (fileInputStreamReader != null) {
	           fileInputStreamReader.close();
	       }
	   }

	   return "data:image/png;base64," + encodedBase64;
	}


public static  String takeScreenshotUsingAshotForBase64(String desFile,WebDriver driver) throws IOException
{
	Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
	ImageIO.write(screenshot.getImage(),"PNG",new File(desFile));
	
	File sourceFile = new File(desFile);
	String encodedBase64 = null;
	FileInputStream fileInputStreamReader = null;

	fileInputStreamReader = new FileInputStream(sourceFile);
	byte[] bytes = new byte[(int)sourceFile.length()];
	fileInputStreamReader.read(bytes);
	encodedBase64 = new String(Base64.encodeBase64(bytes));

	//FileUtils.copyFile(sourceFile,new File(desFile));

	fileInputStreamReader.close();

	return "data:image/png;base64,"+encodedBase64;
	
}

public static void switchLatestWindow(WebDriver driver, String Parent_Content) throws IOException, InterruptedException {
	
	for (String windowHandle : driver.getWindowHandles()) {
	    if(!Parent_Content.contentEquals(windowHandle)) {
	        driver.switchTo().window(windowHandle);
	        break;
	        }
	}
}
	
public static void waitTillElementVisisble(WebDriver driver,String locator) {
		
	System.out.println("Inside the wait method Before webdriverwait");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
	wait.pollingEvery(Duration.ofMillis(250));
	wait.ignoring(NoSuchElementException.class);
	//driver.navigate().refresh();
	System.out.println("Locator value inside wait="+locator);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	System.out.println("Inside the wait method After webdriverwait");

}
public static void waitTillElementVisisble1(WebDriver driver,String locator) {
	
	System.out.println("Inside the wait method Before webdriverwait");
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3000));
	WebElement a = driver.findElement(By.xpath(locator));
	System.out.println("Locator value inside wait="+locator);
	wait1.until(ExpectedConditions.elementToBeClickable(a));
	System.out.println("Inside the wait method After webdriverwait");

}

public static void waitAndRefreshTillElementVisisble(WebDriver driver,final String locator) {
	
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(Duration.ofMinutes(300))
		       .pollingEvery(Duration.ofSeconds(30))
		       .ignoring(NoSuchElementException.class);
		//.ignoring(StaleElementReferenceException.class);

		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		     driver.navigate().refresh();
		     return driver.findElement(By.xpath(locator));
		     }
		   });
		   foo.click();
	}


public void GetAutovalidstatus(String crmData,String ciamData,ExtentTest childTestSite) throws Exception
{
	
	if(crmData.equalsIgnoreCase("Active")&&ciamData.equalsIgnoreCase("Valid"))
	{
		childTestSite.log(Status.INFO, "CRM Data: "+crmData);
		childTestSite.log(Status.INFO, "CIAM Data: "+ciamData);
		childTestSite.log(Status.PASS, "Data is matched");
		
	}else
	{

		
		childTestSite.log(Status.INFO, "CRM Data: "+crmData);
		childTestSite.log(Status.INFO, "CIAM Data: "+ciamData);
		childTestSite.log(Status.FAIL, "Data is not matched");
		throw new Exception("Data is not matched with CIAM or CRM data");
	}
}



public void GetNewUserRegistrationstatus(String crmData,String ciamData,ExtentTest childTestSite) throws Exception
{
	
	if(crmData.equalsIgnoreCase("New")&&ciamData.equalsIgnoreCase("Pending"))
	{
		childTestSite.log(Status.INFO, "CRM Data: "+crmData);
		childTestSite.log(Status.INFO, "CIAM Data: "+ciamData);
		childTestSite.log(Status.PASS, "Data is matched");
		
	}else
	{

		
		childTestSite.log(Status.INFO, "CRM Data: "+crmData);
		childTestSite.log(Status.INFO, "CIAM Data: "+ciamData);
		childTestSite.log(Status.FAIL, "Data is not matched");
		throw new Exception("Data is not matched with CIAM or CRM data");
	}
}

public void Get_MCC_Status(String crmData,String ciamData,ExtentTest childTestSite)throws Exception
{
	if(crmData.equalsIgnoreCase("Opt In")&&ciamData.equalsIgnoreCase(ciamData))
	{
		childTestSite.log(Status.INFO, "CRM Data: "+crmData);
		childTestSite.log(Status.INFO, "CIAM Data: "+ciamData);
		childTestSite.log(Status.PASS, "Data is matched");
		
	}else
	{
		
		childTestSite.log(Status.INFO, "CRM Data: "+crmData);
		childTestSite.log(Status.INFO, "CIAM Data: "+ciamData);
		childTestSite.log(Status.FAIL, "Data is not matched");
		throw new Exception("Data is not matched with CIAM or CRM data");
	}
}


public void GetWarningMessage(String crmData, ExtentTest childTestSite)throws Exception {	
	
	String[] warningmsg = crmData.split(":");
	
	System.out.println(warningmsg[1]);
	
	if(warningmsg[1].trim().equalsIgnoreCase("Only New Registration request can be Rejected"))
	{
		childTestSite.log(Status.INFO, "CRM Data: "+crmData);
		childTestSite.log(Status.PASS, "Data is matched");
	}else
	{
		
		childTestSite.log(Status.INFO, "CRM Data: "+crmData);
		childTestSite.log(Status.FAIL, "Data is not matched");
		throw new Exception("Data is not matched with CIAM or CRM data");
	}
	
 }

public void backtomail(WebDriver driver,String xpaths,ExtentTest childTestSite)throws Exception {
	driver.navigate().refresh();
	Thread.sleep(5000);
	
	List<WebElement> Backtomail=driver.findElements(By.xpath(xpaths));
	List<WebElement> Closeads=driver.findElements(By.xpath("//div[@aria-label='Close ad']"));
	if(Backtomail.size()==1) {

		waitTillElementVisisble(driver,xpaths);
	    scrollElementIntoView(xpaths, childTestSite,driver);
		clickOnElement(xpaths,"Back to Mail",childTestSite, driver);
	}
	else if(Closeads.size()==1){		
		
		driver.findElement(By.xpath("//div[@aria-label='Close ad']")).click();
		
		}
	else if(Backtomail.size()==0) {
		driver.navigate().refresh();
	}
	else{		
		driver.navigate().back();	
	}
	
}
}
