package pageobject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ActiveProjectsAndCustomersPage {

	@FindBy(xpath="//input[@value='Add New Customer']")
	
		private WebElement addNewCustomerButton;
	
	@FindBy(className="successmsg")
	private WebElement successmessage;
	
	@FindBy(linkText="customername")
	private WebElement selectcustomerfromthelist;
	
	@FindBy(xpath="//input[@value='Add New Project']")
	WebElement addNewprojectButton;
	
	public ActiveProjectsAndCustomersPage()
	{
		PageFactory.initElements(Baseclass.driver,this);
	}
	
	public void clickonAddNewCustomerButton()
	{
		addNewCustomerButton.click();
	}
	
	public String retrievemessage()
	{
		String s=successmessage.getText();
		return s;
	}
	
	public void selectcustomerfromthelist(String customername)
	{
		
		Select s =new Select(selectcustomerfromthelist);
		s.selectByVisibleText(customername);
		
	}
public void clickonAddNewprojectButton()
{
	
	addNewprojectButton.click();
}
}


