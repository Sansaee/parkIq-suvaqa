package parkIQ.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SuperUserRole {

	
	WebDriver ldriver;
	
	public SuperUserRole(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	
	@FindBy(xpath="//span[@class='ng-arrow-wrapper']")
	@CacheLookup
	WebElement dropdownUser;
	
	@FindBy(xpath="//span[@class='ng-option-label ng-star-inserted'][contains(text(),'Super User Portal')]")
	@CacheLookup
	WebElement chooseDropdown;
	
	@FindBy(xpath="//button[contains(text(),'Select')]")
	@CacheLookup
	WebElement btnSelect;
	
	
	@FindBy(xpath="//img[@class='parkiq-logo-img']")
	@CacheLookup
	WebElement displayLogo;

	@FindBy(xpath="//a[@class='nav-link main-nav-item mx-3']")
	@CacheLookup
	WebElement titleCreateUser;
	
	@FindBy(xpath="//div[@class='operations-title my-4']")
	@CacheLookup
	WebElement titleUsers;
	
	@FindBy(xpath="//span[@class='card-item-link']")
	@CacheLookup
	WebElement linkCreateUser;
	
	@FindBy(xpath="//input[@class='search-bar']")
	@CacheLookup
	WebElement searchBarField;
	
	@FindBy(xpath="//div[@class='mat-select-value ng-tns-c152-3']")
	@CacheLookup
	WebElement sortByDropdown;
	
	//web elements for creating new users
	@FindBy(xpath="//span[@class='card-item-link']")
	@CacheLookup
	WebElement linkCreateNewUser;
	
	@FindBy(xpath="//body[@class='mat-typography']/app-root[@ng-version='9.1.3']/body/div[@class='content']/app-create-user[@class='ng-star-inserted']/div[@class='d-flex flex-row justify-content-center']/mat-card[@class='mat-card mat-focus-indicator create-user-card ng-star-inserted']/form[@class='ng-pristine ng-invalid ng-touched']/div[@class='d-flex flex-row justify-content-between mx-3 my-3']/input[1]")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(xpath="//body[@class='mat-typography']/app-root[@ng-version='9.1.3']/body/div[@class='content']/app-create-user[@class='ng-star-inserted']/div[@class='d-flex flex-row justify-content-center']/mat-card[@class='mat-card mat-focus-indicator create-user-card ng-star-inserted']/form[@class='ng-pristine ng-invalid ng-touched']/div[@class='d-flex flex-row justify-content-between mx-3 my-3']/input[2]")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(xpath="//input[@type='email']")
	@CacheLookup
	WebElement userEmail;
	
	@FindBy(xpath="//input[@type='tel']")
	@CacheLookup
	WebElement phoneNumber;
	
	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup
	WebElement btnContinue;
	
	@FindBy(xpath="//input[@type='button']")
	@CacheLookup
	WebElement btnCancel;
	
	
	public void showDropdown()
		{
			dropdownUser.click();
		}
	
	public void clickRole()
		{
			chooseDropdown.click();
		}
	
	public void clickSelect()
		{
			btnSelect.click();
		}
	
	public boolean locateLogo()
		{
			if(displayLogo.isDisplayed())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	
	public boolean locateTitle()
		{
			if(titleCreateUser.isDisplayed() && titleCreateUser.getText().equals("Create Customer Service User"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	

	public boolean locateSectionHeader()
		{
			if(titleUsers.isDisplayed() && titleUsers.getText().equals("Users"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	
	public boolean locateCreateNewUserLink()
		{
			if( linkCreateUser.isDisplayed() &&  Color.fromString(linkCreateUser.getCssValue("color")).asHex().equals("#2652af"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	public String createNewUserDecoratorBefore()
	{
		String decorator = linkCreateUser.getCssValue("text-decoration");
		return decorator;
	}

	public String createNewUserColor()
		{
			String colour = Color.fromString(linkCreateUser.getCssValue("color")).asHex();
			return colour;
		}
		
	public boolean locateSearchBar()
		{
			if( searchBarField.isDisplayed() )
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	
	public boolean locateSortByDropDown()
	{
		if(sortByDropdown.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
//	public String[] validateValueDropDown()
//	{
//		String arr[] = {"Name","Email","Role","LastLogin","IsActive"};
//		Select dropdownSelect = new Select(sortByDropdown);
//		List<WebElement> dropdownvalues=dropdownSelect.getOptions();
//		for(int i=0; i<dropdownvalues.size();i++)
//		{
//			Assert.assertEquals(arr[i],dropdownvalues.get(i).getText());
//		}
//		
//		System.out.println("Drop down fields verified successfully");
//	
//		return arr;
//	}
		
//	public void searchName (String name)
//	{
//		searchBarDisplayed.sendKeys(name);
//	}
	
	//methods for creating new users
	
	
}
