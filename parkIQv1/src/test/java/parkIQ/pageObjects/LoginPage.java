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
		
		@FindBy(xpath="/html/body/ngb-modal-window/div/div/div[2]/ng-select/div/span")
		@CacheLookup
		WebElement ddListofRoles;
		
		@FindBy(xpath="/html/body/ngb-modal-window/div/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div[3]/span")
		@CacheLookup
		WebElement ddSelectRole;
		
		@FindBy(xpath="/html/body/ngb-modal-window/div/div/div[3]/button")
		@CacheLookup
		WebElement btnSelect;
		
		@FindBy(xpath="/html/body/div/div/div/div/div[1]/div/h2")
		@CacheLookup
		WebElement txtSignIn;
		
		@FindBy(xpath="/html/body/nav/a/img")
		@CacheLookup
		WebElement imgParkIQ;
		
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
		public void showRoles() 
		{
			ddListofRoles.click();
		}
		public void selectRole() 
		{
			ddSelectRole.click();
		}
		public void clickSelect() 
		{
			btnSelect.click();
		}
		public void confirmSignIn() 
		{
			txtSignIn.isDisplayed();
		}
		public void confirmParkIQ()
		{
			imgParkIQ.isDisplayed();
		}
}
