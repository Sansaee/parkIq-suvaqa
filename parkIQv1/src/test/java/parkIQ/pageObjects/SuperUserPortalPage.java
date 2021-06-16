package parkIQ.pageObjects;

//import org.openqa.selenium.By;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import parkIQ.common.WebElementFunctions;

public class SuperUserPortalPage {

	WebDriver ldriver;

	public SuperUserPortalPage(WebDriver rdriver) //a constructor; ldiver = local driver, rdriver = remote driver
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	//Page Title
	@FindBy(xpath="//a[contains(text(),'Create Customer Service User')]")
	@CacheLookup
	WebElement pageTitle ;


	//create new user link
	@FindBy(xpath="//span[@class='card-item-link']")
	@CacheLookup
	WebElement linkCreateNewUser;
	


	//Notification
	@FindBy(xpath="//div[@class='overlay ng-tns-c88-0 ng-trigger ng-trigger-fadeIn ng-star-inserted ng-animating']")
	@CacheLookup
	WebElement overlay;


	WebElementFunctions func = new WebElementFunctions();


	//action methods
	
	//Confirm Title "Create Customer Service User"
	public boolean locateTitle()
	{
		return func.verifyElementDisplayedWithText(pageTitle, "Create Customer Service User");
	}


	public boolean createUserLinkClickable()
	{
		return func.verifyElementIsClickable(linkCreateNewUser, ldriver);
	}

	public void clickCreateUserLink()
	{
		func.waitLoaderDisappear(overlay, ldriver);
		linkCreateNewUser.click();
	}

	
	
}
