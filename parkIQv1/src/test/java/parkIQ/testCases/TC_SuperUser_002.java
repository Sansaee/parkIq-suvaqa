package parkIQ.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import parkIQ.common.CommonFunctions;
import parkIQ.pageObjects.CreateNewUser_AssignCustomersToUserProfilePage;
import parkIQ.pageObjects.CreateNewUser_UserInformationPage;
import parkIQ.pageObjects.LoginPage;
import parkIQ.pageObjects.OperationModePrompt;
import parkIQ.pageObjects.SuperUserPortalPage;


public class TC_SuperUser_002 extends BaseClass {
	//Test Case for creating new user in super user role
	
		@Test (priority=0)
		public void testCreateNewUserLink()
		{
			//Tests if create user link redirects to Create New User Form when link is clicked (Verify by locating Page Header)
			SuperUserPortalPage sup = new SuperUserPortalPage(driver);
			CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);

			logger.info("SUPER USER ROLE TEST CASES - CREATE NEW USERS");
			
			CommonFunctions cf = new CommonFunctions();

			//Login and navigate to Super User Page
			cf.navigateToSuperUserPage();

			sup.clickCreateUserLink();

			logger.info("Create New User link clicked, redirecting to User Information Page");


			boolean isPageHeader = uip.verifyHeader();
			if (isPageHeader) {
				Assert.assertTrue(true);
				logger.info("Create New User Form is Open");
				logger.info("Page Header 'User Information' is displayed");

			} else {
				Assert.assertTrue(false);
				logger.info("Failed to Open Create New User Form");
				logger.info("Page Header 'User Information' is missing");
			}
		}

		//Tests if Page Title "Create New User" is Displayed
		@Test (priority = 1)
		public void testPageTitleDisplayed()
		{
			CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);

			boolean isTitle = uip.verifyPageTitle();

			if(isTitle)
			{
				Assert.assertTrue(true);
				logger.info("Page Title 'Create New User' is displayed correctly");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Page Title 'Create New User' is missing");
			}
		}

		//Tests if Form Title "Create New User" is Displayed
		@Test (priority = 2)
		public void testFormTitleDisplayed()
		{
			CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
			boolean isFormTitle = uip.verifyFormTitle();

			if(isFormTitle)
			{
				Assert.assertTrue(true);
				logger.info("Form Title 'User Information' is displayed");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Form Title 'User Information' is missing");
			}
		}

		//Tests if First Name Field is Displayed and Clickable
		@Test (priority = 3)
		public void testFirstNameFieldDiplayedClickable()
		{
			CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
			boolean isFnameClickable = uip.firstNameClickable();

			if(isFnameClickable)
			{
				Assert.assertTrue(true);
				logger.info("First Name Text Field is Displayed and is Clickable");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("First Name Text Field doesn't exist");
			}
		}


		//Tests if Last Name Field is Displayed and Clickable
		@Test (priority = 4)
		public void testLastNameFieldDiplayedClickable()
		{
			CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
			boolean isLnameClickable = uip.lastNameClickable();
			if(isLnameClickable)
			{
				Assert.assertTrue(true);
				logger.info("Last Name Text Field is Displayed and is Clickable");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("First Name Text Field doesn't exist");
			}
		}

		//Tests if Email Field is Displayed and Clickable
		@Test (priority = 5)
		public void testEmailFieldDiplayedClickable()
		{
			CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
			boolean isEmailClickable = uip.emailClickable();
			if(isEmailClickable)
			{
				Assert.assertTrue(true);
				logger.info("Email Text Field is Displayed and is Clickable");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Email Text Field doesn't exist");
			}
		}

		//Tests if Valid Email is accepted
		@Test (priority = 6)
		public void testValidEmailAccepted()
		{
			CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
			boolean isValidationMessage = uip.setEmail(email);
			logger.info("Entered vaild email: '" + email + "'");

			if(!isValidationMessage)
			{
				Assert.assertTrue(true);
				logger.info("Email '" + email + "' is accepted as a valid email");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Email validation is faulty");
			}
		}

		//Tests if Invalid Email produces a validation message
		@Test (priority = 7)
		public void testInvalidEmailProducesValidationMessage()
		{
			CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
			boolean isvalidationMessage = uip.setEmail(invalidEmail);
			System.out.print("Validation Message: " + isvalidationMessage);
			logger.info("Entered invalid email: '" + invalidEmail + "'");

			if(isvalidationMessage)
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

		//Tests if Phone Field is Displayed and Clickable
		@Test (priority = 8)
		public void testPhoneFieldDiplayedClickable()
		{
			CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
			boolean isPhoneClickable = uip.phoneClickable();
			if(isPhoneClickable)
			{
				Assert.assertTrue(true);
				logger.info("Phone Number  is Displayed and is Clickable");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Phone Text Field doesn't exist");
			}
		}

		//Tests if Valid Phone Number is Accepted
		@Test (priority = 9)
		public void testValidPhoneAccepted()
		{
			CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
			boolean isValidationMessage = uip.setPhoneNumber(validPhone);
			logger.info("Entered Valid Phone Number: '" + validPhone + "'");
			if(!isValidationMessage) //if validation message doesn't appear "if(validationMessage == false)"
			{
				Assert.assertTrue(true);
				logger.info("Phone number '" + validPhone + "' is a valid number");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Phone Number validation is faulty");
			}
		}

		//Tests if Invalid Phone Number produces a validation message
		@Test (priority = 10)
		public void testInvalidPhoneProducesValidationMessage()
		{
			CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
			boolean isValidationMessage = uip.setPhoneNumber(invalidPhone);
			logger.info("Entered Invalid Phone Number: '" + invalidPhone + "'");
			if(isValidationMessage)
			{
				Assert.assertTrue(true);
				logger.info("Phone number '" + invalidPhone + "' is an invalid number");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Phone Number validation is faulty ");
			}
		}

		//Tests if Cancel Button is Displayed and Clickable
		@Test (priority = 11)
		public void testCancelButtonDiplayedClickable()
		{
			CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
			boolean isBtnCancelClickable = uip.btnCancelClickable();
			if(isBtnCancelClickable)
			{
				Assert.assertTrue(true);
				logger.info("Cancel Button is Displayed and is Clickable");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Cancel Button doesn't exist");
			}
		}

		//Tests if Continue Button is Displayed and Clickable
		@Test (priority = 12)
		public void testContinueButtonDiplayedClickable()
		{
			CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
			boolean isBtnContinueClickable = uip.btnContinueClickable();
			boolean isBtnContinueDisplayed = uip.btnContinueDisplayed();
			System.out.print("Continue Button Background Color: " + uip.btnContinueBgColour() + "\n");
			if(isBtnContinueDisplayed)
			{
				if(isBtnContinueClickable)
				{
					Assert.assertTrue(true);
					logger.info("Continue Button is Displayed and is Clickable");
				}
				else
				{
					Assert.assertFalse(false);
					logger.info("Continue Button is Displayed but is Disabled. Please Fill in Fields");
				}
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Continue Button doesn't exist");
			}
		}

		//Tests if Continue Button Background Colour is:#686868
		@Test (priority = 13)
		public void testContinueButtonBackgroundColour()
		{
			CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
			String backgroundColour = uip.btnContinueBgColour();
			if(backgroundColour.equals("#686868"))
			{
				Assert.assertTrue(true);
				logger.info("Continue Button Background Colour is: '" + backgroundColour + "'");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Continue Button doesn't exist");
			}
		}

		//Test that page is redirected to User Forms when Cancel Button is Clicked
		@Test (priority = 14)
		public void testCancelButtonFunctionality()
		{
			CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
			SuperUserPortalPage sup = new SuperUserPortalPage(driver);
			uip.clickCancel();
			logger.info("Cancel Button Clicked");


			boolean isUserFormTitle = sup.locateTitle();

			if(isUserFormTitle)
			{
				Assert.assertTrue(true);
				logger.info("Cancel Button Functions as Expected... redirects back to 'Users Form'");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Cancel Button Not Working");
			}
		}

		//Test Continue Button is Enabled When Valid First Name, Last Name, Email & Phone is Entered
		@Test (priority = 15)
		public void testContinueButtonIsEnabledWhenFieldsAreFilled()
		{
			CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
			SuperUserPortalPage sup = new SuperUserPortalPage(driver);

			sup.clickCreateUserLink();


			logger.info("Create New User link clicked, redirecting to User Information Page");


			uip.setFirstName(name);
			logger.info("Entered First Name: '" + name + "'");

			uip.setLastName(lname);
			logger.info("Entered Last Name: '" + lname + "'");

			//Fill email if invalid email is entered validation message is displayed and isEmailValidationMessage = true
			boolean isEmailValidationMessage = uip.setEmail(email);
			logger.info("Entered Email: '" + email + "'");

			//Fill phone if invalid phone is entered validation message is displayed and isPhoneValidationMessage = true
			boolean isPhoneValidationMessage = uip.setPhoneNumber(validPhone);
			logger.info("Entered Phone Number: '" + validPhone + "'");

			boolean isContinueButtonEnabled = uip.btnContinueClickable();

			if(!isEmailValidationMessage && !isPhoneValidationMessage && isContinueButtonEnabled)
			{
				Assert.assertTrue(true);
				logger.info("Continue Button is enabled and is clickable");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Continue Button doesn't exist");
			}
		}

		//Test that page is redirected to Assign Customers to User Profile when Continue Button is Clicked
		@Test (priority = 16)
		public void testContinueButtonFunctionality()
		{
			CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
			CreateNewUser_AssignCustomersToUserProfilePage assignCus = new CreateNewUser_AssignCustomersToUserProfilePage(driver);

			uip.clickContinue();
			logger.info("Continue Button clicked");

			boolean isFormTitle = assignCus.verifyFormTitle();
			if(isFormTitle)
			{
				Assert.assertTrue(true);
				logger.info("Continue Button Functions as Expected... redirects to 'Assign Customers To User Profile Form'");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Continue Button Not Working");
			}
		}


}
