package parkIQ.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import parkIQ.pageObjects.ForgotPassword;

public class TC_ForgotPswrd_001 extends BaseClass {

	
	@Test (priority=0)
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
		
		
	}
		
		@Test (priority=1)
		public void forgotPaswrd1() // this tests that clicking cancel button goes back to the home page
		{
			driver.get(baseURL);
			ForgotPassword fp = new ForgotPassword(driver);
			
			fp.clickFrgtPaswrd();
			logger.info("Clicked Forgot Password");
			fp.setEmail(email);
			logger.info("Cancelled password reset");
			fp.clickCancel();
			
			if(driver.getTitle().equals("Sign in - ParkIQ"))
			{
				Assert.assertTrue(true);
				logger.info("Password reset cancellation passed");
				
			}
			else {
				Assert.assertTrue(false);
				logger.info("Password reset cancellation failed");
			}	
		
		}
		
//		@Test (priority=2)
//		public void forgotPaswrd2() // this tests the validation message
//		{
//			driver.get(baseURL);
//			ForgotPassword fp = new ForgotPassword(driver);
//			
//			fp.clickFrgtPaswrd();
//			logger.info("Clicked Forgot Password");
//			
//			fp.setEmail(invalidEmail);
//			logger.info("Entered invalid email");
//			System.out(setEmail.getAttribute("validationMessage"));
//			
//			fp.setEmail(wrongEmail);
//			logger.info("Entered wrong email");
//		
//		}
}
