package parkIQ.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateNewUser_ReviewUserPage {
	WebDriver ldriver;
	
	public CreateNewUser_ReviewUserPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
}

