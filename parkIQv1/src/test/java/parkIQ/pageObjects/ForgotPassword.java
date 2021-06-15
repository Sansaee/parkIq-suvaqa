package parkIQ.pageObjects;
import parkIQ.common.WebElementFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.Color;
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
	
		@FindBy(xpath="//h2[@class='centered']")
		@CacheLookup
		WebElement titleForgotPswrd;
		
		@FindBy(xpath="//label[@class='control-label email']")
		@CacheLookup
		WebElement emailLabel;
		
		
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
		
		@FindBy(xpath="//b[contains(text(),'Become a Member?')]")
		@CacheLookup
		WebElement txtBecomeMember;
		
		@FindBy(xpath="//a[contains(text(),'Sign Up Here')]")
		@CacheLookup
		WebElement txtSignUp;
		
		@FindBy(xpath="//span[contains(text(),'The Email field is not a valid e-mail address.')]")
		@CacheLookup
		WebElement invalidEmailValidation;

		@FindBy(xpath="//span[contains(text(),'No account was found with that email address. Veri')]")
		@CacheLookup
		WebElement emailNotExistValidation;






		
		WebElementFunctions func = new WebElementFunctions();

	
	//action methods		
	public void clickFrgtPaswrd()
		{
			btnfrgtPswrd.click();
		}
	
	public boolean locateTitle()
		{
			return func.verifyElementDisplayedWithText(titleForgotPswrd, "Forgot Password");
		}
		
	public boolean locateEmailLabel()
		{
			return func.verifyElementDisplayedWithText(emailLabel, "Email");
		
		}
	
	public boolean locateEmailField()
		{
			return enterEmail.isDisplayed();
			
		}


	public void setEmail(String email)
	{
		enterEmail.clear();
		enterEmail.sendKeys(email);
	}

	
		public boolean locateResetBtn()
		{
			return func.verifyElementDisplayedWithText(btnReset, "RESET");
		
		}
	
	public String resetBtnColor()
		{
			String colour = Color.fromString(btnReset.getCssValue("color")).asHex();
			return colour;
		}
		
	public String resetBckgrndColor()
		{
			String bckgclr = Color.fromString(btnReset.getCssValue("background-color")).asHex();
			return bckgclr;
		}
	
	public void clickReset()
		{
			btnReset.click();
		}

		//Test whether validation message pops up when invalid email is entered
		public boolean isInvalidEmail()
		{
			boolean isInvalidEmail = func.verifyElementDisplayedWithText(invalidEmailValidation, "The Email field is not a valid e-mail address."); //check if validation message is displayed
			return isInvalidEmail;
		}


		//Test validation message pops up if email entered has yet to be registered
		public boolean isEmailNotExist()
		{
			boolean isEmailNotExist = func.verifyElementDisplayedWithText(emailNotExistValidation, "No account was found with that email address. Verify your email address or click the Register link to create an account");
			return isEmailNotExist;
		}
	
	public boolean locateCancelBtn()
		{
			return func.verifyElementDisplayedWithText(btnCancel, "CANCEL");
		}
	
	public String cancelBtnColor()
		{
			String colour = Color.fromString(btnCancel.getCssValue("color")).asHex();
			return colour;	
		}
	
	public String cancelBckgrndColor()
		{
			String bckgclr = Color.fromString(btnCancel.getCssValue("background-color")).asHex();
			return bckgclr;
		}
	
	public void clickCancel()
		{
			btnCancel.click();
		}
	
	public boolean locateBecomeMembrText()
		{
			return func.verifyElementDisplayedWithText(txtBecomeMember, "Become a Member?");
		}
	
	public boolean locateSignUpText()
		{
		return func.verifyElementDisplayedWithText(txtSignUp, "Sign Up Here");
		}
	
	public String signUpDecoratorBefore()
		{
			String decorator = txtSignUp.getCssValue("text-decoration");
			return decorator;
		}
	
	public String signUpTxtColor()
		{
			String colour = Color.fromString(txtSignUp.getCssValue("color")).asHex();
			return colour;
		}
		
	
	public void clickNewMemberSignUp()
		{
			txtSignUp.click();
		}
}
