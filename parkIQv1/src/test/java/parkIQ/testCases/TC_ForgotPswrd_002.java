package parkIQ.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import parkIQ.pageObjects.ForgotPassword;

public class TC_ForgotPswrd_002 extends BaseClass {
	
	//STILL NEEDS TO ENHANCE THIS TEST CASE

	//the target title https://api-nc-test-security.azurewebsites.net/Account/ForgotPassword
	//type email
	//click reset or click cancel (cancel talkes you back to sign in page)
	
	//become a member sign up here
	//target url https://api-nc-test-security.azurewebsites.net/Account/Register
	//fill details
	//click sign up or cancel //click cancel then target url is Sign In Home Page
	
	//click I/m a member- Sign In, then target url : https://api-nc-test-security.azurewebsites.net/Account/Login
	//click Need Help ?, then pop up of requirements. //click close 

	
	@Test
	public void forgotPaswrd()
	{
		ForgotPassword fp = new ForgotPassword(driver);
		fp.clickFrgtPaswrd();
		logger.info("Clicked Forgot Password");
		fp.setEmail(email);
		logger.info("Entered Email for reset");
		fp.clickReset();
		
		if(driver.getTitle().equals("Password Reset - ParkIQ"))
		{
			Assert.assertTrue(true);
			logger.info("Reset password test passed");
			
		}
		else {
			Assert.assertTrue(false);
			logger.info("Reset password test failed");
		}
		
		//test if incorrect email were entered, the message should be as such:
		//No account was found with that email address. Verify your email address or click the Register link to create an account
		//If successful reset: this is the target title : Password Reset - ParkIQ
		
		
		
	}
}
