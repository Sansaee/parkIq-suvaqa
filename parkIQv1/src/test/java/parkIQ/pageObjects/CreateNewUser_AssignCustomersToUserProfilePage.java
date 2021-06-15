package parkIQ.pageObjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import parkIQ.common.WebElementFunctions;

public class CreateNewUser_AssignCustomersToUserProfilePage {
	
	 WebDriver ldriver;


		public CreateNewUser_AssignCustomersToUserProfilePage(WebDriver rdriver) //a constructor; ldiver = local driver, rdriver = remote driver
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}

			//User Information Form Title
			@FindBy(xpath="//div[@class='mx-3 tab-panel-title']")
			@CacheLookup
			WebElement formTitle ;
			
			@FindBy(xpath="//div[@class='mx-3 my-2']")
			@CacheLookup
			WebElement formDescription;
			
			@FindBy(xpath="//div[@class='mx-3']")
			@CacheLookup
			WebElement formColumn1;
			
			@FindBy(xpath="//div[@class='mx-5']")
			@CacheLookup
			WebElement formColumn2;
			
			@FindBy(xpath="//mat-checkbox[@id='mat-checkbox-1']//label[@class='mat-checkbox-layout']//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")
			@CacheLookup
			WebElement checkbox;
			
			@FindBy(xpath="//body[@class='mat-typography']/app-root[@ng-version='9.1.3']/body/div[@class='content']/app-create-user[@class='ng-star-inserted']/div[@class='d-flex flex-row justify-content-center']/mat-card[@class='mat-card mat-focus-indicator add-location-card ng-star-inserted']/div[@class='d-flex flex-row mx-3 justify-content-between']/div[1]/input[1]")
			@CacheLookup
			WebElement btnBack;
			
			@FindBy(xpath="//body[@class='mat-typography']/app-root[@ng-version='9.1.3']/body/div[@class='content']/app-create-user[@class='ng-star-inserted']/div[@class='d-flex flex-row justify-content-center']/mat-card[@class='mat-card mat-focus-indicator add-location-card ng-star-inserted']/div[@class='d-flex flex-row mx-3 justify-content-between']/div[2]/input[1]")
			@CacheLookup
			WebElement btnCancel;
			
			@FindBy(xpath="//body[@class='mat-typography']/app-root[@ng-version='9.1.3']/body/div[@class='content']/app-create-user[@class='ng-star-inserted']/div[@class='d-flex flex-row justify-content-center']/mat-card[@class='mat-card mat-focus-indicator add-location-card ng-star-inserted']/div[@class='d-flex flex-row mx-3 justify-content-between']/div/input[2]")
			@CacheLookup
			WebElement btnContinue;
			
			//First Name Text Field
			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/form[1]/div[2]/input[1]")
			@CacheLookup
			WebElement txtFirstName;

			//Last Name Text Field
			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/form[1]/div[2]/input[2]")
			@CacheLookup
			WebElement txtLastName;

			//Email Text Field
			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/form[1]/div[3]/input[1]")
			@CacheLookup
			WebElement txtEmail;
			
			//Phone Number Text Field
			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/form[1]/div[5]/input[1]")
			@CacheLookup
			WebElement txtPhoneNumber;
			
			//Continue Button
			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/form[1]/div[6]/input[2]")
			@CacheLookup
			WebElement btnContinueCreateNewUser;
		
			WebElementFunctions func = new WebElementFunctions();

			//Wait
			public void load()
			{
				func.pageLoad(ldriver);
			}

			//Confirm Form Title "Assign Customers to User Profile"
			public boolean verifyFormTitle()
			{
				return func.verifyElementDisplayedWithText(formTitle, "Assign Customers to User Profile");
			}

			//Confirm Form Title "User Information"
			public boolean verifyFormDescription()
			{
				return func.verifyElementDisplayedWithText(formDescription, "Selecting a customer determines what machine data this user will have visibility to. All machines that belong to a customer are selected by default. You can expand the Customer name to select specific machines.");
			}
			
			public boolean locateColumnHeaders()
			{
				if(formColumn1.isDisplayed() && formColumn2.isDisplayed())
				{
					return true;
				}
				else
				{
					return false;
				}

			}
			
			public boolean locateCheckBox()
			{
				return checkbox.isDisplayed();
			}
			
			public boolean btnBackClickableDisplayed()
			{
				return func.verifyElementIsClickable(btnBack, ldriver);
			}
			
			public void clickBackBtn()
			{
				 btnBack.click();
			}
			
			public boolean btnCancelClickableDisplayed()
			{
				return func.verifyElementIsClickable(btnCancel, ldriver);
			}
			
			public void clickCancelBtn()
			{
				btnCancel.click();
			}
			
			public boolean btnContClickableDisplayed()
			{
				return func.verifyElementIsClickable(btnContinue, ldriver);
			}
			
			public void clickContBtn2()
			{
				btnCancel.click();
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
			public void setEmail(String email)
			{
				txtLastName.clear();
				txtLastName.sendKeys(email);
			}
			
			public void clickContBtn()
			{
				btnContinueCreateNewUser.click();
			}
			
}
