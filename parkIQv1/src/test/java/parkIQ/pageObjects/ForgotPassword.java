package parkIQ.pageObjects;

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
	
	//action methods		
	public void clickFrgtPaswrd()
		{
			btnfrgtPswrd.click();
		}
	
	public boolean locateTitle()
		{
			if(titleForgotPswrd.isDisplayed() && titleForgotPswrd.getText().equals("Forgot Password"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
	public boolean locateEmailLabel()
		{
			if( emailLabel.isDisplayed() && emailLabel.getText().equals("Email"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	
	public boolean locateEmailField()
		{
			if( enterEmail.isDisplayed() )
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	
	public void setEmail(String email )
		{
			enterEmail.sendKeys(email);
		
		}
		public boolean locateResetBtn()
		{
			if(btnReset.isDisplayed() && btnReset.getText().equals("RESET"))
			{
				return true;
			}
			else
			{
				return false;
			}
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
	
	public boolean locateCancelBtn()
		{
			if(btnCancel.isDisplayed() && btnCancel.getText().equals("CANCEL"))
			{
				return true;
			}
			else
			{
				return false;
			}
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
			if(txtBecomeMember.isDisplayed() && txtBecomeMember.getText().equals("Become a Member?"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	
	public boolean locateSignUpText()
		{
			if(txtSignUp.isDisplayed() && txtSignUp.getText().equals("Sign Up Here"))
			{
				return true;
			}
			else
			{
				return false;
			}
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

	public String errorValidation() 
		{
			String message = enterEmail.getText();
			return message;
		}


		
	
}
