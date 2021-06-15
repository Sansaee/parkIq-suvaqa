package parkIQ.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import parkIQ.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	//Test for invalid email and password
	  @Test(priority=0) 
	  public void validationTest1() throws IOException 
	  {
		  logger.info("BaseUrl is opened");
		  LoginPage lp = new LoginPage(driver);
	  
		  lp.setEmail(invalidemail); 
		  logger.info("Invalid Email is entered");
	  
		  lp.setPassword(invalidpassword); 
		  logger.info("Invalid Password is entered");
	  
		  lp.clickSubmit(); 
		  System.out.print(lp.loginValidation() + "\n");
		  logger.info("Login button is clicked"); 
		  captureScreen(driver, "InvalidLoginTest"); 
		  
	  }
	  
	  //Test for invalid email
	  @Test(priority=1) 
	  public void validationTest2() throws IOException 
	  {
		  driver.get(baseURL); 
		  LoginPage lp = new LoginPage(driver);
	  
		  lp.setEmail(invalidemail); 
		  logger.info("Invalid Email is entered");
	  
		  lp.clickSubmit(); 
		  System.out.print(lp.passwordValidation1() + "\n");
		  System.out.print(lp.passwordValidation2() + "\n");
		  logger.info("Login button is clicked"); 
		  captureScreen(driver, "InvalidPasswordTest"); 
		  
	  }
	
	  //Test for no fields entered
	  @Test(priority=2) 
	  public void validationTest3() throws IOException 
	  {
		  driver.get(baseURL); 
		  LoginPage lp = new LoginPage(driver);
	  
		  lp.clickSubmit(); 
		  System.out.print(lp.emailValidation1() + "\n");
		  System.out.print(lp.emailValidation2() + "\n");
		  System.out.print(lp.passwordValidation1() + "\n");
		  System.out.print(lp.passwordValidation2() + "\n");
		  logger.info("Login button is clicked"); 
		  captureScreen(driver, "NoFieldsFilledTest");
	  
	  }
	  
	  //Login Details Test 1
	  @Test(priority = 3) 
	  public void loginDetailsTest1() throws IOException 
	  {
		  driver.get(baseURL); 
		  LoginPage lp = new LoginPage(driver);
		  lp.txtLoginDisplayed();
		  logger.info("Login is displayed");
		  
	  }

	  //Login Details Test 2
	  @Test(priority = 4)
	  public void loginDetailsTest2() throws IOException 
	  {
		  LoginPage lf = new LoginPage(driver);
		  System.out.print(lf.txtLoginColor() + "\n");
		  logger.info("Login Color is displayed");

			
	  }
		
	  //Login Details Test 3
	  @Test(priority = 5)
	  public void loginDetailsTest3() throws IOException 
	  {
		  LoginPage lf = new LoginPage(driver);
		  System.out.print(lf.txtLoginBackgroundColor() + "\n");
		  logger.info("Login Background Color is displayed");
			
	  }
	  
	  //Login Details Test 4
	  @Test(priority = 6) 
	  public void loginDetailsTest4() throws IOException 
	  {
	  
		  LoginPage lp = new LoginPage(driver);
	  
		  lp.confirmParkIQ();
		  logger.info("Park IQ and Park Industries Business Intelligence is displayed"); 
		  captureScreen(driver, "ParkIQ");
	  
		  lp.confirmSignIn(); 
		  logger.info("Sign In confirmed"); 
		  captureScreen(driver, "SignIn");
	  
		  lp.confirmSignIntxt();
		  System.out.print(lp.confirmSignIntxt() + "\n");
	  
		  lp.emailViewable(); 
		  logger.info("Email text is displayed");
	  
		  lp.emailClickable(); 
		  logger.info("Email textbox is clickable");

	  }
	  
	  //Login Test
	  @Test(priority = 7) 
	  public void loginTest() throws IOException 
	  {
		  LoginPage lp = new LoginPage(driver);
		  
		  lp.setEmail(email); 
		  logger.info("Email is entered");
		  
		  lp.passwordViewable();
		  logger.info("Password text is displayed");
		  
		  lp.passwordClickable();
		  logger.info("Password text is clickable");
		  
		  lp.setPassword(password); 
		  logger.info("Password is entered");
		  
		  lp.clickSubmit(); 
		  logger.info("Login button is clicked");
	  }

}
