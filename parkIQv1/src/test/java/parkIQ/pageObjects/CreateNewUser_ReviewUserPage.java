package parkIQ.pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.Color;
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

	//Review User Form Title
	@FindBy(xpath="//div[contains(text(),'Review User')]")
	@CacheLookup
	WebElement titleUserReview;

	//Section: User Information
	@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[3]/div[1]/div[1]/div[1]")
	@CacheLookup
	WebElement sectionUserInformation;

	//Field Name Header
	@FindBy(xpath="//div[contains(text(),'Name')]")
	@CacheLookup
	WebElement fieldNameHeader;

	//First Name & Last Name Text
	@FindBy(css="div.content:nth-child(2) app-create-user.ng-star-inserted:nth-child(2) div.d-flex.flex-row.justify-content-center:nth-child(3) mat-card.mat-card.mat-focus-indicator.review-card.ng-star-inserted div.overflow-auto div.d-flex.flex-row.mx-3.my-3:nth-child(1) div.flex-column.flex-fill.mx-3:nth-child(2) div.flex-row.mt-3:nth-child(2) > div.tab-panel-value-2")
	@CacheLookup
	WebElement txtFullName;

	//Field Email Header
	@FindBy(xpath="//div[contains(text(),'Email')]")
	@CacheLookup
	WebElement fieldEmailHeader;

	//Email Text
	@FindBy(css="div.content:nth-child(2) app-create-user.ng-star-inserted:nth-child(2) div.d-flex.flex-row.justify-content-center:nth-child(3) mat-card.mat-card.mat-focus-indicator.review-card.ng-star-inserted div.overflow-auto div.d-flex.flex-row.mx-3.my-3:nth-child(1) div.flex-column.flex-fill.mx-3:nth-child(2) div.flex-row.mt-3:nth-child(5) > div.tab-panel-value-2")
	@CacheLookup
	WebElement txtEmail;

	//Field Phone Header
	@FindBy(xpath="//div[contains(text(),'Phone(Work)')]")
	@CacheLookup
	WebElement fieldPhoneHeader;

	//Phone Text
	@FindBy(css="div.content:nth-child(2) app-create-user.ng-star-inserted:nth-child(2) div.d-flex.flex-row.justify-content-center:nth-child(3) mat-card.mat-card.mat-focus-indicator.review-card.ng-star-inserted div.overflow-auto div.d-flex.flex-row.mx-3.my-3:nth-child(1) div.flex-column.flex-fill.mx-3:nth-child(2) div.flex-row.mt-3:nth-child(8) > div.tab-panel-value-2")
	@CacheLookup
	WebElement txtPhone;

	//Section: Customer
	@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[3]/div[2]/div[1]/div[1]")
	@CacheLookup
	WebElement sectionCustomer;

	//Section: Roles & Permission
	@FindBy(xpath="//div[contains(text(),'Permission Roles')]")
	@CacheLookup
	WebElement sectionRolesPermission;

	//Button: Back
	@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[4]/div[1]/input[1]")
	@CacheLookup
	WebElement btnBack;

	//Button: Cancel
	@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[4]/div[2]/input[1]")
	@CacheLookup
	WebElement btnCancel;

	//Button: Create New User
	@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[4]/div[2]/input[2]")
	@CacheLookup
	WebElement btnCreateNewUser;

	//Loading Screen
	@FindBy(xpath="//div[@class='overlay ng-tns-c88-0 ng-trigger ng-trigger-fadeIn ng-star-inserted']")
	@CacheLookup
	WebElement overlay;

	//Toaster Notification
	@FindBy(xpath="//notifier-notification[@class='notifier__notification notifier__notification--error notifier__notification--material']")
	@CacheLookup
	WebElement toasterNotification;

