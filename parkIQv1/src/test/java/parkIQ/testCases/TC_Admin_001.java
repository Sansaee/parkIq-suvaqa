package parkIQ.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import parkIQ.common.CommonFunctions;

public class TC_Admin_001 extends BaseClass {
	
		//Test that Setup is Successful
		@Test(priority = 0)
		public void setupAdminRole() throws InterruptedException {
			
			logger.info("SUPER USER ROLE TEST CASES - ASSIGN CUSTOMERS TO USERS");
			
			CommonFunctions cf = new CommonFunctions();
			cf.navigateToAdminPage();

	
			//verify page is redirected to admin page
			if (driver.getTitle().equals("Park IQ Admin")) {
				Assert.assertTrue(true);
				logger.info("User navigated to Admin Portal" + "\n");

			} else {
				Assert.assertTrue(false);
				logger.info("Naviagation of user to admin page test failed" + "\n");
			}
		}
		
		//check logo
		//check page header
		//check tabs 
		//check company details
		//check company name
		//check building information
		//add location
		
		//testing of company name & id should retrieve data from the selected customer in dropdown; verfiy that
		
}
