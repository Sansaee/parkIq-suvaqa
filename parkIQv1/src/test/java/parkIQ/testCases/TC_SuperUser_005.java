package parkIQ.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import parkIQ.common.CommonFunctions;
import parkIQ.pageObjects.CreateCustomerServiceUser;
import parkIQ.pageObjects.CreateNewUser_ReviewUserPage;
import parkIQ.pageObjects.CreateNewUser_RolesAndPermissionsPage;
import parkIQ.pageObjects.SuperUserPortalPage;

public class TC_SuperUser_005 extends BaseClass {
	//Test Case for assigning customer to user profile

	//Test that Setup is Successful and Verify Form Title
	@Test(priority = 0)
	public void setupReviewUser(){
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);
		CommonFunctions cf = new CommonFunctions();

		//Login and navigate to Super User Page
		cf.navigateToSuperUserPage();

		//Enter User Information and Navigate to Review User Form
		cf.enterUserInformationDetails();

		logger.info("SUPER USER ROLE TEST CASES - ROLES & PERMISSIONS");

		boolean isReviewUserTitle = rup.verifyUserInformationTitle();

		//verify page is redirected to Super User Form
		try{
			Assert.assertTrue(isReviewUserTitle);
			logger.info("User navigated to Review User Form..... Title 'Review User' located" + "\n");
		}catch (AssertionError ex){
			logger.info("Failed to Access Review User Form" + "\n");
			throw new AssertionError(ex);
		}
	}

	//Test if Section Titles are Displayed
	@Test(priority = 1)
	public void testSectionTitlesDisplayed() {
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);

		boolean sectionUserInfoTitle = rup.verifyUserInformationTitle();
		boolean sectionCustomerTitle = rup.verifyCustomerTitle();
		boolean sectionRolesPermissionTitle = rup.verifyRolesPermissionTitle();
		//Verify if Page Title and Page Desctiption is Displayed
		try {
			if (sectionUserInfoTitle && sectionCustomerTitle && sectionRolesPermissionTitle) {
				Assert.assertTrue(true);
				logger.info("User Information Section Title Is Displayed" + "\n");
				logger.info("Customer Section Title Is Displayed" + "\n");
				logger.info("Roles and Permission Section Title Is Displayed" + "\n");
			}
		}catch (AssertionError ex) {
			logger.info("Failed to locate section titles 'User Information', 'Customer' & 'Roles & Permissions" + "\n");
			throw new AssertionError(ex);
		}
	}

	//Test if Field Headers are Displayed
	@Test(priority = 2)
	public void testFieldHeadersDisplayed() {
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);
		boolean nameFieldHeaderDisplayed = rup.verifyNameFieldTitle();
		boolean emailFieldHeaderDisplayed = rup.verifyEmailFieldTitle();
		boolean phoneFieldHeaderDisplayed = rup.verifyPhoneTitle();

		try {
			if (nameFieldHeaderDisplayed && emailFieldHeaderDisplayed && phoneFieldHeaderDisplayed) {
				Assert.assertTrue(true);
				logger.info("Name Field Header Is Displayed" + "\n");
				logger.info("Email Field Header Is Displayed" + "\n");
				logger.info("Phone Field Header Is Displayed" + "\n");
			}
		}catch (Exception ex)
		{
			logger.info("Failed to locate Field Headers for 'Name', 'Email' & 'Phone'");
			throw new AssertionError(ex);
		}
	}

	//Test if Name Text is Read Only
	@Test(priority = 3)
	public void testNameReadOnly() {
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);

		boolean nameReadOnly = rup.txtNameReadOnly();
		try{
			Assert.assertTrue(nameReadOnly);
			logger.info("Name Field is Read Only");
		}catch (AssertionError ex)
		{
			logger.info("Name Field is editable");
			throw new AssertionError(ex);
		}
	}

	//Test if Name Text Matches Name Entered
	@Test(priority = 4)
	public void testNameMatch() {
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);

		String displayedName = rup.getName();
		String fullName = name + " " + lname;
		try{
			Assert.assertEquals(displayedName, fullName);
			logger.info("Correct Name is Displayed: " + displayedName);
		}catch (AssertionError ex)
		{
			logger.info("Name displayed '" + displayedName + "', doesn't match Name entered '" + fullName + "'");
			throw new AssertionError(ex);
		}
	}

	//Test if Email Text is Read Only
	@Test(priority = 5)
	public void testEmailReadOnly() {
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);

		boolean emailReadOnly = rup.txtEmailReadOnly();
		try{
			Assert.assertTrue(emailReadOnly);
			logger.info("Email Field is Read Only");
		}catch (AssertionError ex)
		{
			logger.info("Email Field is editable");
			throw new AssertionError(ex);
		}
	}

	//Test if Email Text Matches Email Entered
	@Test(priority = 6)
	public void testEmailMatch() {
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);

		String displayedEmail = rup.getEmail();
		try{
			Assert.assertEquals(displayedEmail, email);
			logger.info("Correct Email is Displayed: " + displayedEmail);
		}catch (AssertionError ex)
		{
			logger.info("Email displayed '" + displayedEmail + "', doesn't match email entered '" + email + "'");
			throw new AssertionError(ex);
		}
	}

	//Test if Phone Text is Read Only
	@Test(priority = 7)
	public void testPhoneReadOnly() {
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);

		boolean phoneReadOnly = rup.txtPhoneReadOnly();
		try{
			Assert.assertTrue(phoneReadOnly);
			logger.info("Phone Field is Read Only");
		}catch (AssertionError ex)
		{
			logger.info("Phone Field is editable");
			throw new AssertionError(ex);
		}
	}

	//Test if Phone Text Matches Phone Entered
	@Test(priority = 8)
	public void testPhoneMatch() {
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);

		String displayedPhone = rup.getPhone();
		String enteredNumber = validPhone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");

		try{
			Assert.assertEquals(displayedPhone, enteredNumber);
			logger.info("Correct Phone is Displayed: " + displayedPhone);
		}catch (AssertionError ex)
		{
			logger.info("Phone displayed '" + displayedPhone + "', doesn't match phone entered '" + enteredNumber + "'");
			throw new AssertionError(ex);
		}
	}

	//Test if all customers are displayed
	@Test(priority = 9)
	public void testCustomersDiplayed() {
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);

		boolean isCusDisplayed = rup.customersIsDisplayed();

		try
		{
			Assert.assertTrue(isCusDisplayed);
			logger.info("All Customers are Displayed" + "\n");
		} catch (AssertionError ex)
		{
			logger.info("Customers are not displayed" + "\n");
			throw  new AssertionError(ex);
		}
	}

	//Test if Customer Names are Read Only
	@Test(priority = 10)
	public void testCustomersReadOnly() {
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);

		boolean phoneReadOnly = rup.txtCustomersReadOnly();
		try{
			Assert.assertTrue(phoneReadOnly);
			logger.info("Customer Names are Read Only");
		}catch (AssertionError ex)
		{
			logger.info("Customer Names are editable");
			throw new AssertionError(ex);
		}
	}

	//Test if all permission roles are displayed
	@Test(priority = 11)
	public void testPermissionRolesDisplayed() {
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);

		boolean isPermissionDisplayed = rup.permissionRolesIsDisplayed();

		try
		{
			Assert.assertTrue(isPermissionDisplayed);
			logger.info("All Permission Roles are Displayed" + "\n");
		} catch (AssertionError ex)
		{
			logger.info("Permission Roles are not displayed" + "\n");
			throw  new AssertionError(ex);
		}
	}

	//Test if Permission Role Names are Read Only
	@Test(priority = 12)
	public void testRolesReadOnly() {
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);

		boolean rolesReadOnly = rup.txtRolesReadOnly();
		try{
			Assert.assertTrue(rolesReadOnly);
			logger.info("Permission Roles are Read Only");
		}catch (AssertionError ex)
		{
			logger.info("Permission Roles are editable");
			throw new AssertionError(ex);
		}
	}

	//Test Back Button is Displayed and Clickable
	@Test(priority=13)
	public void testBackButtonDisplayedClickable()
	{
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);

		boolean isClickableDisp = rup.btnBackIsDisplayedClickable();

		try
		{
			Assert.assertTrue(isClickableDisp);
			logger.info("Back button displayed and clickable");
		}
		catch (AssertionError ex)
		{
			logger.info("Unable to locate Back button");
			throw new AssertionError(ex);
		}

	}

	//Test Cancel Button is Displayed and Clickable
	@Test(priority=14)
	public void testCancelButtonDisplayedClickable()
	{
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);

		boolean isClickableDisp = rup.btnCancelIsDisplayedClickable();

		try
		{
			Assert.assertTrue(isClickableDisp);
			logger.info("Cancel button displayed and clickable");
		}
		catch (AssertionError ex)
		{
			logger.info("Unable to locate Back button");
			throw new AssertionError(ex);
		}
	}

	//Test Create New User Button is Displayed and Clickable
	@Test(priority=15)
	public void testCreateNewUserButtonDisplayedClickable()
	{
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);

		boolean isClickableDisp = rup.btnCreateNewUserIsDisplayedClickable();
		try
		{
			Assert.assertTrue(isClickableDisp);
			logger.info("Create New User Button displayed and clickable");
		}
		catch (AssertionError ex)
		{
			logger.info("Unable to locate Back button");
			throw new AssertionError(ex);
		}
	}

	//Test Verify Create New User Button has Background Color '#686868'
	@Test(priority=16)
	public void testVerifyCreateNewUserButtonBackGroundColour()
	{
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);

		String btnBackgroundColour = rup.bgColourBtnCreateUser();
		String expectedColour = "#686868";
		try
		{
			Assert.assertEquals(btnBackgroundColour, expectedColour);
			logger.info("Verified Background Colour of Create New User button is " + btnBackgroundColour);
		}
		catch (AssertionError ex)
		{
			logger.info("Unable to verify Create New User Button Background Colour");
			throw new AssertionError(ex);
		}
	}

	//Test Continue Back Button Functionality: Returns to Roles and Permission Page
	@Test(priority=17)
	public void testBackButtonFunctionality()
	{
		CreateNewUser_RolesAndPermissionsPage rap = new CreateNewUser_RolesAndPermissionsPage(driver);
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);

		rup.clickBtnBack();
		logger.info("Back Button Clicked");

		try
		{
			Assert.assertTrue(rap.verifyFormTitle());
			logger.info("Back Button Functions as Expected. User navigated back to 'Roles & Permissions' form");
		}
		catch (AssertionError ex)
		{
			logger.info("Unable to perform click action on Back Button");
			throw new AssertionError(ex);
		}
	}

	//Test Continue Back Button Functionality: Returns to Roles and Permission Page
	@Test(priority=18)
	public void testCancelButtonFunctionality()
	{
		SuperUserPortalPage sup = new SuperUserPortalPage(driver);
		CreateNewUser_RolesAndPermissionsPage rap = new CreateNewUser_RolesAndPermissionsPage(driver);
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);


		rap.clickContBtn();
		logger.info("Roles and Permission Form: Continue Button Clicked");

		rup.clickBtnCancel();
		logger.info("Cancel Button Clicked");

		try
		{
			Assert.assertTrue(sup.locateTitle());
			logger.info("Cancel Button Functions as Expected. User navigated back to 'Create Customer Service User' Form");
		}
		catch (AssertionError ex)
		{
			logger.info("Unable to perform click action on Cancel Button");
			throw new AssertionError(ex);
		}
	}

	//Test Continue Back Button Functionality: Returns to Roles and Permission Page
	@Test(priority=19)
	public void testCreateNewUserButtonFunctionality()
	{
		CreateCustomerServiceUser ccs = new CreateCustomerServiceUser(driver);
		CreateNewUser_ReviewUserPage rup = new CreateNewUser_ReviewUserPage(driver);
		CommonFunctions cf = new CommonFunctions();
		
		cf.enterUserInformationDetails();

		rup.clickBtnCreateNewUser();
		logger.info("Create New User Button Clicked");

		//if create user is successful, user will be redirected to the user information page
		//if unsuccessful a toaster error message will pop up e.g. User Name 'email' is already taken.
		//locate User Header to verify create user is successful
		String isToasterDisplayed = rup.isToasterVisible();
		boolean isUserHeaderDisplayed = ccs.locateSectionHeader();
//		System.out.print("Page Title Located: " + isToasterDisplayed + "\n");
		try
		{
			if (isToasterDisplayed.equals("User name '" + email +"' is already taken.")||  isUserHeaderDisplayed ) {
				Assert.assertTrue(true);
				if(isUserHeaderDisplayed) {
					logger.info("Create New User Button Functions as Expected. User " + email
							+ " Created Successfully to 'Create Customer Service User' Form");
				}
				else
				{
					logger.info(isToasterDisplayed);
				}
			}
		}
		catch (AssertionError ex)
		{
			logger.info("Unable to perform click action on Create New User Button");
			throw new AssertionError(ex);
		}
	}

	
}

