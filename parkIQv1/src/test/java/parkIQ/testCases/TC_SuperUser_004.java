package parkIQ.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import parkIQ.common.CommonFunctions;
import parkIQ.pageObjects.CreateNewUser_AssignCustomersToUserProfilePage;
import parkIQ.pageObjects.CreateNewUser_ReviewUserPage;
import parkIQ.pageObjects.CreateNewUser_RolesAndPermissionsPage;
import parkIQ.pageObjects.CreateNewUser_UserInformationPage;
import parkIQ.pageObjects.SuperUserPortalPage;

public class TC_SuperUser_004 extends BaseClass {
	//Test case for role & permissions 
	
	@Test(priority = 0)
	public void assignRoleAndPermission()
	{
		CommonFunctions cf = new CommonFunctions();

		//Login and navigate to Super User Page
		cf.navigateToSuperUserPage();
		
		if(driver.getTitle().equals("Park IQ Admin"))
		{
			Assert.assertTrue(true);
			logger.info("User navigated to super user role form" +"\n");
			
		}
		else {
			Assert.assertTrue(false);
			logger.info("Super user form test failed" +"\n");
		}
		
	}
	
	//Tests if form title is displayed
	@Test (priority =1)
	public void testFormTitle()
	{
		logger.info("SUPER USER ROLE TEST CASES - ROLES & PERMISSIONS");
		
		SuperUserPortalPage sup = new SuperUserPortalPage(driver);
		CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
		CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(
				driver);
		CreateNewUser_RolesAndPermissionsPage rpp = new CreateNewUser_RolesAndPermissionsPage(driver);
		
		sup.clickCreateUserLink();

		uip.setFirstName(name);
		uip.setLastName(lname);
		uip.setEmail(email);
		uip.setPhoneNumber(validPhone);
		uip.clickContinue();

		int checkedCount = 0;
		while(checkedCount == 0)
		{
			ac.clickCheckBox();
			checkedCount = ac.isChecked();
		}
		ac.clickContinueBtn();
		
		boolean title = rpp.verifyFormTitle();
		boolean description = rpp.verifyFormDescription();
		
		//Verify if Page Title and Page Desctiption is Displayed
		if (title && description) {
			Assert.assertTrue(true);
			logger.info("User navigated to roles and permissions form" + "\n");
			logger.info("Roles and Permissions title is displayed correctly");
			logger.info("Form Description displayed correctly");
		} else {
			Assert.assertTrue(false);
			logger.info("Roles and Permissions form test failed" + "\n");
			logger.info("Roles and Permissions title is missing");
			logger.info("Form Description is missing");
		}
	}
	
	//Test if checkboxes are displayed
	@Test(priority =2)
	public void testCheckboxes()
	{
		CreateNewUser_RolesAndPermissionsPage rpp = new CreateNewUser_RolesAndPermissionsPage(driver);
		
		boolean checkbox1 = rpp.locateCSCheckBox();
		boolean checkbox2 = rpp.locateINSCheckBox();
		boolean checkbox3 = rpp.locateSUCheckBox();
		if(checkbox1 && checkbox2 && checkbox3)
		{
			Assert.assertTrue(true);
			logger.info("Displays checkbox correctly");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Checkbox are not displayed correcly");
		}
	}
	
	//Test if back button is clickable
	@Test(priority = 3)
	public void testBackButtonClickable() 
	{
		CreateNewUser_RolesAndPermissionsPage rpp = new CreateNewUser_RolesAndPermissionsPage(driver);
		
		boolean btnBackClickable = rpp.btnBackClickableDisplayed();
		if (btnBackClickable) 
		{
			Assert.assertTrue(true);
			logger.info("Back button is displayed and clickable");
		} 
		else 
		{
			Assert.assertTrue(false);
			logger.info("Back button is missing");
		}
	}
	
	//Test if user is returned to �Assign Customers� form when back button is clicked
	@Test(priority = 4)
	public void testBackButtonClickFunctionality() 
	{
		CreateNewUser_RolesAndPermissionsPage rpp = new CreateNewUser_RolesAndPermissionsPage(driver);
		CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(
				driver);
		
		rpp.clickBackBtn();
		logger.info("Back button is clicked");
		
		boolean isTitleDisplayed = ac.verifyFormTitle();
		if (isTitleDisplayed) {
			Assert.assertTrue(true);
			logger.info("User navigated back to assign customers form" + "\n");

		} else {
			Assert.assertTrue(false);
			logger.info("Back button functionality not working" + "\n");
		}
	}
	
