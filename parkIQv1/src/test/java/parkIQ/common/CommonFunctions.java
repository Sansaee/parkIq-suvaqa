package parkIQ.common;

import parkIQ.pageObjects.CreateNewUser_AssignCustomersToUserProfilePage;
import parkIQ.pageObjects.CreateNewUser_RolesAndPermissionsPage;
import parkIQ.pageObjects.CreateNewUser_UserInformationPage;
import parkIQ.pageObjects.LoginPage;
import parkIQ.pageObjects.OperationModePrompt;
import parkIQ.pageObjects.SuperUserPortalPage;
import parkIQ.testCases.BaseClass;

public class CommonFunctions extends BaseClass{
	
	//SUPER USER ROLE COMMON FUNCTIONS
	
	//Navigation Functions
			public void navigateToSuperUserPage()
			{
				LoginPage lp= new LoginPage(driver);
				OperationModePrompt omp = new OperationModePrompt(driver);
				
				lp.logIn(email, password);
				logger.info("Successfully logged in");

				omp.selectModeOption();
				logger.info("Operation Mode Selection Mode Displayed");

				omp.selectSuperUser();
				logger.info("Super User Portal Option Selected");

				omp.clickSelect();
				logger.info("Select Button Clicked");

				logger.info("Entered Super User Portal Page");
			}

			public void enterUserInformationDetails()
			{
				SuperUserPortalPage sup = new SuperUserPortalPage(driver);
				CreateNewUser_UserInformationPage uip = new CreateNewUser_UserInformationPage(driver);
				CreateNewUser_AssignCustomersToUserProfilePage ac = new CreateNewUser_AssignCustomersToUserProfilePage(driver);
				CreateNewUser_RolesAndPermissionsPage rap = new CreateNewUser_RolesAndPermissionsPage(driver);

				sup.clickCreateUserLink();
				logger.info("Entered Create User Page");

				//Enter Details Into User Information Page
				uip.setFirstName(name);
				uip.setLastName(lname);
				uip.setEmail(email);
				uip.setPhoneNumber(validPhone);
				uip.clickContinue();

				//Assign Customers To User Profiles
				logger.info("Entered Assign Customers To User Profile Page");
				ac.clickCheckBox();
				ac.clickContinueBtn();

				//Assign User Roles and Permissions
				logger.info("Entered Roles and Permissions Page");
				rap.clickCheckBox();
				rap.clickContBtn();
			}
			
			public void navigateToAdminPage()
			{
				LoginPage lp= new LoginPage(driver);
				OperationModePrompt omp = new OperationModePrompt(driver);
				
				lp.logIn(email, password);
				logger.info("Successfully logged in");

				omp.selectModeOption();
				logger.info("Operation Mode Selection Mode Displayed");

				omp.selectAdmin();
				logger.info("Admin Portal Option Selected");

				omp.clickSelect();
				logger.info("Select Button Clicked");
			
				omp.clickDropdownAdmin();
				logger.info("Clicked dropdown menu for admin customers");
				
				omp.selectAdminCustomer();
				logger.info("Select Customer");
				
				omp.selectBtnAdminCustomer();
				logger.info("Select Customer");

				logger.info("Entered ADMIN Portal Page");
			}

}
