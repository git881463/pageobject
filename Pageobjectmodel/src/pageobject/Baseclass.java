package pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners
public class Baseclass {

	public static WebDriver driver;

	String url=Exceloperations.readdata("sheet2",1,0);
	String un=Exceloperations.readdata("sheet2",1,1);
	String pwd=Exceloperations.readdata("sheet2",1,2);
	String Exp=Exceloperations.readdata("sheet2",1,3);
    String browser=Exceloperations.readdata("sheet2",1,6);
	

	
	@BeforeTest
	public void openbrowser()
	{    
		if(browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","F:\\64bitAutomationSW/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","F:\\64bitAutomationSW/geckodriver.exe");
			driver= new FirefoxDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		}
	 
		else
		{
			System.out.println("INVALID BROWSER");
		}
	}
	@AfterTest
	public void closebrowser()
	{
		driver.close();
		
	}
   @BeforeClass
   public void Login()
   {
	   driver.findElement(By.name("username")).sendKeys(un);
	   driver.findElement(By.name("pwd")).sendKeys(pwd);
	   driver.findElement(By.xpath("//input[@type='submit']")).click();
	   driver.navigate().refresh();
	   String Act=driver.getTitle();
	   Exceloperations.writedata("sheet2",1,4,Act);
	   if(Exp.equals(Act))
	   {
		   Exceloperations.writedata("sheet2",1,5,"pass");
	   }
	   else
	   {
		   Exceloperations.writedata("sheet2",1,5,"fail");
	   }
   }
	 


   @AfterClass
   public void Logout()
   {
	   driver.findElement(By.className("logoutImg")).click();
   }
   
   
   

}