	//Test if cancel button is clickable
	@Test(priority = 5)
	public void testCancelButtonClickable()
	{
		CreateNewUser_AssignCustomersToUserProfilePage ap = new CreateNewUser_AssignCustomersToUserProfilePage(driver);
		CreateNewUser_RolesAndPermissionsPage rpp = new CreateNewUser_RolesAndPermissionsPage(driver);

		ap.clickContinueBtn();
		logger.info("User navigated to Roles and Permission Page" + "\n");
		
		boolean btnCancelClickable = rpp.btnCancelClickableDisplayed();
		System.out.print("Cancel Button isClickable: " + btnCancelClickable + "\n");
		if (btnCancelClickable) 
		{
			Assert.assertTrue(true);
			logger.info("Cancel button is displayed and clickable");
		} 
		else 
		{
			Assert.assertTrue(false);
			logger.info("Cancel button is missing");
		}
	}
	
	//Test if user is returned to �Users� Form when cancel is clicked
	@Test(priority=6)
	public void testCancelButtonClickFunctionality()
	{
		CreateNewUser_RolesAndPermissionsPage rpp = new CreateNewUser_RolesAndPermissionsPage(driver);
		SuperUserPortalPage sup = new SuperUserPortalPage(driver);
		
		rpp.clickCancelBtn();
		logger.info("Cancel button clicked");
		
		boolean isTitleDisplayed = sup.locateTitle();
		if(isTitleDisplayed)
		{
			Assert.assertTrue(true);
			logger.info("User navigated back to super user portal page" +"\n");

		}
		else {
			Assert.assertTrue(false);
			logger.info("Cancel button functionality not working" +"\n");
		}
	}
	
	//Test if continue button is clickable and displayed
	@Test(priority = 7)
	public void testContinueButtonClickable() {

		SuperUserPortalPage sup = new SuperUserPortalPage(driver);
		CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
		CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(
				driver);
		CreateNewUser_RolesAndPermissionsPage rpp = new CreateNewUser_RolesAndPermissionsPage(driver);


		sup.clickCreateUserLink();
		logger.info("Create User Link Clicked");

		logger.info("User Information Form Displayed");

		uip.setFirstName(name);
		logger.info("First Name Entered");

		uip.setLastName(lname);
		logger.info("Last Name Entered");

		uip.setEmail(email);
		logger.info("Email Entered");

		uip.setPhoneNumber(validPhone);
		logger.info("Phone Number Entered");

		uip.clickContinue();
		logger.info("Continue Button Clicked");
		
		ac.clickCheckBox();
		logger.info("Checkbox is selected");
		
		ac.clickContinueBtn();
		logger.info("Continue Button Clicked");


		boolean  isBtnContinueDisplayed= rpp.btnContDisplayed();
		boolean  isBtnContinueClickable= rpp.btnContClickableDisplayed();

		if (isBtnContinueDisplayed) {
			if (isBtnContinueClickable) {
				Assert.assertTrue(true);
				logger.info("Continue Button is Displayed and is Clickable");
			} else {
				int countChecked = ac.isChecked();
				if(countChecked == 0) {
					Assert.assertFalse(false);
					logger.info("Continue Button is Displayed but is not clickable. Please Select a Checkbox");
				} else {
					Assert.assertTrue(false);
					logger.info("Continue Button is not accessible");
				}

			}
		} else {
			Assert.assertTrue(false);
			logger.info("Continue Button doesn't exist");
		}

	}
	
	//Test if continue button is enabled
	@Test(priority = 8)
	public void testContinueButtonEnabled() {

		CreateNewUser_RolesAndPermissionsPage rpp = new CreateNewUser_RolesAndPermissionsPage(driver);

		rpp.clickCheckBox();

		int isChecked = rpp.isChecked();
		boolean isBtnClickable = rpp.btnContClickableDisplayed();

		if(isChecked > 0 && isBtnClickable)
		{
				Assert.assertTrue(true);
				logger.info("Continue Button is Enabled");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Continue Button doesn't exist");
		}
	}
	
	@Test(priority = 9)
	public void testContinueButtonFunctionality() {

		CreateNewUser_RolesAndPermissionsPage rpp = new CreateNewUser_RolesAndPermissionsPage(driver);
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);
		
		int isChecked = rpp.isChecked();

		//If no checkbox is selected
		if(isChecked == 0)
		{
			rpp.clickCheckBox();
			logger.info("Select roles and permissions");
		}

		rpp.clickContBtn();
		logger.info("Clicked Continue Button");

		boolean isTitleDisplayed = rup.verifyFormTitle();

		if(isTitleDisplayed)
		{
			Assert.assertTrue(true);
			logger.info("Continue Button Functions as Expected... redirects to 'Review User Form'");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Continue Button is Faulty");
		}
	}

}
