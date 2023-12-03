package ReuseComp.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class BaseTest {

	public static String reportPath=System.getProperty("user.dir")+"/Reports/";
	
	
	public static String takeScreenshot(WebDriver driver,String imagePath) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			//System.out.println(System.getProperty("user.dir"));
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"/Reports/"+imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imagePath;
	}
	
	public  static String takeScreenshotUsingAshot(WebDriver driver,String imagePath) throws IOException
	{
		
		//Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		//ImageIO.write(screenshot.getImage(),"PNG",new File(imagePath));
		
		/*File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return imagePath;
	}
	
	/*public  String takeScreenshotReturnPath(WebDriver driver,String imagePath)
	{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return imagePath.replace(reportPath, "");
	}*/
	
	public static int jodaDateDifference(String dateStart,String dateStop) throws ParseException
	{
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy");

		Date d1 = null;
		Date d2 = null;

			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);

			DateTime dt1 = new DateTime(d1);
			DateTime dt2 = new DateTime(d2);
			int days=Days.daysBetween(dt1, dt2).getDays();
			System.out.print(days + " days, ");
			
			//System.out.print(Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hours, ");
			//System.out.print(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " minutes, ");
			//System.out.print(Seconds.secondsBetween(dt1, dt2).getSeconds() % 60 + " seconds.");

		
		
		return days;

	}
	
	public static void moveToTheElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public static void scrollElementIntoView(WebDriver driver,WebElement element) throws InterruptedException
	{
		//WebElement element = driver.findElement(By.id("id_of_element"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000); 
	}
	public static Workbook getWorkbook(FileInputStream inputStream, String excelFilePath)
	        throws IOException {
	    Workbook workbook = null;
	 
	    if (excelFilePath.endsWith("xlsx")) {
	        workbook = new XSSFWorkbook(inputStream);
	    } else if (excelFilePath.endsWith("xls")) {
	        workbook = new HSSFWorkbook(inputStream);
	    } else {
	        throw new IllegalArgumentException("The specified file is not Excel file");
	    }
	 
	    return workbook;
	}
	public static String getValueFromTestDataSheet(int i,int j,String testDataFilePath) throws IOException
	{
		FileInputStream inputStream = new FileInputStream(new File(testDataFilePath));
		 
		Workbook workbook = getWorkbook(inputStream, testDataFilePath);
		//int numberOfSheets = workbook.getNumberOfSheets();
		Sheet sheet = workbook.getSheetAt(0);
		Row row=sheet.getRow(i);
		String cellData=row.getCell(j).toString();
		return cellData;
		
	}
	public static  void takeScreenShotForCompare(WebDriver driver,String imageName,String refScreenShotsPath,String actScreenShotsPath) throws IOException
	{
		String refImagePath=refScreenShotsPath+imageName+"_Ref.png";
		String actImagePath=actScreenShotsPath+imageName+"_Act.png";
		//String compareDiffPath=reportPath+"/"+imageName+"_diff";
		
		if(new File(refImagePath).exists()==false)
		{
			System.out.println("Taking reference screenshot");
			takesScreenshot(driver,refImagePath);
			
		}
		
		takesScreenshot(driver,actImagePath);
		//return IMAGECOMPARE.compareWithBaseImage(new File(refImagePath),new File(actImagePath),compareDiffPath);
	}
	public String encodingBase64(File sourceFile) throws IOException
	{
	//File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String encodedBase64 = null;
	FileInputStream fileInputStreamReader = null;
	
	fileInputStreamReader = new FileInputStream(sourceFile);
	byte[] bytes = new byte[(int)sourceFile.length()];
	fileInputStreamReader.read(bytes);
	encodedBase64 = new String(Base64.encodeBase64(bytes));
	
	//FileUtils.copy(sourceFile,)
	
		
	
	return "data:image/png;base64,"+encodedBase64;
}

	public static void typeTextIntoField(WebElement element, String value)
	{
	    //element.clear();

	    for (int i = 0; i < value.length(); i++){
	        char c = value.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        element.sendKeys(s);
	    }       
	}
	
	public static void takesScreenshot(WebDriver driver,String imagePath)
	{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public static void waitForElementToBePresent(WebDriver driver,WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
public static boolean handleStaleElement(WebDriver driver,WebElement element) {
    boolean result = false;
    int attempts = 0;
    while(attempts < 10) {
        try {
        	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));	
			wait.until(ExpectedConditions.elementToBeClickable(element));
//			Actions action=new Actions(driver);
//			action.moveToElement(element).doubleClick().build().perform();
        	element.click();
            result = true;
            break;
        } catch(StaleElementReferenceException e) {
        }
        attempts++;
    }
    return result;
}
public static void scrollElementIntoView1(WebDriver driver,WebElement element) throws InterruptedException
{
	//WebElement element = driver.findElement(By.id("id_of_element"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	Thread.sleep(500); 
}

public static void clickElementUsingjavaScript(WebElement element,WebDriver driver)
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", element);
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

}

