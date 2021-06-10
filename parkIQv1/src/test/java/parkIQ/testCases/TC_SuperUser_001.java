package parkIQ.testCases;

import java.awt.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import parkIQ.pageObjects.SuperUserRole;
import parkIQ.pageObjects.LoginPage;

public class TC_SuperUser_001 extends BaseClass {
	//contains test cases from "create customer service user"
	
	//checkLogo (if displayed correctly)
	//checkTitle
	//checkSectionHeader
	//checkCreateNewUserLink (visible/color/underline)
	//checkSearchBar
		//-check the list of results
	//checkSortByDroppDown (displayed/clickable)
		//- also check the fields and columns
		//- check the osrting by selecting email and validate the relevant results
	
	@Test (priority=0)
	public void  setupSuperUserRole() throws InterruptedException 
	{
		SuperUserRole sp = new SuperUserRole(driver);
		LoginPage lp= new LoginPage(driver);
		
		lp.logIn(email, password);
		logger.info("Successfully logged in");
		sp.showDropdown();
		logger.info("Expanded drop down");
		sp.clickRole();
		logger.info("Clicked super user role");
		sp.clickSelect();
		logger.info("Clicked select button");

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
		
		SuperUserRole sp = new SuperUserRole(driver);
		boolean logo = sp.locateLogo();

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
		
		SuperUserRole sp = new SuperUserRole(driver);
		boolean title = sp.locateTitle();

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
		
		SuperUserRole sp = new SuperUserRole(driver);
		boolean sectionHeader = sp.locateSectionHeader();

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
		SuperUserRole sp = new SuperUserRole(driver);
		boolean createNewUserLink = sp.locateCreateNewUserLink();

		if(createNewUserLink == true)
		{
			logger.info("Create New User link is displayed correctly.Text underlined: " + sp.createNewUserDecoratorBefore()+ "Text color:"+ sp. createNewUserColor());
		}
		else
		{
			logger.info("Create New User link  is missing");
		}
		
	}
	
	@Test(priority=5)
	public void searchFunctionality()
	{
		
		SuperUserRole sp = new SuperUserRole(driver);
		boolean searchBar = sp.locateSearchBar();

		if(searchBar == true)
		{
			logger.info("Search bar is displayed correctly");
		}
		else
		{
			logger.info("Search bar is missing");
		}
//		
//		sp.searchName(inputname);
//		logger.info("Entered name to verify search functionality");
	}
	
	@Test (priority=6)
	public void sortByDropDown()
	{
		SuperUserRole sp = new SuperUserRole(driver);
		boolean sortByDropDown = sp.locateSortByDropDown();

		if(sortByDropDown == true)
		{
			logger.info("Sort By drop down is displayed correctly");
		}
		else
		{
			logger.info("Sort By drop down is missing");
		}
		
		
		//sp.validateValueDropDown();
		
	}

}



