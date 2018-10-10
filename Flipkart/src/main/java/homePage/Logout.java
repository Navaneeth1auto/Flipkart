package homePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Logout 
{
	@FindBy(how=How.XPATH, using="(//*[@class='row'])[2]")
	WebElement signout_option;
	
	@FindBy(how=How.XPATH, using="//*[text()='Logout']")
	WebElement logout_button;
	
	public void logoutFormFlipkart() throws InterruptedException
	{
		signout_option.click();
		Thread.sleep(100);
		logout_button.click();
		Thread.sleep(500);
	}
}
