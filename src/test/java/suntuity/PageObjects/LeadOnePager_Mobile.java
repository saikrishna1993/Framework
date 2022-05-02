package suntuity.PageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadOnePager_Mobile {
	public WebDriver driver;
	
	public LeadOnePager_Mobile(WebDriver driver) {

		this.driver = driver;
	}
	
	@FindBy(xpath = "//input[@name='loginid']")
	public WebElement Mobile_UsernameField;
	
	@FindBy(xpath = "//input[@name='password']")
	public WebElement Mobile_PasswordField;
	
	@FindBy(xpath = "//input[@id='signin']")
	public WebElement Mobile_LoginButton;
	
	
}

