package homePageTestCases;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import baseClassFloder.BaseClass;
import homePage.DisplayingSearchResult;
import homePage.OpenFlipkart;
@Listeners(genericUtils.ListenersClass.class)
public class GettingDetailsOfProduct extends BaseClass
{
	Logger log;
	ExtentReports report;
	ExtentTest ex_test;
	WebDriver driver;
	@BeforeClass
	public void beforeClass()
	{
		
		report=new ExtentReports("./Reports/GettingDetailsOfProduct.html");
		ex_test=report.startTest("GettingDetailsOfProduct");
	}
	
	@BeforeMethod
	public void setup()
	{
		loggerSetup();
		log=Logger.getLogger(GettingDetailsOfProduct.class);
		log.info("setuping the browser setting");
		driver=browserInitialization("firefox");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
	
	@Test
	public void gettingDetails()
	{
		log.info("opening flipkart application");
		OpenFlipkart open=PageFactory.initElements(driver, OpenFlipkart.class);
		open.openApp(driver);
		ex_test.log(LogStatus.INFO, "Flipkart application opened");
		
		log.info("entering product details");
		DisplayingSearchResult prod=PageFactory.initElements(driver, DisplayingSearchResult.class);
		prod.searchForProdInfo("Apple iPhone X (Silver, 256 GB)");
		ex_test.log(LogStatus.INFO, "product info");
		
		driver.findElement(By.xpath("//a[@title='Apple iPhone X (Silver, 256 GB)']")).click();
	}
}
