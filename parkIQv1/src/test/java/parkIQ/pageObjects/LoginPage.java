package parkIQ.pageObjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	 WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) //a constructor; ldiver = local driver, rdriver = remote driver
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}

		//WebElement txtEmail = ldriver.findElement(By.id("Email"));
		@FindBy(xpath="//input[@id='Email']")
		@CacheLookup
		WebElement txtEmail ;
		
		@FindBy(xpath="//input[@id='Password']")
		@CacheLookup
		WebElement txtPassword ;
		
		@FindBy(xpath="//button[@type='submit']")
		@CacheLookup
		WebElement btnLogin ;
		
		//action methods
		
		public void setEmail(String uname )
		{
			txtEmail.sendKeys(uname);
		}
		public void setPassword(String pwd )
		{
			txtPassword.sendKeys(pwd);
		}
		public void clickSubmit()
		{
			btnLogin.click();
		}
}
