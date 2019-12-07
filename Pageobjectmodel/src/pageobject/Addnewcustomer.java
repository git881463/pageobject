package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addnewcustomer {
 
	@FindBy(name="name")
	private WebElement customerNametextField;
	
	@FindBy(name="createCustomerSubmit")
	private WebElement createCustomerButton;
	
	public Addnewcustomer()

	{
	 PageFactory.initElements(Baseclass.driver,this);
	 
	}
	public void EnterCustomerName(String customername)
	{
		customerNametextField.sendKeys(customername);
	}
	public void ClickOnCreateCustomerButton()
	{
		createCustomerButton.click();
	}

	
	
}
