package parkIQ.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import parkIQ.common.WebElementFunctions;

public class CreateCustomerServiceUser {
	
	
	WebDriver ldriver;
	
	public CreateCustomerServiceUser(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//ParkIQ Logo on the top left
	@FindBy(xpath="//body/app-nav-menu[1]/nav[1]/a[1]/img[1]")
	@CacheLookup
	WebElement logo ;

	//Page Title
	@FindBy(xpath="//a[contains(text(),'Create Customer Service User')]")
	@CacheLookup
	WebElement pageTitle ;

	//User section header
	@FindBy(xpath="//div[contains(text(),'Users')]")
	@CacheLookup
	WebElement userHeader ;

	//create new user link
	@FindBy(xpath="//span[contains(text(),'Create New User')]")
	@CacheLookup
	WebElement linkCreateNewUser;

	//Search Bar
	@FindBy(xpath="//body/div[1]/app-customer-service[1]/div[1]/div[1]/app-users-main[1]/mat-card[1]/div[1]/div[1]/input[1]")
	@CacheLookup
	WebElement searchBar;
		

	
	@FindBy(xpath="//body/div[1]/app-customer-service[1]/div[1]/div[1]/app-users-main[1]/mat-card[1]/div[1]/div[2]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]")
	@CacheLookup
	WebElement ddSortBy;

	//Sort By Name
	@FindBy(xpath="//body/div[2]/div[2]/div[1]/div[1]/div[1]/mat-option[1]/span[1]")
	@CacheLookup
	WebElement ddSortByName;

	//Sort By Email
	@FindBy(xpath="//span[contains(text(),'Email')]")
	@CacheLookup
	WebElement ddSortByEmail;

	//Sort By Role
	@FindBy(xpath="//span[contains(text(),'Role')]")
	@CacheLookup
	WebElement ddSortByRole;

	//Sort By Last Login
	@FindBy(xpath="//span[contains(text(),'LastLogin')]")
	@CacheLookup
	WebElement ddSortByLastLogin;

	//Sort By IsActive
	@FindBy(xpath="//span[contains(text(),'IsActive')]")
	@CacheLookup
	WebElement ddSortByIsActive;
	
	//Name Header
	@FindBy(xpath="//th[contains(text(),'Name')]")
	@CacheLookup
	WebElement headerName;

	//Email Header
	@FindBy(xpath="//th[contains(text(),'Email')]")
	@CacheLookup
	WebElement headerEmail;

	//Role Header
	@FindBy(xpath="//th[contains(text(),'Role')]")
	@CacheLookup
	WebElement headerRole;

	//Last SignIn Header
	@FindBy(xpath="//th[contains(text(),'Last sing in')]")
	@CacheLookup
	WebElement headerLastSignIn;

	//Active User Header
	@FindBy(xpath="//th[contains(text(),'Active User')]")
	@CacheLookup
	WebElement headerActiveUser;
	
	WebElementFunctions func = new WebElementFunctions();
	
	public boolean locateLogo()
	{
		return logo.isDisplayed();
	}

	//Confirm Title "Create Customer Service User"
	public boolean locateTitle()
	{
		return func.verifyElementDisplayedWithText(pageTitle, "Create Customer Service User");
	}

	//Confirm Section Header "Users"
	public boolean locateSectionHeader()
	{
		return func.verifyElementDisplayedWithText(userHeader, "Users");
	}

	//Confirm Create User Link is Displayed and has Background Colour '#2652af'
	public boolean locateCreateUserLink()
	{
		String bgColour = linkCreateNewUser.getCssValue("color");
		boolean isCorrectColour = Color.fromString(bgColour).asHex().equals("#2652af");
		if(linkCreateNewUser.isDisplayed() && isCorrectColour)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public String createUserColor()
	{
		String colour = Color.fromString(linkCreateNewUser.getCssValue("color")).asHex();
		return colour;
	}
	
	public String createUserDecoratorBefore()
	{
		String decorator = linkCreateNewUser.getCssValue("text-decoration");
		return decorator;
	}
	
	
	public boolean locateSearchBar()
	{
		return searchBar.isDisplayed();
	}
//	
//	//Get number of results produced from search term
//		public int searchTest(String variable)
//		{
//			searchBar.sendKeys(variable);
//
//			List<WebElement> rows = ldriver.findElements(By.xpath("//tbody/tr"));
//			int count = rows.size();
//			return count;
//		}
	
	public boolean displaySortByDD()
	{
		if(ddSortBy.isDisplayed())
		{
			ddSortBy.click();
			if(ddSortByName.isDisplayed() && ddSortByEmail.isDisplayed() && ddSortByRole.isDisplayed() && ddSortByLastLogin.isDisplayed() && ddSortByIsActive.isDisplayed())
			{

				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	public boolean locateColumnHeaders()
	{
		if(headerName.isDisplayed() && headerEmail.isDisplayed() && headerRole.isDisplayed() && headerLastSignIn.isDisplayed() && headerActiveUser.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}

	}

}
