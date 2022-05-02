package suntuity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuickBaseLoginPage_Web {
	
	public WebDriver driver;
	
	
	public QuickBaseLoginPage_Web(WebDriver driver) {
		this.driver=driver;
		
	}
@FindBy(xpath="//button[contains(.,'Sign in')]/../input[@name='loginid']")	
public WebElement QUICKBASE_USERNAMEFIELD;

@FindBy(xpath="//button[contains(.,'Sign in')]/../input[@name='password']")	
public WebElement QUICKBASE_PASSWORDFIELD;

@FindBy(id="signin")
public WebElement QUICKBASE_SIGNINBUTTON;
 
@FindBy(xpath="//div[text()='React Sales Dashboard - BETA']")
public WebElement NAVIGATETOLEADONEPAGER;


public void selectsanbox(String Sanbox) {
	try {
		System.out.println(Sanbox);
	driver.findElement(By.partialLinkText(Sanbox)).click();
	}
	catch(Exception e) {
		System.out.println("check selectsanbox Method");
	}
		
}
}
