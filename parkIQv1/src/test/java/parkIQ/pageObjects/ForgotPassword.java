package parkIQ.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
	
	WebDriver ldriver; //webdriver variable
	
	//constructor
	public ForgotPassword(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//a[@class='forgot-password']")
	@CacheLookup
	WebElement btnfrgtPswrd;
	
	@FindBy(xpath="//input[@id='Email']")
	@CacheLookup
	WebElement enterEmail;
	
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement btnReset;
	
	@FindBy(xpath="//button[@type='button']")
	@CacheLookup
	WebElement btnCancel;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up Here')]")
	@CacheLookup
	WebElement btnSignUp;
	
	
	//action methods
	
	public void clickFrgtPaswrd()
	{
		btnfrgtPswrd.click();
	}
	
	public void setEmail(String email )
	{
		enterEmail.sendKeys(email);
	}

	public void clickReset()
	{
		btnReset.click();
	}

	public void clickCancel()
	{
		btnCancel.click();
	}
	
	public void clickNewMemberSignUp()
	{
		btnSignUp.click();
	}



		
	
}
