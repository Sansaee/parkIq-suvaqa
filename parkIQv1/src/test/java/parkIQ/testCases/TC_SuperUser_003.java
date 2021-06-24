package parkIQ.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import parkIQ.common.CommonFunctions;
import parkIQ.pageObjects.CreateNewUser_AssignCustomersToUserProfilePage;
import parkIQ.pageObjects.CreateNewUser_RolesAndPermissionsPage;
import parkIQ.pageObjects.CreateNewUser_UserInformationPage;
import parkIQ.pageObjects.LoginPage;
import parkIQ.pageObjects.OperationModePrompt;
import parkIQ.pageObjects.SuperUserPortalPage;

public class TC_SuperUser_003 extends BaseClass {
	//Test Case for assigning customer to user profile

	//Test that Setup is Successful
	@Test(priority = 0)
	public void setupSuperUserRole() throws InterruptedException {
		CommonFunctions cf = new CommonFunctions();

		//Login and navigate to Super User Page
		cf.navigateToSuperUserPage();

		//verify page is redirected to Super User Form
		if (driver.getTitle().equals("Park IQ Admin")) {
			Assert.assertTrue(true);
			logger.info("User navigated to super user role form" + "\n");

		} else {
			Assert.assertTrue(false);
			logger.info("Super user form test failed" + "\n");
		}
	}

	//Test if Form Title and Description is Displayed
	@Test(priority = 1)
	public void validateTitle_content() {
		SuperUserPortalPage sup = new SuperUserPortalPage(driver);
		CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
		CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(
				driver);
		sup.clickCreateUserLink();
		uip.setFirstName(name);
		uip.setLastName(lname);
		uip.setEmail(email);
		uip.setPhoneNumber(validPhone);
		uip.clickContinue();

		boolean title = ac.verifyFormTitle();
		boolean description = ac.verifyFormDescription();

		//Verify if Page Title and Page Desctiption is Displayed
		if (title && description) {
			Assert.assertTrue(true);
			logger.info("User navigated to assigning customers form" + "\n");
			logger.info("Assign Customers to User Profile title is displayed correctly");
			logger.info("Form Description displayed correctly");
		} else {
			Assert.assertTrue(false);
			logger.info("Assigning customers form test failed" + "\n");
			logger.info("Assign Customers to User Profile title is missing");
			logger.info("Form Description is missing");
		}

	}

	//Test if columns Customer Name and Machines are displayed
	@Test(priority = 2)
	public void testColumns() {
		CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(
				driver);
		boolean column = ac.locateColumnHeaders();

		if (column == true) {
			logger.info("Displays column headers correctly");
		} else {
			logger.info("Column headers are not displayed correctly");
		}
	}

	//Test if Back Button is Clickable
	@Test(priority = 3)
	public void testBackButtonClickable() {
		CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(
				driver);
		boolean isBtnBackClickable = ac.btnBackClickableDisplayed();
		if (isBtnBackClickable) {
			Assert.assertTrue(true);
			logger.info("Back button is displayed and clickable");
		} else {
			Assert.assertTrue(false);
			logger.info("Back button is missing");
		}

	}

	@Test(priority = 4)
	public void testBackButtonClickFunctionality() {
		CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(
				driver);
		CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
		ac.clickBackBtn();
		logger.info("Back button clicked");

		boolean isTitleDisplayed = uip.verifyPageTitle();
		//if user information form title is displayed
		if (isTitleDisplayed) {
			Assert.assertTrue(true);
			logger.info("User navigated back to user information form" + "\n");

		} else {
			Assert.assertTrue(false);
			logger.info("Back button functionality not working" + "\n");
		}

	}

	@Test(priority = 5)
	public void testCancelButtonClickable() {
		CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(
				driver);
		CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);

		uip.clickContinue();

		boolean isBtnCancelClickable = ac.btnCancelClickableDisplayed();

		if (isBtnCancelClickable) {
			Assert.assertTrue(true);
			logger.info("Cancel button is displayed and clickable");
		} else {
			Assert.assertTrue(false);
			logger.info("Cancel button is missing");
		}
	}

	@Test(priority=6)
	public void testCancelButtonClickFunctionality()
	{
		CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(driver);
		SuperUserPortalPage sup = new SuperUserPortalPage(driver);

		ac.clickCancelBtn();
		logger.info("Cancel button clicked");

		boolean isTitleDisplayed = sup.locateTitle();
		//if Super User Portal Page Title is displayed
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

	@Test(priority = 7)
	public void testContinueButtonClickable() {

		SuperUserPortalPage sup = new SuperUserPortalPage(driver);
		CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
		CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(
				driver);

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


		boolean isBtnContinueClickable = ac.btnContClickableDisplayed();
		boolean isBtnContinueDisplayed = ac.btnContDisplayed();

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

	@Test(priority = 8)
	public void testContinueButtonEnabled() {

		CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(driver);

		ac.clickCheckBox();

		int isChecked = ac.isChecked();
		boolean isBtnClickable = ac.btnContClickableDisplayed();

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

		CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(driver);
		CreateNewUser_RolesAndPermissionsPage rap = new CreateNewUser_RolesAndPermissionsPage(driver);

		int isChecked = ac.isChecked();

		//If no checkbox is selected
		if(isChecked == 0)
		{
			ac.clickCheckBox();
			logger.info("Selected Check Box Customer Name");
		}

		ac.clickContinueBtn();
		logger.info("Clicked Continue Button");

		boolean isTitleDisplayed = rap.verifyFormTitle();

		if(isTitleDisplayed)
		{
			Assert.assertTrue(true);
			logger.info("Continue Button Functions as Expected... redirects to 'Roles and Permissions Form'");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Continue Button is Faulty");
		}
	}
}
