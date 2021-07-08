package parkIQ.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import parkIQ.common.WebElementFunctions;

public class AdminSchedule {
	
	WebDriver ldriver;
	public AdminSchedule(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Schedule tab
	@FindBy(xpath="//div[@class='mat-tab-label-content'][contains(text(),'Schedule')]")
	@CacheLookup
	WebElement btnSchedule;
	
	//Schedule form header
	@FindBy(xpath="//div[@class='tab-panel-title']")
	@CacheLookup
	WebElement schedulePageHeader;
	
	//Shifts field
	@FindBy(xpath="//div[@class='tab-panel-label'][contains(text(),'Shifts')]")
	@CacheLookup
	WebElement shiftsField;
	
	//Setup your company's work schedule text
	@FindBy(xpath="//div[contains(text(),'Setup your company’s work schedule:')]")
	@CacheLookup
	WebElement setupCompTxt;
	
	//Day Shit text
	@FindBy(xpath="//div[contains(text(),'Day Shift')]")
	@CacheLookup
	WebElement dayShiftTxt;
	
	//Night shift text 
	@FindBy(xpath="//div[contains(text(),'Night Shift')]")
	@CacheLookup
	WebElement nightShiftTxt;
	
	//Edit shift field
	@FindBy(xpath="//body[@class='mat-typography']/app-root[@ng-version='9.1.3']/body/div[@class='content']/app-company[@class='ng-star-inserted']/div[@class='container my-5 ng-star-inserted']/div[@class='row']/div[@class='col-sm-12 col-md']/mat-tab-group[@class='mat-tab-group mat-primary']/div[@class='mat-tab-body-wrapper']/mat-tab-body[@id='mat-tab-content-0-1']/div[@class='mat-tab-body-content ng-tns-c161-3 ng-trigger ng-trigger-translateTab']/app-company-location-schedule[@class='ng-star-inserted']/div[@class='my-3']/mat-card[@class='mat-card mat-focus-indicator tab-panel']/div[@class='ng-star-inserted']/div[@class='row mb-3']/div[@class='col-12 col-md-10']/div[1]/div[1]/div[2]/div[1]/a[1]/img[1]")
	@CacheLookup
	WebElement editDayShiftField;
	
	//Edit shift form
	@FindBy(xpath="//div[contains(text(),'Edit Shift')]")
	@CacheLookup
	WebElement editDayShiftForm;
	
	//Name field
	@FindBy(xpath="//input[@type='text']")
	@CacheLookup
	WebElement nameShiftField;
	
	//Hours text
	@FindBy(xpath="//div[@class='col-12 col-md-1']//div[@class='tab-panel-label'][contains(text(),'Hours')]")
	@CacheLookup
	WebElement hoursShifText;
	
	//Sunday slider button
	@FindBy(xpath="//mat-slide-toggle[@id='mat-slide-toggle-14']//label[@class='mat-slide-toggle-label']//div[@class='mat-slide-toggle-bar']")
	@CacheLookup
	WebElement btnSliderSunday;
	
	//Monday slider button
	@FindBy(xpath="//mat-slide-toggle[@id='mat-slide-toggle-15']//label[@class='mat-slide-toggle-label']//div[@class='mat-slide-toggle-bar']")
	@CacheLookup
	WebElement btnSliderMonday;
	
	//Tuesday slider button
	@FindBy(xpath="//mat-slide-toggle[@id='mat-slide-toggle-16']//label[@class='mat-slide-toggle-label']//div[@class='mat-slide-toggle-bar']")
	@CacheLookup
	WebElement btnSliderTuesday;
	
	//Wednesday slider button
	@FindBy(xpath="//mat-slide-toggle[@id='mat-slide-toggle-17']//label[@class='mat-slide-toggle-label']//div[@class='mat-slide-toggle-bar']")
	@CacheLookup
	WebElement btnSliderWednesday;
	
	//Thursday slider button
	@FindBy(xpath="//mat-slide-toggle[@id='mat-slide-toggle-18']//label[@class='mat-slide-toggle-label']//div[@class='mat-slide-toggle-bar']")
	@CacheLookup
	WebElement btnSliderThursday;
	
	//Friday slider button
	@FindBy(xpath="//mat-slide-toggle[@id='mat-slide-toggle-19']//label[@class='mat-slide-toggle-label']//div[@class='mat-slide-toggle-bar']")
	@CacheLookup
	WebElement btnSliderFriday;
	
	//Saturday slider button
	@FindBy(xpath="//mat-slide-toggle[@id='mat-slide-toggle-20']//label[@class='mat-slide-toggle-label']//div[@class='mat-slide-toggle-bar']")
	@CacheLookup
	WebElement btnSliderSaturday;
	
	//Delete shift button
	@FindBy(xpath="//button[contains(text(),'Delete Shift')]")
	@CacheLookup
	WebElement btnDeleteShift;
	
	//Discard changes button
	@FindBy(xpath="//button[contains(text(),'Discard Changes')]")
	@CacheLookup
	WebElement btnDiscrdChanges;
	
	//Save changes button
	@FindBy(xpath="//button[contains(text(),'Save Changes')]")
	@CacheLookup
	WebElement btnSaveChanges;
	
	//Planned Downtime field
	@FindBy(xpath="//div[@class='tab-panel-label'][contains(text(),'Planned Downtime')]")
	@CacheLookup
	WebElement fieldPlannedDwntime;
	
	
	//Production hours
	
	//methods for the above web elements
	
	WebElementFunctions func = new WebElementFunctions();

	
	//Schedule tab is displayed & clickable
	public boolean tabScheduleDisplayedClickable()
	{
		return func.verifyElementIsClickable(btnSchedule, ldriver);
	}

	//Click Schedule tab
	public void clickScheduleTab()
	{
		btnSchedule.click();
	}

	//Confirm Header "Schedule"
	public boolean verifyHeader()
	{
		return func.verifyElementDisplayedWithText(schedulePageHeader, "User Information");
	}
	
	//Confirm field "Shifts"
	public boolean verifyShiftsField()
	{
		return func.verifyElementDisplayedWithText(shiftsField, "Shifts");
	}
	
	//Confirm text "Company setup..."
	public boolean verifyCompnSetTxt()
	{
		return func.verifyElementDisplayedWithText(setupCompTxt, "Setup your company’s work schedule:");
	}
	
	//Confirm field "Day Shift"
	public boolean verifyDayShiftField()
	{
		return func.verifyElementDisplayedWithText(dayShiftTxt, "Day Shift");
	}	
	
	//Confirm field "Night Shift"
	public boolean verifyNightShiftField()
	{
		return func.verifyElementDisplayedWithText(nightShiftTxt, "Night Shift");
	}	
	
	//Click day shift field
	public void clickEditDayShift()
	{
		editDayShiftField.click();
	}
}
