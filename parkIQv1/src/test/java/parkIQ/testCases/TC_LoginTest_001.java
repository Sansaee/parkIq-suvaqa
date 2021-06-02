package parkIQ.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import parkIQ.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void loginTest() throws IOException
	{
		
		
		logger.info("URL is opened");
		
		LoginPage lp= new LoginPage(driver);
		
		lp.confirmParkIQ();
		logger.info("Park IQ and Park Industries Business Intelligence is displayed");
		captureScreen(driver, "ParkIQ");
		
		lp.confirmSignIn();
		logger.info("Sign In confirmed");
		captureScreen(driver, "SignIn");
		
		lp.setEmail(email);
		logger.info("Entered Email");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		logger.info("Login button is clicked");
		
		lp.showRoles();
		logger.info("Drop down button is clicked");
		
		lp.selectRole();
		logger.info("Role is clicked");
		
		lp.clickSelect();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		logger.info("Select button is clicked");
		
		if(driver.getTitle().equals("Park IQ Admin"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
			
		}
		else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}

}
