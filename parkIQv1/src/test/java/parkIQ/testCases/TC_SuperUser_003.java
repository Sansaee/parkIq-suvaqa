package parkIQ.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import parkIQ.pageObjects.CreateNewUser_AssignCustomersToUserProfilePage;
import parkIQ.pageObjects.LoginPage;
import parkIQ.pageObjects.OperationModePrompt;
import parkIQ.pageObjects.SuperUserPortalPage;

public class TC_SuperUser_003 extends BaseClass {
	//Test Case for assigning customer to user profile
	
	@Test(priority=0)
	public void  setupSuperUserRole() throws InterruptedException 
	{
		OperationModePrompt omp = new OperationModePrompt(driver);
		LoginPage lp= new LoginPage(driver);
		
		
		logger.info("SUPER USER ROLE TEST CASES - ASSIGN CUSTOMERS TO USERS");
		
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
		CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(driver);
		boolean isBtnBackClickable = ac.btnBackClickableDisplayed();
		if(isBtnBackClickable)
		{
			Assert.assertTrue(true);
			logger.info("Back button is displayed and clickable");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Back button is missing");
		}
		
		ac.clickBackBtn();
		logger.info("Back button clicked");
		if(driver.getTitle().equals("Park IQ Admin"))
		{
			Assert.assertTrue(true);
			logger.info("User navigated back to user information form" +"\n");
			
		}
		else {
			Assert.assertTrue(false);
			logger.info("Back button functionality not working" +"\n");
		}
		
	}
	
	@Test(priority=3)
	public void testCancelButton()
	{
		CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(driver);
		boolean isBtnCancelClickable = ac.btnCancelClickableDisplayed();
		if(isBtnCancelClickable)
		{
			Assert.assertTrue(true);
			logger.info("Cancel button is displayed and clickable");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Cancel button is missing");
		}
		
		ac.clickCancelBtn();
		logger.info("Cancel button clicked");
		if(driver.getTitle().equals("Park IQ Admin"))
		{
			Assert.assertTrue(true);
			logger.info("User navigated back to super user portal page" +"\n");
			
		}
		else {
			Assert.assertTrue(false);
			logger.info("Cancel button functionality not working" +"\n");
		}
		
	}
	
	@Test(priority=3)
	public void testContButton()
	{
		CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(driver);
		boolean isBtnContClickable = ac.btnContClickableDisplayed();
		if(isBtnContClickable)
		{
			Assert.assertTrue(true);
			logger.info("Continue button is displayed and clickable " +  "Expected color:#686868,Actual background Color:" + ac.btnContinueBgColour());
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Continue button is missing");
		}
		
		//test enabling and disabling of continue button
		boolean isSelected = ac.locateCheckBox();
		//performs click operation if element is not checked
		if (isSelected ==false)
		{
			ac.clickCheckBox(); //this clicks on the customer name checkbox
			logger.info("Checks if checkbox is clicked or not. If not, then it clicks on one");
		}
		else 
		{
			logger.info("Checkbox already selected");
		}
		
		//performs click on continue button when enabled after clicking checkbox
		boolean isEnabled = ac.btnContClickableDisplayed();
		if (isEnabled ==true)
		{
			ac.clickContBtn2();
		}
		else {
			logger.info("Continue button is disabled");
		}
		
		logger.info("Continue button clicked");
		if(driver.getTitle().equals("Park IQ Admin"))
		{
			Assert.assertTrue(true);
			logger.info("User moves onto Select Role form" +"\n");
			
		}
		else {
			Assert.assertTrue(false);
			logger.info("Continue button functionality not working" +"\n");
		}
		
	}

}
