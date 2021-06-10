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
			@FindBy(xpath="//div[contains(text(),'Assign Customers to User Profile')]")
			@CacheLookup
			WebElement formTitle ;


			WebElementFunctions func = new WebElementFunctions();

			//Wait
			public void load()
			{
				func.pageLoad(ldriver);
			}



			//Confirm Form Title "User Information"
			public boolean verifyFormTitle()
			{
				return func.verifyElementDisplayedWithText(formTitle, "Assign Customers to User Profile");
			}


}
