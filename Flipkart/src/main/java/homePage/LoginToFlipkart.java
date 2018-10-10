package homePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginToFlipkart 
{
	@FindBy(how = How.XPATH, using = "//a[text()='Login & Signup']") 
	private WebElement login_button;
	
	@FindBy(how = How.XPATH, using="//input[@class='_2zrpKA']")
	private WebElement userName;
	
	@FindBy(how = How.XPATH, using="//input[@type='password']")
	private WebElement password;
	
	@FindBy(how = How.XPATH, using="(//*[text()='Login'])[2]")
	private WebElement clickOnLogin;
	
	
	public void loginToApp() throws InterruptedException
	{
		login_button.click();
		
		Thread.sleep(50);
		userName.click();
		userName.sendKeys("9900877870");
		Thread.sleep(50);
		password.sendKeys("nav@12345");
		Thread.sleep(50);
		clickOnLogin.click();
	}
}