WebElementFunctions func = new WebElementFunctions();
	
	public boolean verifyFormTitle()
	{
		return func.verifyElementDisplayedWithText(titleUserReview, "Review User");
	}

	//Verify Section Title "User Information"
	public boolean verifyUserInformationTitle()
	{
		return func.verifyElementDisplayedWithText(sectionUserInformation, "User Information");
	}

	//Verify Field Name Title
	public boolean verifyNameFieldTitle()
	{
		return func.verifyElementDisplayedWithText(fieldNameHeader, "Name");
	}

	//Verify Full Name Text is Read Only
	public String verifyNameReadOnly()
	{
		return txtFullName.getAttribute("readonly");
	}

	public String getName()
	{
		return txtFullName.getText();
	}

	//Verify Email Field Header
	public boolean verifyEmailFieldTitle()
	{
		return func.verifyElementDisplayedWithText(fieldEmailHeader, "Email");
	}

	//Verify Email Text Field is Read Only
	public String verifyEmailReadOnly()
	{
		return txtEmail.getAttribute("readonly").toString();
	}

	public String getEmail()
	{
		return txtEmail.getText();
	}

	//Verify Phone(Work) Header
	public boolean verifyPhoneTitle()
	{
		return func.verifyElementDisplayedWithText(fieldPhoneHeader, "Phone(Work)");
	}

	//Verify Email Text Field is Read Only
	public String verifyPhoneReadOnly()
	{
		return txtPhone.getAttribute("readonly").toString();
	}

	public String getPhone()
	{
		return txtPhone.getText();
	}

	//Verify Section Title "User Information"
	public boolean verifyCustomerTitle()
	{
		return func.verifyElementDisplayedWithText(sectionCustomer, "Customer");
	}

	//Verify Section Title "User Information"
	public boolean verifyRolesPermissionTitle()
	{
		return func.verifyElementDisplayedWithText(sectionRolesPermission, "Permission Roles");
	}


	//Verify All Customers are Displayed
	public boolean customersIsDisplayed()
	{
		return func.isElementsDisplayed(ldriver, "//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[3]/div[2]/div[2]/div[@class='ng-star-inserted']");
	}

	//Verify All Permission Roles Are Displayed
	public boolean permissionRolesIsDisplayed()
	{
		return func.isElementsDisplayed(ldriver, "//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[3]/div[3]/div[2]/div[@class='ng-star-inserted']");
	}

	//Verify Name Field is Read Only
	public boolean txtNameReadOnly()
	{
		return func.isReadOnly(txtFullName);
	}

	//Verify Email Field is Read Only
	public boolean txtEmailReadOnly()
	{
		return func.isReadOnly(txtEmail);
	}

	//Verify Phone Field is Read Only
	public boolean txtPhoneReadOnly()
	{
		return func.isReadOnly(txtPhone);
	}

	//Verify Customers Fields is Read Only
	public boolean txtCustomersReadOnly()
	{
		String customerNameXPATH = "//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[3]/div[2]/div[2]//div[@class='tab-panel-label']";
		List<WebElement> elements = ldriver.findElements(By.xpath(customerNameXPATH));
		int totalCount = 0;
		for(int i = 0; i < elements.size(); i++)
		{
			if(func.isReadOnly(elements.get(i)))
			{
				totalCount++;
			}
		}
		if(totalCount == elements.size())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//Verify Customers Fields is Read Only
	public boolean txtRolesReadOnly()
	{
		String roleFieldsXPATH = "//body/div[1]/app-create-user[1]/div[3]/mat-card[1]/div[3]/div[3]/div[2]//div[@class='tab-panel-label']";
		List<WebElement> elements = ldriver.findElements(By.xpath(roleFieldsXPATH));
		int totalCount = 0;
		for(int i = 0; i < elements.size(); i++)
		{
			if(func.isReadOnly(elements.get(i)))
			{
				totalCount++;
			}
		}
		if(totalCount == elements.size())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

  //Verify if back button is displayed and clickable
  public boolean btnBackIsDisplayedClickable()
	{
		return func.verifyElementIsClickable(btnBack, ldriver);
	}

	//Verify if Cancel button is displayed and clickable
	public boolean btnCancelIsDisplayedClickable()
	{
		return func.verifyElementIsClickable(btnCancel, ldriver);
	}

	//Verify if Back button is displayed and clickable
	public boolean btnCreateNewUserIsDisplayedClickable()
	{
		return func.verifyElementIsClickable(btnCreateNewUser, ldriver);
	}

	//Click Back Button
	public void clickBtnBack()
	{
		btnBack.click();
	}

	//Click Cancel Button
	public void clickBtnCancel()
	{
		btnCancel.click();
	}

	//Click Continue Button
	public void clickBtnCreateNewUser()
	{
		btnCreateNewUser.click();
		if(overlay.isDisplayed())
		{
			func.waitLoaderDisappear(overlay, ldriver);
		}
	}

	public String isToasterVisible()
	{
		return func.visibilityOfToasterNotification(toasterNotification, ldriver);
	}

	public String bgColourBtnCreateUser()
	{
		String colour = Color.fromString(btnCreateNewUser.getCssValue("background-color")).asHex();
		return colour;
	}
}

