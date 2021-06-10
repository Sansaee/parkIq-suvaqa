package parkIQ.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import parkIQ.pageObjects.ForgotPassword;

public class TC_ForgotPswrd_001 extends BaseClass {

		@Test (priority=0)
		public void checkTitle()
		{
			ForgotPassword fp = new ForgotPassword(driver);
	
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
			driver.get(baseURL);
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
//		@Test  (priority=4)
//		public void validateErrorMessage() throws IOException // this tests the validation message
//		{
//			
//			driver.get(baseURL);
//			ForgotPassword fp = new ForgotPassword(driver);
//			
//			fp.clickFrgtPaswrd();
//			logger.info("Clicked Forgot Password");
//			driver.navigate().refresh();
//			fp.setEmail(invalidEmail);
//			logger.info("Entered invalid email");
//			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//			fp.clickReset();;
//			System.out.print(fp.errorValidation() + "\n");
//			
//
//			//logger.info("Entered wrong email");
//
//		
//		}
}
