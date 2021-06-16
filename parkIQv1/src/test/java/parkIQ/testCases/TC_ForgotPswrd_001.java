package parkIQ.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import parkIQ.pageObjects.CreateNewUser_UserInformationPage;
import parkIQ.pageObjects.ForgotPassword;

public class TC_ForgotPswrd_001 extends BaseClass {

		@Test (priority=0)
		public void checkTitle()
		{
			ForgotPassword fp = new ForgotPassword(driver);

			
			logger.info("FORGOT PASSWORD TEST CASES");
			
			fp.clickFrgtPaswrd();
			logger.info("Clicked Forgot Password link and form opens");
			
			boolean title = fp.locateTitle();
	
				if(title == true)
				{
					logger.info("Forgot Password Title is displayed correctly");
				}
				else
				{
					logger.info("Forgot Password Title is missing");
				}
			
			boolean emailText = fp.locateEmailLabel();
				if(emailText == true)
				{
					logger.info("Email text is displayed correctly");
				}
				else
				{
					logger.info("Email text is missing");
				}
			boolean emailField = fp.locateEmailField(); //left to test if field is clickable
				if(emailField == true)
				{
					logger.info("Email field is displayed correctly" +"\n");
				}
				else
				{
					logger.info("Email field is missing" +"\n");
				}
			
		}
	
		@Test (priority=1)
		public void resetForgotPassword() 
		{
			ForgotPassword fp = new ForgotPassword(driver);
			
			fp.setEmail(email);
			logger.info("Entered Email for reset");
			boolean resetBtn = fp.locateResetBtn(); 
			if(resetBtn == true)
				{
					logger.info("Reset text is displayed correctly. Text Colour: " + fp.resetBtnColor() + "  Background Color:" + fp.resetBckgrndColor());
				}
				else
				{
					logger.info("Reset text is missing");
				}
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			fp.clickReset();
			
				if(driver.getTitle().equals("Password Reset - ParkIQ"))
				{
					Assert.assertTrue(true);
					logger.info("Reset password test passed" +"\n");
					
				}
				else {
					Assert.assertTrue(false);
					logger.info("Reset password test failed" +"\n");
				}
			
		}

		@Test (priority=2)
		public void cancelResetPassword() // this tests that clicking cancel button goes back to the home page
		{
			
			driver.get(baseURL);
			ForgotPassword fp = new ForgotPassword(driver);
			
			fp.clickFrgtPaswrd();
			logger.info("Clicked Forgot Password");
			fp.setEmail(email);
			logger.info("Entered Email");
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			boolean cancelBtn = fp.locateCancelBtn(); 
				if(cancelBtn == true)
					{
						logger.info("Cancel text is displayed correctly. Text color:"  + fp.cancelBtnColor() + "  Background Color:" + fp.cancelBckgrndColor());
					}
					else
					{
						logger.info("Cancel text is missing");
					}
			fp.clickCancel();
			logger.info("Cancelled password reset");
			
				if(driver.getTitle().equals("Sign in - ParkIQ"))
				{
					Assert.assertTrue(true);
					logger.info("Password reset cancellation passed: User is navigated to sign-in form" +"\n");
					
				}
				else {
					Assert.assertTrue(false);
					logger.info("Password reset cancellation failed"+"\n");
				}	
		
		}
		
		@Test  (priority=3)
		public void validateTexts()
		{
			ForgotPassword fp = new ForgotPassword(driver);
			
			fp.clickFrgtPaswrd();
			logger.info("Clicked Forgot Password");
			
			
			boolean becomeMembrTxt = fp.locateBecomeMembrText(); 
				if(becomeMembrTxt == true)
					{
						logger.info("Become Member text is displayed correctly");
					}
					else
					{
						logger.info("Become Member text is missing");
					}
			boolean signUpTxt = fp.locateSignUpText(); 
				if(signUpTxt == true)
					{
						logger.info("Sign Up text is displayed correctly. Text underlined: " + fp.signUpDecoratorBefore() + "Text color:"+ fp.signUpTxtColor() + "\n");
					}
					else
					{
						logger.info("Sign Up text is missing" +"\n");
					}
		}

		
		@Test (priority = 4)
		public void testInvalidEmail()
		{
			ForgotPassword fp = new ForgotPassword(driver);
			driver.get(baseURL);
			fp.clickFrgtPaswrd();
			logger.info("Clicked Forgot Password");
			
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			fp.setEmail(invalidEmail);
			logger.info("Entered invalid email: " + invalidEmail);

			fp.clickReset();
			logger.info("Clicked Reset Button");

			boolean isInvalidEmailMessageVal = fp.isInvalidEmail();


			if(isInvalidEmailMessageVal)
			{
				Assert.assertTrue(true);
				logger.info("Email '" + invalidEmail + "' is an invalid email");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Email validation is faulty");
			}
		}

	@Test (priority = 5)
	public void testUregisteredEmail()
	{
		ForgotPassword fp = new ForgotPassword(driver);
		driver.get(baseURL);
		fp.clickFrgtPaswrd();
		logger.info("Clicked Forgot Password");

		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		fp.setEmail(unregisteredEmail);
		logger.info("Entered invalid email: " + unregisteredEmail);

		fp.clickReset();
		logger.info("Clicked Reset Button");

		boolean isEmailNotExistMessageVal = fp.isEmailNotExist();


		if(isEmailNotExistMessageVal)
		{
			Assert.assertTrue(true);
			logger.info("No account was found with email address '" + unregisteredEmail + "'");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Email validation is faulty");
		}
	}
		
		//have to test emails stored or not stored in database
}
