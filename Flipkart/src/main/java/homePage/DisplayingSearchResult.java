package homePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DisplayingSearchResult 
{
	@FindBy(how=How.XPATH, using="//*[@title='Search for products, brands and more']")
	WebElement productSerachBox;
	
	@FindBy(how=How.XPATH, using="//button[@type='submit']")
	WebElement searchClick;
	
	public void searchForProdInfo(String prodName)
	{
		productSerachBox.sendKeys(prodName);
		searchClick.click();
		
	}
}
