package homePageTestCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import baseClassFloder.BaseClass;
import homePage.LoginToFlipkart;
import homePage.Logout;
import homePage.OpenFlipkart;

@Listeners(genericUtils.ListenersClass.class)
public class Login extends BaseClass
{
	public WebDriver driver;
	public Logger log;
	public ExtentReports report;
	public ExtentTest Ex_test;
	@BeforeClass
	public void BeforeClass()
	{
		report=new ExtentReports("./Reports/login.html", false);
		Ex_test=report.startTest("Login");
		 loggerSetup();
		 log=Logger.getLogger(Login.class);
		 log.info("before class completed");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		driver=browserInitialization("firefox");
	}
	
	@Test
	public void clickOnLoginButton() throws InterruptedException
	{
		log.info("Entering to flipkart signIn page");
		OpenFlipkart click= PageFactory.initElements(driver, OpenFlipkart.class);
		click.openApp(driver);
		
		Thread.sleep(100);
		
		log.info("Providing user credentials");
		LoginToFlipkart logins=PageFactory.initElements(driver, LoginToFlipkart.class);
		logins.loginToApp();
		log.info("login succesful");
		
		Logout logout=PageFactory.initElements(driver, Logout.class);
		logout.logoutFormFlipkart();
		log.info(" logout successful");
	}
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
		if(result.getStatus()==result.SUCCESS)
		{
			Ex_test.log(LogStatus.INFO, result.getName()+" passed sucessfully....");
			Ex_test.log(LogStatus.INFO, Ex_test.addScreenCapture(getScreenShot(result.getName())));
		}
		else if (result.getStatus()==result.FAILURE) {
			Ex_test.log(LogStatus.ERROR, result.getName()+" is failed....");
			Ex_test.log(LogStatus.ERROR, Ex_test.addScreenCapture(getScreenShot(result.getName())));
		}
		else if (result.getStatus()==result.SKIP) {
			Ex_test.log(LogStatus.SKIP, result.getName()+" has skipped....");
			Ex_test.log(LogStatus.SKIP, Ex_test.addScreenCapture(getScreenShot(result.getName())));
		}
	}
	@AfterClass
	public void closing()
	{
		report.flush();
		report.endTest(Ex_test);
		driver.quit();
	}
}
