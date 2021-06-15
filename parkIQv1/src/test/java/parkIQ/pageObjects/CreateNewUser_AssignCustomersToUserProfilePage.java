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
			WebElement custNameCheckbox;
			
			@FindBy(xpath="//body[@class='mat-typography']/app-root[@ng-version='9.1.3']/body/div[@class='content']/app-create-user[@class='ng-star-inserted']/div[@class='d-flex flex-row justify-content-center']/mat-card[@class='mat-card mat-focus-indicator add-location-card ng-star-inserted']/div[@class='d-flex flex-row mx-3 justify-content-between']/div[1]/input[1]")
			@CacheLookup
			WebElement btnBack;
			
			@FindBy(xpath="//body[@class='mat-typography']/app-root[@ng-version='9.1.3']/body/div[@class='content']/app-create-user[@class='ng-star-inserted']/div[@class='d-flex flex-row justify-content-center']/mat-card[@class='mat-card mat-focus-indicator add-location-card ng-star-inserted']/div[@class='d-flex flex-row mx-3 justify-content-between']/div[2]/input[1]")
			@CacheLookup
			WebElement btnCancel;
			
			@FindBy(xpath="//body[@class='mat-typography']/app-root[@ng-version='9.1.3']/body/div[@class='content']/app-create-user[@class='ng-star-inserted']/div[@class='d-flex flex-row justify-content-center']/mat-card[@class='mat-card mat-focus-indicator add-location-card ng-star-inserted']/div[@class='d-flex flex-row mx-3 justify-content-between']/div/input[2]")
			@CacheLookup
			WebElement btnContinue;
			
			
			
			


			WebElementFunctions func = new WebElementFunctions();



			//Confirm Form Title "User Information"
			public boolean verifyFormTitle()
			{
				return func.verifyElementDisplayedWithText(formTitle, "Assign Customers to User Profile");
			}


}
