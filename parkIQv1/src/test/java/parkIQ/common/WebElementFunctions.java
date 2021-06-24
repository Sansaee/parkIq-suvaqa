package parkIQ.common;

import java.util.List;
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
	public void pageLoad(WebElement element, WebDriver ldriver)
	{
		//wait till element is clickable and displayed
		try {
			WebDriverWait wait = new WebDriverWait(ldriver, 120);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	//Verify if Element is Clickable
	public void waitLoaderDisappear(WebElement element, WebDriver ldriver)
	{
		//wait till element is clickable and displayed
		try {
			WebDriverWait wait = new WebDriverWait(ldriver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.invisibilityOf(element));
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	//Returns true if toaster notification is displayed
	public String visibilityOfToasterNotification(WebElement element, WebDriver ldriver)
	{
		try {
			WebDriverWait wait = new WebDriverWait(ldriver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.getText();
		}
		catch (Exception ex)
		{
			return ex.toString();
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

	  //Return count of checkboxes selected/checked
		public int isChecked(WebDriver driver, String path)
		{
			int checkedCount = 0;
			List<WebElement> elements = driver.findElements(By.xpath(path));
			for(int i = 0; i < elements.size(); i++)
			{
				if(elements.get(i).isSelected())
				{
					checkedCount++;
				}
			}
			return checkedCount;
		}

	//List of Checkboxes are clickable
	public void isCheckBoxClickable(WebDriver driver, String path)
	{

		List<WebElement> elements = driver.findElements(By.xpath(path));
		WebDriverWait wait = new WebDriverWait(driver, 3);

		for(int i = 0; i < elements.size(); i++) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(elements.get(i)));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	//List of Elements is Displayed
	public boolean isElementsDisplayed(WebDriver driver, String path)
	{
		int elementCount = 0;

		List<WebElement> elements = driver.findElements(By.xpath(path));
		WebDriverWait wait = new WebDriverWait(driver, 3);

		for(int i = 0; i < elements.size(); i++) {
			try {
				wait.until(ExpectedConditions.visibilityOf(elements.get(i)));
				if (elements.get(i).isDisplayed())
				{
					elementCount++;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if(elementCount == elements.size())
		{
			return true;
		}
		else { return false;}
	}

	//Elements Read Only
	public boolean isReadOnly(WebElement webElement) {
		try {
			webElement.sendKeys("Editable");
			return false;
		} catch (Exception ex) {
			return true;
		}
	}
}
