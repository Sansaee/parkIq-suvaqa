package parkIQ.pageObjects;

//import org.openqa.selenium.By;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

			//Form Title: Assign Customers to User Profile
			@FindBy(xpath="//div[contains(text(),'Assign Customers to User Profile')]")
			@CacheLookup
			WebElement formTitle ;

			//Form Description: Selecting a customer ...
			@FindBy(xpath="//div[contains(text(),'Selecting a customer determines what machine data ')]")
			@CacheLookup
			WebElement formDescription;
			
			@FindBy(xpath="//div[contains(text(),'Customer Name')]")
			@CacheLookup
			WebElement colCustomerName;
			
			@FindBy(xpath="//div[contains(text(),'Machine Access')]")
			@CacheLookup
			WebElement colMachineAccess;
			
			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[3]/mat-checkbox[1]/label[1]/div[1]")
			@CacheLookup
			WebElement checkboxCusName;
			
			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[6]/div[1]/input[1]")
			@CacheLookup
			WebElement btnBack;
			
			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[6]/div[2]/input[1]")
			@CacheLookup
			WebElement btnCancel;
			
			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[6]/div[2]/input[2]")
			@CacheLookup
			WebElement btnContinue;

			@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[5]")
			@CacheLookup
			WebElement checkboxContainer;



//	@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[5]/div[2]/div[1]/mat-checkbox[1]/label[1]/div[1]")
//	@CacheLookup
//	WebElement chkBoxComp;
//
//	@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[5]/div[5]/div[1]/mat-checkbox[1]/label[1]/div[1]")
//	@CacheLookup
//	WebElement chkABC;


		
			WebElementFunctions func = new WebElementFunctions();

			//Verify "Form Title" is Displayed
			public boolean verifyFormTitle()
			{
				return func.verifyElementDisplayedWithText(formTitle, "Assign Customers to User Profile");
			}

			//Verify "Form Description" is Displayed
			public boolean verifyFormDescription()
			{
				return func.verifyElementDisplayedWithText(formDescription, "Selecting a customer determines what machine data this user will have visibility to. All machines that belong to a customer are selected by default. You can expand the Customer name to select specific machines.");
			}

			//Verify Column Headers: "Customer Name" & "Machine Access" is displayed
			public boolean locateColumnHeaders()
			{
				if(colCustomerName.isDisplayed() && colMachineAccess.isDisplayed())
				{
					return true;
				}
				else
				{
					return false;
				}

			}

			//Verify Checkbox "Customer Name" is displayed
			public boolean locateCheckBox()
			{
				return checkboxCusName.isDisplayed();
			}

			//Click Checkbox
			public void clickCheckBox()
			{
				func.isCheckBoxClickable(ldriver, "//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[5]/div[2]/div[1]/mat-checkbox[1]");
				 checkboxCusName.click();
			}


			public int isChecked()
			{
				return func.isChecked(ldriver, "//mat-checkbox//input[@type='checkbox']");
			}

			//Verify Back Button is Displayed and Clickable
			public boolean btnBackClickableDisplayed()
			{
				return func.verifyElementIsClickable(btnBack, ldriver);
			}

			//Click Back Button
			public void clickBackBtn()
			{
				JavascriptExecutor js = (JavascriptExecutor)ldriver;
				js.executeScript("arguments[0].click()", btnBack);;
			}

			//Verify Cancel Button is Displayed and Clickable
			public boolean btnCancelClickableDisplayed()
			{
				return func.verifyElementIsClickable(btnCancel, ldriver);
			}

			//Click Cancel Button
			public void clickCancelBtn()
			{
				JavascriptExecutor js = (JavascriptExecutor)ldriver;
				js.executeScript("arguments[0].click()", btnCancel);
			}

			//Continue Button is Clickable
			public boolean btnContClickableDisplayed()
			{
				return func.verifyElementIsClickable(btnContinue, ldriver);
			}

			//Continue Button is Displayed
			public boolean btnContDisplayed()
			{
				return btnContinue.isDisplayed();
			}

			public void clickContinueBtn()
	{
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click()", btnContinue);
	}

			public String btnContinueBgColour()
			{
				String bgColour = Color.fromString(btnContinue.getCssValue("background-color")).asHex();
				return bgColour;
			}
			
}
