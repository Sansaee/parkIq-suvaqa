package parkIQ.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import parkIQ.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void loginTest()
	{
		
		
		logger.info("URL is opened");
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		logger.info("Entered Email");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Park IQ Admin"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
			
		}
		else {
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}

}
