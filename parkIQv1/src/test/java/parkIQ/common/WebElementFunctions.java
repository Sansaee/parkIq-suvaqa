package parkIQ.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementFunctions {
	
	public WebElementFunctions() {
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

	//Verify if Element is Clickable
	public void waitLoaderDisappear(WebElement element, WebDriver ldriver)
	{
		//wait till element is clickable and displayed
		try {
			WebDriverWait wait = new WebDriverWait(ldriver, 3);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.invisibilityOf(element));
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
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
