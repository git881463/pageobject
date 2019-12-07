package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Addnewproject  {
	
@FindBy(xpath="//input[@value='Add New Project']") 
private WebElement addnewproject;

@FindBy(name="customerId")
private WebElement selectcustomernamefromdropdown;

@FindBy(name="name")
private WebElement enterprojectname;

@FindBy(xpath="//input[@value='Create Project']")
private WebElement createbutton;

public  Addnewproject()
{
	PageFactory.initElements(Baseclass.driver, this);
}

public void clickonAddnewproject()
{
	addnewproject.click();
	
}


public void clickonenterprojectname(String customername)
{
	enterprojectname.sendKeys(customername);
	
}

public void clickoncreatebutton()
{
	createbutton.click();
}

public void clickonselectcustomernamefromdropdown() {
	

	Select s=new Select(selectcustomernamefromdropdown);
	s.selectByVisibleText("Arjun");
	
}

}
