package parkIQ.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	WebDriver ldriver;
	public AdminPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//ParkIQ Logo for Admin Portal
	@FindBy(xpath="//img[@class='parkiq-logo-img']")
	@CacheLookup
	WebElement logo;
	
	//Company Page Header for admin portal
	@FindBy(xpath="//a[@class='nav-link main-nav-item mx-3 my-1'][contains(text(),'Company')]")
	@CacheLookup
	WebElement companyPageHeader;
	
	//Users Page Header for admin portal
	@FindBy(xpath="//a[contains(text(),'Users')]")
	@CacheLookup
	WebElement usersPageHeader;
	
	//Maintenance Page Header for admin portal
	@FindBy(xpath="//a[contains(text(),'Maintenance')]")
	@CacheLookup
	WebElement maintenancePageHeader;
	
	//Subscription Page Header for admin portal
	@FindBy(xpath="//a[contains(text(),'Subscription')]")
	@CacheLookup
	WebElement subscriptionPageHeader;
	
	//Information tab for admin portal
	@FindBy(xpath="//div[@class='mat-tab-label-content'][contains(text(),'Information')]")
	@CacheLookup
	WebElement informationTab;
	
	//Schedule tab for admin portal
	@FindBy(xpath="//div[@id='mat-tab-label-0-1']")
	@CacheLookup
	WebElement scheduleTab;
	
	//Schedule tab for admin portal
	@FindBy(xpath="//div[contains(text(),'Goals')]")
	@CacheLookup
	WebElement goalsTab;
	
	//Schedule tab for admin portal
	@FindBy(xpath="//div[@id='mat-tab-label-0-3']")
	@CacheLookup
	WebElement machinesTab;
	
	//Schedule tab for admin portal
	@FindBy(xpath="//div[@id='mat-tab-label-0-4']")
	@CacheLookup
	WebElement usersTab;
	
	//Company name 
	@FindBy(xpath="//div[@class='company-title']")
	@CacheLookup
	WebElement comapnyName;
	
	//Company ID
	@FindBy(xpath="//div[@class='company-id']")
	@CacheLookup
	WebElement companyId;
	
	//Company name edit marker
	@FindBy(xpath="//div[@class='d-flex flex-row pt-4 pb-2 mr-3']//div[@class='col-1 d-flex flex-wrap align-items-center']//div[@class='ng-star-inserted']//a[@href='javascript:;']//img[@class='link-icon']")
	@CacheLookup
	WebElement compNameEditMrkr;
	
	//Edit company name field
	@FindBy(xpath="//input[@type='text']")
	@CacheLookup
	WebElement editCompName;
	
	//Save changes button
	@FindBy(xpath="//button[contains(text(),'Save Changes')]")
	@CacheLookup
	WebElement btnSaveChanges;
	
	//Discard changes button
	@FindBy(xpath="//button[@class='discard-btn']")
	@CacheLookup
	WebElement btnDscrdChanges;

	
	
	
	
}
