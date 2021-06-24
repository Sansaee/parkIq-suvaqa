package parkIQ.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import parkIQ.common.CommonFunctions;
import parkIQ.pageObjects.CreateCustomerServiceUser;
import parkIQ.pageObjects.LoginPage;
import parkIQ.pageObjects.OperationModePrompt;
import parkIQ.pageObjects.SuperUserPortalPage;

public class TC_SuperUser_001 extends BaseClass {
	//contains test cases from "create customer service user"

	@Test (priority=0)
	public void  setupSuperUserRole() throws InterruptedException 
	{
		logger.info("SUPER USER ROLE TEST CASES - CREATE CUSTOMER SERVICE USER");

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
		
		Thread.sleep(3000);

	}
	
	@Test (priority=1)
	public void  checkLogo() throws Exception 
	{
		//confirm that logo is displayed
		//confirm that title beneath logo is displayed - title is part of the logo
		
		CreateCustomerServiceUser cs = new CreateCustomerServiceUser(driver);
		boolean logo = cs.locateLogo();

		if(logo == true)
		{
			logger.info("Logo is displayed correctly");
		}
		else
		{
			logger.info("Logo is missing");
		}
		
	}

	@Test(priority=2)
	public void checkTitles()
	{
	//confirm that title "Create Customer Service User" is displayed
		//"Users" should be displayed 
		//Create new user link is displayed & Underlined & position is correct
		
		CreateCustomerServiceUser cs = new CreateCustomerServiceUser(driver);
		boolean title = cs.locateTitle();

		if(title == true)
		{
			logger.info("Create Customer Service User title is displayed correctly");
		}
		else
		{
			logger.info("Create Customer Service User title is missing");
		}
		
	}
	
	@Test(priority=3)
	public void  checkSectionHeader() {
		
		CreateCustomerServiceUser cs = new CreateCustomerServiceUser(driver);
		boolean sectionHeader = cs.locateSectionHeader();

		if(sectionHeader == true)
		{
			logger.info("Users section header is displayed correctly");
		}
		else
		{
			logger.info("Users section header is missing");
		}

	}
	@Test(priority=4)
	public void checkCreateNewUserLink()
	{
		//also need to validate color and underline
		//insert assert function
		CreateCustomerServiceUser cs = new CreateCustomerServiceUser(driver);
		boolean createNewUserLink = cs.locateCreateUserLink();

		if(createNewUserLink == true)
		{
			logger.info("Create New User link is displayed correctly.Text underlined: " + cs.createUserDecoratorBefore()+ "Text color:"+ cs.createUserColor());
		}
		else
		{
			logger.info("Create New User link  is missing");
		}
		
	}
	
	@Test(priority=5)
	public void searchFunctionality()
	{
		
		CreateCustomerServiceUser cs = new CreateCustomerServiceUser(driver);
		boolean searchBar = cs.locateSearchBar();

		if(searchBar == true)
		{
			logger.info("Search bar is displayed correctly");
		}
		else
		{
			logger.info("Search bar is missing");
		}
		
		//left to validate searchh result

	}
	
	@Test (priority=6)
	public void sortByDropDown()
	{
		CreateCustomerServiceUser cs = new CreateCustomerServiceUser(driver);
		boolean sortByDropDown = cs.displaySortByDD();

		if(sortByDropDown == true)
		{
			logger.info("Sort By drop down is displayed correctly with all necessary fields");
		}
		else
		{
			logger.info("Sort By drop down is missing");
		}
		
		//left to test sort by field test
	}
	
	@Test (priority=7)
	public void testColumns()
	{
		CreateCustomerServiceUser cs = new CreateCustomerServiceUser(driver);
		boolean column = cs.locateColumnHeaders();

		if(column == true)
		{
			logger.info("Displays column headers correctly");
		}
		else
		{
			logger.info("Column headers are not displayed correctly");
		}
		
	}

}



