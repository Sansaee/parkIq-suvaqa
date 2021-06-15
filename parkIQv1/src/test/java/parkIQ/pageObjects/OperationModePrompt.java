package parkIQ.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import parkIQ.common.WebElementFunctions;

public class OperationModePrompt {
	
	//page object for selecting role

	 WebDriver ldriver;

		public OperationModePrompt(WebDriver rdriver) //a constructor; ldiver = local driver, rdriver = remote driver
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
			
		}

			//operation mode prompt
			@FindBy(xpath="//h4[@id='modal-basic-title']")
			@CacheLookup
			WebElement operationMode;

			//dropdown selection
			@FindBy(xpath="//body/ngb-modal-window[1]/div[1]/div[1]/div[2]/ng-select[1]/div[1]")
			@CacheLookup
			WebElement ddModeSelection;

			//Admin Portal
			@FindBy(xpath="//span[contains(text(),'Admin Portal')]")
			@CacheLookup
			WebElement adminModalSelection;

			//Customer Service Portal
			@FindBy(xpath="//span[contains(text(),'Customer Service Portal')]")
			@CacheLookup
			WebElement customerServicePortalSelection;

			//Super User Portal
			@FindBy(xpath="//span[contains(text(),'Super User Portal')]")
			@CacheLookup
			WebElement superUserPortalSelection;

			//Select Button
			@FindBy(xpath="//button[contains(text(),'Select')]")
			@CacheLookup
			WebElement btnSelect;


			WebElementFunctions func = new WebElementFunctions();


			public void selectModeOption()
			{
				WebDriverWait waitElement = new WebDriverWait(ldriver, 20);
				waitElement.until(ExpectedConditions.visibilityOf(operationMode));
				ddModeSelection.click();
			}

			public void selectAdmin()
			{
				adminModalSelection.click();
			}

			public void selectCustomer()
			{
				customerServicePortalSelection.click();
			}

			public void selectSuperUser()
			{
				superUserPortalSelection.click();
			}

			public void clickSelect()
			{
				btnSelect.click();
			}
}
