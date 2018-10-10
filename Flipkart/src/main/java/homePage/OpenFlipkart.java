package homePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OpenFlipkart 
{	
	public Logger log;
	
		
	public  void openApp(WebDriver driver)
	{
		log=Logger.getLogger(OpenFlipkart.class);
		log.info("in ClickOnLogin_SignIN");
		try {
			driver.findElement(By.xpath("//button[text()='✕']")).isDisplayed();
			driver.findElement(By.xpath("//button[text()='✕']")).click();
			driver.navigate().refresh();
		} catch (Exception e) {
			log.info("in catch block of ClickOnLogin_SignIN");
			
		}
		
	}
}
