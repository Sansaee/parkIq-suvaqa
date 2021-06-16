package parkIQ.pageObjects;

//import org.openqa.selenium.By;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import parkIQ.common.WebElementFunctions;

public class CreateNewUser_RolesAndPermissionPage {

	 WebDriver ldriver;


		public CreateNewUser_RolesAndPermissionPage(WebDriver rdriver) //a constructor; ldiver = local driver, rdriver = remote driver
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}

			//Form Title: Roles and Permissions
			@FindBy(xpath="//div[contains(text(),'Roles & Permissions')]")
			@CacheLookup
			WebElement formTitle ;

		
			WebElementFunctions func = new WebElementFunctions();

			//Verify "Form Title" is Displayed
			public boolean verifyFormTitle()
			{
				return func.verifyElementDisplayedWithText(formTitle, "Roles & Permissions");
			}
			
}
