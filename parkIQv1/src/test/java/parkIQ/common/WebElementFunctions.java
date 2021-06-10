package parkIQ.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementFunctions {
	
	public WebElementFunctions() {
	  }
	  //Implicit Wait Function
	  public void pageLoad(WebDriver ldriver)
	  {
	    ldriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  }

	  //Verify if Element is Clickable
	  public boolean verifyElementIsClickable(WebElement element, WebDriver ldriver)
	  {
	    //wait till element is clickable and displayed
	    try {
	      WebElement elementToBeClickable = new WebDriverWait(ldriver, 3)
	          .until(ExpectedConditions.elementToBeClickable(element));
	      return true;
	    }
	    catch (Exception ex)
	    {
	      return false;
	    }
	  }

	  //Verify if Element is Displayed and Contains Text
	  public boolean verifyElementDisplayedWithText(WebElement webElement, String text)
	  {

	    if(webElement.isDisplayed() && webElement.getText().equals(text))
	    {
	      return true;
	    }
	    else
	    {
	      return false;
	    }
	  }

}
