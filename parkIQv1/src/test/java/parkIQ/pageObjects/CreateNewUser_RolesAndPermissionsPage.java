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

public class CreateNewUser_RolesAndPermissionsPage {
	
	WebDriver ldriver;
	
	public CreateNewUser_RolesAndPermissionsPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Roles & Permissions')]")
	@CacheLookup
	WebElement formTitle;
	
	@FindBy(xpath="//div[@class='mx-3 my-2']")
	@CacheLookup
	WebElement formDescription;
	
	@FindBy(xpath="//input[@id='mat-checkbox-30-input']")
	@CacheLookup
	WebElement csCheckboxes;
	
	@FindBy(xpath="//span[contains(text(),'(full access to Administration Center, Customer Service Portal and Dashboard 'note: multitenant access'')]")
	@CacheLookup
	WebElement csCheckboxText;
	
	@FindBy(xpath="//input[@id='mat-checkbox-31-input']")
	@CacheLookup
	WebElement suCheckboxes;
	
	@FindBy(xpath="//span[contains(text(),'(access only to Customer Service user creation)')]")
	@CacheLookup
	WebElement suCheckboxText;
	
	@FindBy(xpath="//input[@id='mat-checkbox-32-input']")
	@CacheLookup
	WebElement insCheckboxes;
	
	@FindBy(xpath="//span[contains(text(),'(access to Installer Package)')]")
	@CacheLookup
	WebElement insCheckboxText;
	
	/*@FindBy(xpath="//input[@value='Back']")
	@CacheLookup
	WebElement btnBack;
	
	@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/div[1]/div[4]/div[1]/input[1]")
	@CacheLookup
	WebElement btnBackClicked;*/
	
	@FindBy(xpath="//body[@class='mat-typography']/app-root[@ng-version='9.1.3']/body/div[@class='content']/app-create-user[@class='ng-star-inserted']/div[@class='d-flex flex-row justify-content-center']/div[@class='permissions-card ng-star-inserted']/div[@class='d-flex flex-row mx-3 justify-content-between my-3']/div[1]/input[1]")
	@CacheLookup
	WebElement btnBack;
	
	@FindBy(xpath="//body[@class='mat-typography']/app-root[@ng-version='9.1.3']/body/div[@class='content']/app-create-user[@class='ng-star-inserted']/div[@class='d-flex flex-row justify-content-center']/div[@class='permissions-card ng-star-inserted']/div[@class='d-flex flex-row mx-3 justify-content-between my-3']/div[2]/input[1]")
	@CacheLookup
	WebElement btnCancel;
		
	@FindBy(xpath="//body[@class='mat-typography']/app-root[@ng-version='9.1.3']/body/div[@class='content']/app-create-user[@class='ng-star-inserted']/div[@class='d-flex flex-row justify-content-center']/div[@class='permissions-card ng-star-inserted']/div[@class='d-flex flex-row mx-3 justify-content-between my-3']/div[2]/input[2]")
	@CacheLookup
	WebElement btnContinue;
	
	@FindBy(xpath="//input[@value='Continue' and @disabled]")
	@CacheLookup
	WebElement btnContinueDisabled;
	
	@FindBy(xpath="//input[@value='Continue' and not(@disabled)]")
	@CacheLookup
	WebElement btnContinueEnabled;
	
	/*@FindBy(xpath="//input[contains(@style, 'background-color: #686868')]")
	@CacheLookup
	WebElement btnContinueColor;*/
	
	@FindBy(xpath="//body/div[1]/app-create-user[1]/div[3]/div[1]/div[4]/div[2]/input[2]")
	@CacheLookup
	WebElement btnContinueClicked;
	
	WebElementFunctions func = new WebElementFunctions();
	
	public boolean verifyFormTitle()
	{
		return func.verifyElementDisplayedWithText(formTitle, "Roles & Permissions");
	}
		
	public boolean verifyFormDescription()
	{
		return func.verifyElementDisplayedWithText(formDescription, "Selecting a role determines what permissions this user will have. You can expand the Role name to select specific permissions.");
	}
	
	public boolean locateCSCheckBox()
	{
		return csCheckboxes.isDisplayed();
	}
	
	public boolean locateSUCheckBox()
	{
		return suCheckboxes.isDisplayed();
	}
	
	
	public boolean locateINSCheckBox()
	{
		return insCheckboxes.isDisplayed();
	}
	
	public void clickCheckBox()
	{
		csCheckboxes.click();
		suCheckboxes.click();
		insCheckboxes.click();
	}
	
	public int isChecked()
	{
		int checkedCount = 0;
		List<WebElement> elements = ldriver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i = 0; i < elements.size(); i++)
		{
			if(elements.get(i).isSelected())
			{
				checkedCount++;
			}
		}
		return checkedCount;
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
	
	public boolean btnContDisplayed()
	{
		return btnContinue.isDisplayed();
	}
	
	public String btnContinueBgColour()
	{
		String bgColour = Color.fromString(btnContinue.getCssValue("background-color")).asHex();
		return bgColour;
	}
	
	public void clickContBtn()
	{
		btnContinueClicked.click();
	}
	
}
