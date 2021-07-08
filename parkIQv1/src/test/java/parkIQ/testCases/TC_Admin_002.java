package parkIQ.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import parkIQ.common.CommonFunctions;
import parkIQ.pageObjects.AdminSchedule;

public class TC_Admin_002 extends BaseClass{
	
	//Test that Setup is Successful
			@Test(priority = 0)
			public void setupAdminRole() throws InterruptedException {
				
				logger.info("ADMIN TEST CASES - SCHEDULE");
				
				CommonFunctions cf = new CommonFunctions();
				cf.navigateToAdminPage();

		
				//verify page is redirected to admin page
				if (driver.getTitle().equals("Park IQ Admin")) {
					Assert.assertTrue(true);
					logger.info("User navigated to Admin Portal" + "\n");

				} else {
					Assert.assertTrue(false);
					logger.info("Navigation of user to admin page test failed" + "\n");
				}
			}
			
			@Test(priority = 1)
			public void testScheduleTab()
			{
				AdminSchedule as = new AdminSchedule(driver);
				boolean isTabScheduleClickable = as.tabScheduleDisplayedClickable();
				if (isTabScheduleClickable) {
					Assert.assertTrue(true);
					logger.info("Schedule tab is displayed and clickable");
				} else {
					Assert.assertTrue(false);
					logger.info("Schedule tab is missing");
				}
			}	
			
			@Test(priority =2)
			public void testScheduleForm()
			{
				AdminSchedule as = new AdminSchedule(driver);
				as.clickScheduleTab();
				logger.info("Click schedule tab and user should be navigated to schedule form");
				
				//if Schedule header is displayed
				boolean isHeaderDisplayed = as.verifyHeader();
				if(isHeaderDisplayed)
				{
					Assert.assertTrue(true);
					logger.info("Schedule header displayed correctly" +"\n");

				}
				else {
					Assert.assertTrue(false);
					logger.info("Schedule header is missing" +"\n");
				}
				
				//if shifts field is displayed
				boolean isShiftsDisplayed = as.verifyShiftsField();
				if(isShiftsDisplayed)
				{
					Assert.assertTrue(true);
					logger.info("Shifts field displayed correctly" +"\n");

				}
				else {
					Assert.assertTrue(false);
					logger.info("Shifts field is missing" +"\n");
				}
				
			}
			
			@Test(priority=3)
			public void testDayShift()
			{
				AdminSchedule as = new AdminSchedule(driver);
				//if day shift field is displayed
				boolean isDayShiftsDisplayed = as.verifyDayShiftField();
				if(isDayShiftsDisplayed)
				{
					Assert.assertTrue(true);
					logger.info("Day Shift field displayed correctly" +"\n");

				}
				else {
					Assert.assertTrue(false);
					logger.info("Day Shift field is missing" +"\n");
				}
				
				as.clickEditDayShift();
				logger.info("Clicked edit day shift field");
			}
			
			@Test(priority=4)
			public void testNightShift()
			{
				AdminSchedule as = new AdminSchedule(driver);
				//if night shift field is displayed
				boolean isNightShiftsDisplayed = as.verifyNightShiftField();
				if(isNightShiftsDisplayed)
				{
					Assert.assertTrue(true);
					logger.info("Night shift field displayed correctly" +"\n");

				}
				else {
					Assert.assertTrue(false);
					logger.info("Night shift field is missing" +"\n");
				}
				
			}
			

}
