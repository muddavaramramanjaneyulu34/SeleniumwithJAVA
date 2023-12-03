package ReuseComp.TestUtils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Launching_WebSite {
	
	public static String Flipkart_URL = "https://www.flipkart.com/";
		public static String amazon_URL="https://www.amazon.in/";
		public static String Petstore_URL="https://petstore.octoperf.com";
	
	
	public static void launchSiteFromLocalBrowser(WebDriver driver) {
	//public static void main(String[] args) {
		
		driver = new ChromeDriver();
		System.out.println("URL is: "+Petstore_URL);
		
		driver.get(Petstore_URL);
		driver.manage().window().maximize();
		System.out.println("After hitting the URL");
	}
	
	/* public static void launchSiteFromBrowserstack(WebDriver driver) throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");
		caps.merge(options);
		options.addArguments("incognito");  //ChromeOptions for starting chrome in incognito mode
		options.addArguments("--disable-extensions");
	    options.addArguments("--disable-popup-blocking");
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "119");
		caps.setCapability("build", "Test-Network-Blocking-URL-"+"APAC"+"-"+"TH");
		caps.setCapability("name", "Test-Network-Blocking-URL-"+"APAC"+"-"+"TH");
		caps.setCapability("browserstack.local", "false");
		caps.setCapability("browserstack.selenium_version", "4.15.0");
		caps.setCapability("browserstack.telemetryLogs", "true");
		caps.setCapability("browserstack.local", "true");
		caps.setCapability("browserstack.networkLogs", true);
		caps.setCapability("browserstack.localIdentifier", "automation");
		caps.setCapability("browserstack.seleniumCdp", true);

		driver = new RemoteWebDriver(new URL("http://aswqaautomation_29VmaE:Gu1R2uvYasQH9pycamAE@hub-cloud.browserstack.com/wd/hub"), caps);
		driver.get(Petstore_URL);
		driver.manage().window().maximize();
	}  */
	
	
	/*public static void launchSiteFromBrowserstack(WebDriver driver) throws MalformedURLException {
		
				DesiredCapabilities capabilities = new DesiredCapabilities();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--ignore-certificate-errors");
				capabilities.merge(options);
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				capabilities.setCapability("browserName", "chrome");
				capabilities.setCapability("browserVersion", "latest");
				capabilities.setCapability("os", "windows");
				capabilities.setCapability("osVersion", "10");
				capabilities.setCapability("resolution","1920x1200");
				capabilities.setCapability("buildName", "APAC");
				capabilities.setCapability("sessionName", "APAC-TH");
				capabilities.setCapability("browserstack.networkLogs", true);
				capabilities.setCapability("browserstack.chrome.arch", "x86");
				capabilities.setCapability("browserstack.wsLocalSupport", "true");
				capabilities.setCapability("browserstack.use_w3c", "false");
				capabilities.setCapability("browserstack.networkLogsOptions", "networkLogsOptions");
				capabilities.setCapability("browserstack.localIdentifier", "automation");
				capabilities.setCapability("browserstack.selenium_version", "3.141.59");
				
				//browserstackOptions.put("networkLogs", "true");
				
				//capabilities.setCapability("browserstack.localIdentifier", "automation");
				//capabilities.setCapability("browserstack:options", browserstackOptions);
			//	capabilities.setCapability("bstack:options", browserstackOptions);

				
				//childTest.log(Status.INFO, "Test running in "+getValueFromTestDataCombinationSheet(row,2)+" "+getValueFromTestDataCombinationSheet(row,3));
				//driver=new RemoteWebDriver(new URL(getValueFromCombinationSheet(sheetName,row,0)), capabilities);
				
				driver=new RemoteWebDriver(new URL("http://aswqaautomation_29VmaE:Gu1R2uvYasQH9pycamAE@hub-cloud.browserstack.com/wd/hub"), capabilities);
				driver.get(Petstore_URL);
				driver.manage().window().maximize();
	
	}   */
	
	public static void launchSiteFromBrowserstack(WebDriver driver) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("browserVersion", "latest");
		capabilities.setCapability("platformName", "Windows");
		capabilities.setCapability("platformVersion", "10");

        // Initialize the RemoteWebDriver using BrowserStack capabilities
        driver = new RemoteWebDriver(new URL("_grid_url"), capabilities);
	}
	}
	
