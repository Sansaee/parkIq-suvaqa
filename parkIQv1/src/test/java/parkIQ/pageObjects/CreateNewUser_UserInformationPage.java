package parkIQ.pageObjects;
import org.openqa.selenium.JavascriptExecutor;
import parkIQ.common.WebElementFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewUser_UserInformationPage {
	
		WebDriver ldriver;

		public CreateNewUser_UserInformationPage(WebDriver rdriver) //a constructor; ldiver = local driver, rdriver = remote driver
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}

			//User Information Page Header
			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[1]/div[1]/div[1]/div[2]")
			@CacheLookup
			WebElement pageHeader ;

			//Create New User Page Title
			@FindBy(xpath="//div[contains(text(),'Create New User')]")
			@CacheLookup
			WebElement pageTitle ;

			//User Information Form Title
			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[1]")
			@CacheLookup
			WebElement formTitle ;

			//First Name Text Field
			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/form[1]/div[2]/div[1]/input[1]")
			@CacheLookup
			WebElement txtFirstName;

			//Last Name Text Field
			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/form[1]/div[2]/div[2]/input[1]")
			@CacheLookup
			WebElement txtLastName;

			//Email Text Field
			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/form[1]/div[3]/input[1]")
			@CacheLookup
			WebElement txtEmail;

			//Email Validation Message
			@FindBy(xpath="//span[contains(text(),'Not a valid email')]")
			@CacheLookup
			WebElement emailValidation;

			//Phone Number Text Field
			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/form[1]/div[5]/input[1]")
			@CacheLookup
			WebElement txtPhoneNumber;

			//Phone Validation Message
			@FindBy(xpath="//span[contains(text(),'Not a valid phone number')]")
			@CacheLookup
			WebElement phoneValidation;

			//Cancel Button
			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/form[1]/div[7]/input[1]")
			@CacheLookup
			WebElement btnCancel;

			//Continue Button
			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/form[1]/div[7]/input[2]")
			@CacheLookup
			WebElement btnContinue;
			

			WebElementFunctions func = new WebElementFunctions();

			//Confirm Header "User Information"
			public boolean verifyHeader()
			{
				return func.verifyElementDisplayedWithText(pageHeader, "User Information");
			}

			//Confirm Page Title "Create New User"
			public boolean verifyPageTitle()
			{
				return func.verifyElementDisplayedWithText(pageTitle, "Create New User");
			}

			//Confirm Form Title "User Information"
			public boolean verifyFormTitle()
			{
				return func.verifyElementDisplayedWithText(formTitle, "User Information");
			}

			//First Name is clickable and displayed
			public boolean firstNameClickable()
			{
				return func.verifyElementIsClickable(txtFirstName, ldriver);
			}

			//Last Name is clickable and displayed
			public boolean lastNameClickable()
			{
				return func.verifyElementIsClickable(txtLastName, ldriver);
			}

			//Email is clickable and displayed
			public boolean emailClickable()
			{
				return func.verifyElementIsClickable(txtEmail, ldriver);
			}

			//Phone is clickable and displayed
			public boolean phoneClickable()
			{
				return func.verifyElementIsClickable(txtPhoneNumber, ldriver);
			}

			//Cancel Button is clickable and displayed
			public boolean btnCancelClickable()
			{
				return func.verifyElementIsClickable(btnCancel, ldriver);
			}

			//Continue Button is clickable
			public boolean btnContinueClickable()
			{
				return func.verifyElementIsClickable(btnContinue, ldriver);
			}

			//Continue Button is displayable
			public boolean btnContinueDisplayed()
			{
				return btnContinue.isDisplayed();
			}

			public String btnContinueBgColour()
			{
				String bgColour = Color.fromString(btnContinue.getCssValue("background-color")).asHex();
				return bgColour;
			}

			//Set First Name
			public void setFirstName(String fName)
			{
				txtFirstName.clear();
				txtFirstName.sendKeys(fName);
			}

			//Set Last Name
			public void setLastName(String lName)
			{
				txtLastName.clear();
				txtLastName.sendKeys(lName);
			}

			//Set Email
			public boolean setEmail(String email)
			{
				txtEmail.clear();
				txtEmail.sendKeys(email);
				boolean validation = func.verifyElementDisplayedWithText(emailValidation, "Not a valid email"); //check if validation message is displayed
				return validation;
			}

			//Set Phone Number
			public boolean setPhoneNumber(String phoneNumber)
			{
				txtPhoneNumber.clear();
				txtPhoneNumber.sendKeys(phoneNumber);
				boolean validation = func.verifyElementDisplayedWithText(phoneValidation, "Not a valid phone number");
				return validation;
			}

			//Click Cancel Button
			public void clickCancel()
			{
				JavascriptExecutor js = (JavascriptExecutor)ldriver;
				js.executeScript("arguments[0].click()", btnCancel);
			}

			//Click Continue Button
			public void clickContinue()
			{
				JavascriptExecutor js = (JavascriptExecutor)ldriver;
				js.executeScript("arguments[0].click()", btnContinue);
			}

}
