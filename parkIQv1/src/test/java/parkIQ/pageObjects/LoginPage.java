package parkIQ.pageObjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import parkIQ.common.WebElementFunctions;

public class LoginPage {
	
	 WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) //a constructor; ldiver = local driver, rdriver = remote driver
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}

		//WebElement txtEmail = ldriver.findElement(By.id("Email"));
		@FindBy(xpath="//input[@id='Email']")
		@CacheLookup
		WebElement txtEmail ;
		
		@FindBy(xpath="//input[@id='Password']")
		@CacheLookup
		WebElement txtPassword ;
		
		@FindBy(xpath="//button[@type='submit']")
		@CacheLookup
		WebElement btnLogin ;
		
		@FindBy(xpath="/html/body/ngb-modal-window/div/div/div[2]/ng-select/div/span")
		@CacheLookup
		WebElement ddListofRoles;
		
		@FindBy(xpath="/html/body/ngb-modal-window/div/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div[3]/span")
		@CacheLookup
		WebElement ddSelectRole;
		
		@FindBy(xpath="/html/body/ngb-modal-window/div/div/div[3]/button")
		@CacheLookup
		WebElement btnSelect;
		
		@FindBy(xpath="/html/body/div/div/div/div/div[1]/div/h2")
		@CacheLookup
		WebElement txtSignIn;
		
		@FindBy(xpath="/html/body/nav/a/img")
		@CacheLookup
		WebElement imgParkIQ;

		//Invalid Login Error Message
		@FindBy(xpath="/html/body/div/div/div/div/div[1]/div/section/form/div[1]/ul/li")
		@CacheLookup
		WebElement txtInvalidLogin;
		
		//Invalid Email 1 Error Message
		@FindBy(xpath="/html/body/div/div/div/div/div[1]/div/section/form/div[1]/ul/li[1]")
		@CacheLookup
		WebElement txtInvalidEmail1;
		
		//Invalid Email 2 Error Message
		@FindBy(xpath="/html/body/div/div/div/div/div[1]/div/section/form/div[2]/div/span/span")
		@CacheLookup
		WebElement txtInvalidEmail2;
		
		//Invalid Password 1 Error Message
		@FindBy(xpath="/html/body/div/div/div/div/div[1]/div/section/form/div[1]/ul")
		@CacheLookup
		WebElement txtInvalidPassword1;
		
		//Invalid Password 2 Error Message
		@FindBy(xpath="/html/body/div/div/div/div/div[1]/div/section/form/div[3]/div/span/span")
		@CacheLookup
		WebElement txtInvalidPassword2;
		
		//Email label
		@FindBy(xpath="/html/body/div/div/div/div/div[1]/div/section/form/div[2]/div/label")
		@CacheLookup
		WebElement lblEmail;
		
		//Forget Password Link Button
		@FindBy(xpath="/html/body/div/div/div/div/div[1]/div/section/form/div[4]/div/div/a")
		@CacheLookup   
		WebElement hrefForgotPassword;
		
		//User Account Icon
		@FindBy(xpath="/html/body/app-root/body/app-nav-menu/nav/div/ul[2]/button/span/div/img")
		@CacheLookup
		WebElement imgAccountIcon;
		
		//Logout Button
		@FindBy(xpath="/html/body/div[2]/div[2]/div/div/div/button[6]")
		@CacheLookup
		WebElement btnLogout;
		
		WebElementFunctions func = new WebElementFunctions();
		
		//Wait
		public void load() { func.pageLoad(ldriver); }
		
		//action methods
		//Enter valid email
		public void setEmail(String uname )
		{
			txtEmail.sendKeys(uname);
		}
		
		//Enter valid password
		public void setPassword(String pwd )
		{
			txtPassword.sendKeys(pwd);
		}
		
		//Display password text
		public String txtPasswordDisplayed() 
		{
			String message = txtPassword.getText();
			return message;
		}
		
		//Login button is clickable
		public void clickSubmit()
		{
			btnLogin.click();
		}
		
		//List of Roles
		public void showRoles() 
		{
			ddListofRoles.click();
		}
		
		//Select Roles for Login
		public void selectRole() 
		{
			ddSelectRole.click();
		}
		
		//Select button is clickable
		public void clickSelect() 
		{
			btnSelect.click();
		}
		
		//Confirm Sign in is displayed 
		public boolean confirmSignIn() 
		{
			if(imgParkIQ.isDisplayed())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		//Confirm Sign in text
		public boolean confirmSignIntxt() 
		{
			return func.verifyElementDisplayedWithText(txtSignIn, "Sign In");
		}
		
		//Confirm Park IQ is displayed
		public boolean confirmParkIQ()
		{
			if(imgParkIQ.isDisplayed())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		//Invalid Login Validation
		public boolean loginValidation() 
		{
			return func.verifyElementDisplayedWithText(txtInvalidLogin, "Invalid login attempt.");
		}
		
		//Invalid Email Error Message 1
		public boolean emailValidation1() 
		{
			return func.verifyElementDisplayedWithText(txtInvalidEmail1, "The Email field is required.");
		}
		
		//Invalid Email Error Message 2
		public boolean emailValidation2() 
		{
			return func.verifyElementDisplayedWithText(txtInvalidEmail2, "The Email field is required.");
		}
		
		//Invalid Password Error Message 1
		public boolean passwordValidation1() 
		{
			return func.verifyElementDisplayedWithText(txtInvalidPassword1, "The Password field is required.");
		}
		
		//Invalid Password Error Message 2
		public boolean passwordValidation2() 
		{
			return func.verifyElementDisplayedWithText(txtInvalidPassword2, "The Password field is required.");
		}
		
		//Email text is viewable
		public boolean emailViewable() 
		{
			return func.verifyElementDisplayedWithText(lblEmail, "EMAIL");
		}
		
		//Email text is clickable
		public boolean emailClickable()
		{
			return func.verifyElementIsClickable(txtEmail, ldriver);
		}
		
		//Password text is viewable
		public boolean passwordViewable()
		{
			return func.verifyElementDisplayedWithText(txtPassword, "PASSWORD");
		}
		
		//Password text is clickable
		public boolean passwordClickable()
		{
			return func.verifyElementIsClickable(txtPassword, ldriver);
		}
		
		//Forgot Password text is viewable
		public boolean forgotpasswordViewable()
		{
			return func.verifyElementDisplayedWithText(hrefForgotPassword, "Forgot your password?");
		}
		
		//Forgot Password text is clickable
		public boolean forgotpasswordClickable()
		{
			return func.verifyElementIsClickable(hrefForgotPassword, ldriver);
		}
		
		//Forgot Password text is underlined
		public String forgotPasswordtxtDecoration()
		{
			String txtDecoration = hrefForgotPassword.getCssValue("text-decoration");
			return txtDecoration;
		}
		
		//Forgot Password text color is displayed 
		public String forgotPasswordtxtColor()
		{
			String txtColor = Color.fromString(hrefForgotPassword.getCssValue("color")).asHex();
			return txtColor;
		}
		
		//User Account Icon is clicked
		public void accountIcon()
		{
			imgAccountIcon.click();
		}
		
		//Login text is displayed
		public boolean txtLoginDisplayed()
		{
			if(btnLogin.isDisplayed())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		//Login text color is displayed
		public String txtLoginColor()
		{
			String txtColor = Color.fromString(btnLogin.getCssValue("color")).asHex();
			return txtColor;
		}
		
		//Login background text color is displayed
		public String txtLoginBackgroundColor()
		{
			String txtLoginBackgroundColor = Color.fromString(btnLogin.getCssValue("color")).asHex();
			return txtLoginBackgroundColor;
		}
		
		public void logIn(String user, String password)
		{
		 txtEmail.sendKeys(user);
		 txtPassword.sendKeys(password);
		 btnLogin.click();
		}
}
