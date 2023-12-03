package ReuseComp.BaseTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonObjects {

	
	@FindBy(xpath="//div[@class='cookie-disclaimer__container']")
	public  WebElement cookieLoc;
	
	@FindBy(xpath="//a[@class='cookie-disclaimer__accept js-site-disclaimer-skip button-animated button-animated--square']")
	public  WebElement acceptCookieLoc;
	
	@FindBy(xpath="//div[@class='sm-col-6 md-col-9 lg-col-8 xl-col-8']")
	public  WebElement cookieDescription;
	
	@FindBy(xpath="//button[@class='hcp-disclaimer__button button-animated button-animated--square js-hcp-disclaimer-cta js-site-disclaimer-skip']")
	public  List<WebElement> hcpDisclaimerAcceptBtn;

	@FindBy(xpath="//h4[@class='cookie-disclaimer__headline']")
	public  WebElement cookiHeadline;
	
	@FindBy(xpath="//button[@class='hcp-disclaimer__button button-animated button-animated--square js-hcp-disclaimer-cta js-site-disclaimer-skip hcp-disclaimer__button_forSwap']")
	public  List<WebElement> hcpDisclaimerAcceptBtnSwap;
	
	@FindBy(xpath="//button[@id='details-button']")
    public List<WebElement> advanceclick;
   
    @FindBy(xpath="//a[@id='proceed-link']")
    public WebElement link;
	
	
	//button[@class='hcp-tabbed-disclaimer__button button-animated button-animated--square js-hcp-tabbed-disclaimer-cta js-site-disclaimer-skip']
}
