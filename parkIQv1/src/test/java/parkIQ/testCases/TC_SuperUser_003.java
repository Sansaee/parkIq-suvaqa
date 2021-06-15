package parkIQ.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import parkIQ.pageObjects.CreateCustomerServiceUser;
import parkIQ.pageObjects.CreateNewUser_AssignCustomersToUserProfilePage;
import parkIQ.pageObjects.LoginPage;
import parkIQ.pageObjects.OperationModePrompt;
import parkIQ.pageObjects.SuperUserPortalPage;

public class TC_SuperUser_003 extends BaseClass {
	//Test Case for assigning customer to user profile
	
	public void  setupSuperUserRole() throws InterruptedException 
	{
		OperationModePrompt omp = new OperationModePrompt(driver);
		LoginPage lp= new LoginPage(driver);
		
		
		logger.info("SUPER USER ROLE TEST CASES - CREATE CUSTOMER SERVICE USER");
		
		lp.logIn(email, password);
		logger.info("Successfully logged in");
	
		omp.selectModeOption();
		logger.info("Operation Mode Selection Mode Displayed");

		omp.selectSuperUser();
		logger.info("Super User Portal Option Selected");

		omp.clickSelect();
		logger.info("Select Button Clicked");

		logger.info("Entered Super User Portal Page");


		if(driver.getTitle().equals("Park IQ Admin"))
		{
			Assert.assertTrue(true);
			logger.info("User navigated to super user role form" +"\n");
			
		}
		else {
			Assert.assertTrue(false);
			logger.info("Super user form test failed" +"\n");
		}
		
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void validateTitle_content() throws InterruptedException
	{
		SuperUserPortalPage sup = new SuperUserPortalPage(driver);
		CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(driver);
		sup.clickCreateUserLink();
		ac.setFirstName(name);
		ac.setLastName(lname);
		ac.setEmail(email);
		ac.clickContBtn();
		
		if(driver.getTitle().equals("Park IQ Admin"))
		{
			Assert.assertTrue(true);
			logger.info("User navigated to assigning customers form" +"\n");
			
		}
		else {
			Assert.assertTrue(false);
			logger.info("Assigning customers form test failed" +"\n");
		}
		
		boolean title = ac.verifyFormTitle();
		if(title == true)
		{
			logger.info("Assign Customers to User Profile title is displayed correctly");
		}
		else
		{
			logger.info("Assign Customers to User Profile title is missing");
		}
		
		boolean description = ac.verifyFormDescription();
		if(description == true)
		{
			logger.info("Form Description displayed correctly");
		}
		else
		{
			logger.info("Form Description is missing");
		}
		
	}
	
	@Test (priority=2)
	public void testColumns()
	{
		CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(driver);
		boolean column = ac.locateColumnHeaders();

		if(column == true)
		{
			logger.info("Displays column headers correctly");
		}
		else
		{
			logger.info("Column headers are not displayed correctly");
		}
	}
		
	
	@Test(priority=3)
	public void testBackButton()
	{
		
	}

}
