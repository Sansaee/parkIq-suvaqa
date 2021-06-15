package parkIQ.pageObjects;

//import org.openqa.selenium.By;
import java.util.List;
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
	@FindBy(xpath="//span[contains(text(),'Create New User')]")
	@CacheLookup
	WebElement linkCreateNewUser;
	


	//Notification
	@FindBy(xpath="//body/notifier-container[1]/ul[1]/li[1]/notifier-notification[1]")
	@CacheLookup
	WebElement notification;

	WebElementFunctions func = new WebElementFunctions();

	//Implicit Waut
	public void load()
	{
		func.pageLoad(ldriver);
	}

	//action methods
	
	//Confirm Title "Create Customer Service User"
	public boolean locateTitle()
	{
		return func.verifyElementDisplayedWithText(pageTitle, "Create Customer Service User");
	}

	

	public void clickCreateUserLink()
	{
		boolean isClickable = func.verifyElementIsClickable(linkCreateNewUser, ldriver);
		{
			linkCreateNewUser.click();
		}
	}

	
	
}
