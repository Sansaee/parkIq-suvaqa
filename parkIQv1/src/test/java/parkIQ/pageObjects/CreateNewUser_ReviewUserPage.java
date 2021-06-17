package parkIQ.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import parkIQ.common.WebElementFunctions;

public class CreateNewUser_ReviewUserPage {
	WebDriver ldriver;
	
	public CreateNewUser_ReviewUserPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Review User')]")
	@CacheLookup
	WebElement formTitle;
	
WebElementFunctions func = new WebElementFunctions();
	
	public boolean verifyFormTitle()
	{
		return func.verifyElementDisplayedWithText(formTitle, "Review User");
	}
}

